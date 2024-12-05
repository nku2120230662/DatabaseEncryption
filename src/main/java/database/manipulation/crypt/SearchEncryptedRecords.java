package database.manipulation.crypt;

import database.config.Connector;
import encryption.symmetric.SymmetricEncryption;

import java.sql.ResultSet;
import java.sql.Statement;

public class SearchEncryptedRecords {

    public static boolean SearchEncryptedStudent() throws Exception{
        Connector mc = new Connector();
        Statement stmt = null;
        stmt = mc.getConnection().createStatement();

        ResultSet rs = stmt.executeQuery("select * from encrypted_students");
        // 展开结果集数据库
        while (rs.next()) {
            // 通过字段检索
            String en_id=rs.getString("en_id");
            String id= SymmetricEncryption.Decrypt(en_id);
            // 输出数据
            System.out.print("ID: " + id);
            System.out.print("\n");
        }
        stmt.close();
        mc.closeConnection();
        return true;
    }
}
