package database.manipulation.crypt;
/*
 * 对插入语句进行处理并完成插入操作
 * 实现逻辑
 * 逻辑1：本类只进行加密字段重写，最后由普通插入语句调用
 * 逻辑2：接收原始插入语句，经过处理后执行插入操作
 * */

import database.config.Connector;
import encryption.symmetric.SymmetricEncryption;

import java.sql.Connection;
import java.sql.Statement;

public class InsertEncryptedRecords {

    public static boolean InsertEncryptedStudent()throws Exception{
        String en_id= SymmetricEncryption.Encrypt(1234);
        String en_name= SymmetricEncryption.Encrypt("name");
        String sql="insert into encrypted_students values (" +
                "'" +en_id+ "'"+
                ",'" +en_name+ "'"+
                ")";
        System.out.println(sql);
        Connector mc = new Connector();
        Connection conn=mc.getConnection();
        Statement stmt=conn.createStatement();
        int result=stmt.executeUpdate(sql);
        if (result>0){
            stmt.close();
            conn.close();
            System.out.println("Record Inserted");
            return true;
        }
        stmt.close();
        conn.close();
        System.out.println("insert failed");
        return false;
    }

}

