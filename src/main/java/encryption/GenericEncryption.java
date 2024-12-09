package encryption;

public interface GenericEncryption {
    public String Encrypt(String plainText, String key) throws Exception;
    public String Decrypt(String cipherText, String key);
}
