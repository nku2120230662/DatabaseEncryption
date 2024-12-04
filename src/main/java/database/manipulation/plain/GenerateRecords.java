package database.manipulation.plain;

import database.config.Connector;

import java.sql.Connection;
import java.sql.Statement;

public class GenerateRecords {
    public static boolean GenerateCourseRecord() throws Exception{
        String sql="insert into courses values(" +
                "1," +
                "2," +
                "3" +
                ")";
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
