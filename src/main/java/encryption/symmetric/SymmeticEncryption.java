package encryption.symmetric;

public class SymmeticEncryption {
    public static String Encrypt(Object obj) {
        switch(obj.getClass().getName()) {
            case "java.lang.Integer":
                System.out.println("INT11");
                return obj.toString();
            case "java.lang.String":
                System.out.println("String11");
                return obj.toString();
            default:
                System.out.println(obj.getClass().getName());
                return obj.toString();
        }
    }
}
