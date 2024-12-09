package encryption.symmetric;

import encryption.function.SimpleAES;

public class SymmetricEncryption {
    public static String Encrypt(Object obj) throws Exception {
        switch(obj.getClass().getName()) {
            case "java.lang.Integer":
                return SimpleAES.encrypt(String.valueOf((int)obj));
            case "java.lang.String":
                String cipherText = SimpleAES.encrypt((String) obj);
                return cipherText;
            default:
                System.out.println(obj.getClass().getName());
                return obj.toString();
        }
    }

    public static String Decrypt(String CipherText)throws Exception {

        String DecryptedText = SimpleAES.decrypt(CipherText);

        return DecryptedText;
    }
}
