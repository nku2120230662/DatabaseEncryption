package encryption.symmetric;

import encryption.function.AESExample;

public class SymmetricEncryption {
    public static String Encrypt(Object obj) throws Exception {
        switch(obj.getClass().getName()) {
            case "java.lang.Integer":
                System.out.println("INT11");
                return obj.toString();
            case "java.lang.String":
                String cipherText = AESExample.encrypt((String) obj);
                System.out.println(cipherText);
                return cipherText;
            default:
                System.out.println(obj.getClass().getName());
                return obj.toString();
        }
    }

    public static String Decrypt(String CipherText)throws Exception {

        String DecryptedText = AESExample.decrypt(CipherText);

        return DecryptedText;
    }
}
