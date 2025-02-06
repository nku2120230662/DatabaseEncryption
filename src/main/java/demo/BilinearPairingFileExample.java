package demo;

import it.unisa.dia.gas.jpbc.Field;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.PairingParameters;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import it.unisa.dia.gas.plaf.jpbc.pairing.a.TypeACurveGenerator;


import java.io.*;
import java.util.Base64;

public class BilinearPairingFileExample {

    public static void main(String[] args) {
        String filePath = "pairingData.txt";

        // Step 1: Generate pairing parameters and elements, then save to file
        try {
            int rBits = 32;
            int qBits = 36;
            TypeACurveGenerator pg = new TypeACurveGenerator(rBits, qBits);
            PairingParameters params = pg.generate();
//            PairingParameters params = PairingFactory.getInstance().getPairingParameters("SS512"); // 示例使用SS512类型
            Pairing pairing = PairingFactory.getPairing(params);

            Element g1 = pairing.getG1().newRandomElement().getImmutable();
            System.out.println("g1: " + g1);
            Element g2 = pairing.getG2().newRandomElement().getImmutable();
            System.out.println("g2: " + g2);
            Field Zr=pairing.getZr();
            Element zr = pairing.getZr().newRandomElement().getImmutable();
            System.out.println("Zr: " + zr);

            saveElementsToFile(g1.toBytes(), g2.toBytes(), zr.toBytes(),filePath);
            System.out.println("G1 and G2 elements saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 2: Read elements from file
        try {
//            PairingParameters params = PairingFactory.getInstance().getPairingParameters("SS512");
            int rBits = 32;
            int qBits = 36;
            TypeACurveGenerator pg = new TypeACurveGenerator(rBits, qBits);
            PairingParameters params = pg.generate();

            Pairing pairing = PairingFactory.getPairing(params);

            byte[][] elementsBytes = readElementsFromFile(filePath);
            Element g1Recovered = pairing.getG1().newElementFromBytes(elementsBytes[0]).getImmutable();
            Element g2Recovered = pairing.getG2().newElementFromBytes(elementsBytes[1]).getImmutable();
            Element zrRecovered = pairing.getZr().newElementFromBytes(elementsBytes[2]).getImmutable();

            System.out.println("Recovered G1 element: " + g1Recovered);
            System.out.println("Recovered G2 element: " + g2Recovered);
            System.out.println("Recovered Zr element: " + zrRecovered);




        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveElementsToFile(byte[] g1, byte[] g2, byte[] zr,String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(Base64.getEncoder().encodeToString(g1));
            oos.writeObject(Base64.getEncoder().encodeToString(g2));
            oos.writeObject(Base64.getEncoder().encodeToString(zr));
        }
    }

    private static byte[][] readElementsFromFile(String filePath) throws IOException, ClassNotFoundException {
        byte[][] result = new byte[3][];
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            result[0] = Base64.getDecoder().decode((String) ois.readObject());
            result[1] = Base64.getDecoder().decode((String) ois.readObject());
            result[2]=Base64.getDecoder().decode((String) ois.readObject());
        }
        return result;
    }
}