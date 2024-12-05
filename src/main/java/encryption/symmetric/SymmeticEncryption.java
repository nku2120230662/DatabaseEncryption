package encryption.symmetric;

public class SymmeticEncryption {
    public static String Encrypt(Object obj) {
        switch(obj.getClass().getName()) {
            case "java.lang.Integer":
                System.out.println("INT11");
                return obj.toString();
            case "java.lang.String":
                String cipherText = (String) obj+"abc";
                System.out.println(cipherText);
                return cipherText;
            default:
                System.out.println(obj.getClass().getName());
                return obj.toString();
        }
    }

    public static String Decrypt(String CipherText) {

        String DecryptedText = CipherText.substring(0,CipherText.length()-3);

        return DecryptedText;
    }
}
