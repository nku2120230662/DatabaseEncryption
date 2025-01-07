package encryption.parameter;

//参考文档：https://blog.csdn.net/qq_41359358/article/details/111158239?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7EPaidSort-1-111158239-blog-107325591.235%5Ev43%5Epc_blog_bottom_relevance_base8&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7EPaidSort-1-111158239-blog-107325591.235%5Ev43%5Epc_blog_bottom_relevance_base8&utm_relevant_index=1

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Field;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.jpbc.PairingParameters;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import it.unisa.dia.gas.plaf.jpbc.pairing.a.TypeACurveGenerator;


public class BilinearGroup {
    Field G1;
    Field G2;
    Field Gt;

    public static void main(String[] args) {
        // 一、定义椭圆曲线参数
        // 1.从文件导入椭圆曲线参数
//        Pairing bp = PairingFactory.getPairing("a.properties");

        // 2.自定义曲线参数
         int rBits = 36;
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
}
