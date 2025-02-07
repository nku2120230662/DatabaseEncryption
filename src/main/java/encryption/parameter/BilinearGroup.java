package encryption.parameter;

//参考文档：https://blog.csdn.net/qq_41359358/article/details/111158239?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7EPaidSort-1-111158239-blog-107325591.235%5Ev43%5Epc_blog_bottom_relevance_base8&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7EPaidSort-1-111158239-blog-107325591.235%5Ev43%5Epc_blog_bottom_relevance_base8&utm_relevant_index=1

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Field;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.jpbc.PairingParameters;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import it.unisa.dia.gas.plaf.jpbc.pairing.a.TypeACurveGenerator;

import java.io.*;
import java.util.Base64;

// 作用：返回一个群
public class BilinearGroup {
    Field G1;
    Field G2;
    Field Gt;

    /**
     *AutoParing : 自动生成配对参数，即时配对
     */
    public void AutoParing() {
        // 一、定义椭圆曲线参数
         int rBits = 32;
         int qBits = 36;
         TypeACurveGenerator pg = new TypeACurveGenerator(rBits, qBits);
         PairingParameters pp = pg.generate();
         Pairing bp = PairingFactory.getPairing(pp);

        // 二、选择群上的元素
        Field G1 = bp.getG1();
        Field G2 = bp.getG2();
        Field Zr = bp.getZr();
        //获取G1/G2的一个元素
        Element g1 = G1.newRandomElement().getImmutable();
        Element g2 = G2.newRandomElement().getImmutable();
        Element a = Zr.newRandomElement().getImmutable();
        Element b = Zr.newRandomElement().getImmutable();

        // 三、计算等式e(g^a,g^b)
        Element ga = g1.powZn(a);
        Element gb = g1.powZn(b);
        Element egg_a_b = bp.pairing(ga,gb);

        // 四、计算等式e(g,g)^(ab)
        Element egg = bp.pairing(g1, g1).getImmutable();
        Element ab = a.mul(b);
        Element egg_ab = egg.powZn(ab);

        if (egg_a_b.isEqual(egg_ab)) {
            System.out.println(egg_a_b);
            System.out.println("yes");
        }
        else {
            System.out.println("No");
        }
    }

    /**
     * MyParing: 从文件中读取配对参数，即时配对
     */
    public void MyParing() {
        // 一、定义椭圆曲线参数
        int rBits = 32;
        int qBits = 36;
        String filePath = "pairingData.txt";

        try {
//            PairingParameters params = PairingFactory.getInstance().getPairingParameters("SS512");
            TypeACurveGenerator pg = new TypeACurveGenerator(rBits, qBits);
            PairingParameters params = pg.generate();

            // 二、选择群上的元素
            Pairing bilinearPairing = PairingFactory.getPairing(params);
            Field Zr = bilinearPairing.getZr();
            //获取G1/G2的一个元素
            Element a = Zr.newRandomElement().getImmutable();
            Element b = Zr.newRandomElement().getImmutable();

            //三、读取g1、g2
            byte[][] elementsBytes = readElementsFromFile(filePath);
            Element g1 = bilinearPairing.getG1().newElementFromBytes(elementsBytes[0]).getImmutable();
            Element g2 = bilinearPairing.getG2().newElementFromBytes(elementsBytes[1]).getImmutable();

            System.out.println("Recovered G1 element: " + g1);
            System.out.println("Recovered G2 element: " + g2);

            // 三、计算等式e(g^a,g^b)
            Element ga = g1.powZn(a);
            Element gb = g1.powZn(b);
            Element egg_a_b = bilinearPairing.pairing(ga,gb);

            // 四、计算等式e(g,g)^(ab)
            Element egg = bilinearPairing.pairing(g1, g1).getImmutable();
            Element ab = a.mul(b);
            Element egg_ab = egg.powZn(ab);

            if (egg_a_b.isEqual(egg_ab)) {
                System.out.println(egg_a_b);
                System.out.println("yes");
            }
            else {
                System.out.println("No");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean SavingParams(String filePath,int rBits, int qBits) {
        try {
            TypeACurveGenerator pg = new TypeACurveGenerator(rBits, qBits);
            PairingParameters params = pg.generate();
//            PairingParameters params = PairingFactory.getInstance().getPairingParameters("SS512"); // 示例使用SS512类型
            Pairing pairing = PairingFactory.getPairing(params);

            Element g1 = pairing.getG1().newRandomElement().getImmutable();
            System.out.println("g1: " + g1);
            Element g2 = pairing.getG2().newRandomElement().getImmutable();
            System.out.println("g2: " + g2);

            saveElementsToFile(g1.toBytes(), g2.toBytes(),filePath);
            System.out.println("G1 and G2 elements saved to file.");
            return true;
        } catch (IOException e) {
            return false;
//            e.printStackTrace();
        }
    }

    private void saveElementsToFile(byte[] g1, byte[] g2, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(Base64.getEncoder().encodeToString(g1));
            oos.writeObject(Base64.getEncoder().encodeToString(g2));
        }
    }

    private static byte[][] readElementsFromFile(String filePath) throws IOException, ClassNotFoundException {
        byte[][] result = new byte[2][];
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            result[0] = Base64.getDecoder().decode((String) ois.readObject());
            result[1] = Base64.getDecoder().decode((String) ois.readObject());
        }
        return result;
    }

}
