package database.manipulation.crypt;

import encryption.symmetric.SymmetricEncryption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchEncryptedRecords {

    public static boolean SearchEncryptedStudents(Connection conn) throws Exception{
        Statement stmt = conn.createStatement();

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
        return true;
    }

    public static boolean SearchEncryptedCourses(Connection conn) throws Exception{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("select * from encrypted_courses");
        // 展开结果集数据库
        while (rs.next()) {
            // 通过字段检索
            String en_id=rs.getString("en_course_id");
            String id= SymmetricEncryption.Decrypt(en_id);
            // 输出数据
            System.out.print("ID: " + id);
            System.out.print("\n");
        }
        stmt.close();
        return true;
    }
}
