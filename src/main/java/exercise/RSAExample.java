package exercise;

import java.security.*;
import java.util.Base64;
import javax.crypto.Cipher;

public class RSAExample {

    public static void main(String[] args) throws Exception {

        // 1. 生成 RSA 密钥对
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512); // 设置密钥长度，建议为 2048 位或更高
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        String base64PublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String base64PrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        System.out.println("公钥是："+ base64PublicKey);
        System.out.println("私钥是："+ base64PrivateKey);

        System.out.println("RSA 密钥对生成成功！");

        // 2. 原始数据
        String plainText = "Hello, this is a test for RSA encryption!";
        System.out.println("原始数据: " + plainText);

        // 3. 使用公钥加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        System.out.println("加密后的数据: " + bytesToHex(encryptedBytes));

        // 4. 使用私钥解密
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedText = new String(decryptedBytes);
        System.out.println("解密后的数据: " + decryptedText);


    }

    // 辅助方法：将字节数组转换为十六进制字符串
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
