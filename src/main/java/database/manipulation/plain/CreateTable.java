package database.manipulation.plain;

import database.config.Connector;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTable {
    public static boolean CreateCourses() throws Exception{
        Connector mc = new Connector();
        Connection conn=mc.getConnection();
        String sql="CREATE TABLE IF NOT EXISTS " +
                "courses " +
                "(" +
                "course_id INT," +
                "grade DECIMAL," +
                "s_id INT " +
                ")";
        Statement stmt=conn.createStatement();
        int result=stmt.executeUpdate(sql);//"CREATE TABLE IF NOT EXISTS courses (course_id INT,grade DECIMAL,s_id INT);"
        if(result==0){
            System.out.println("Table Cources created");
            stmt.close();
            conn.close();
            return true;
        }
        System.out.println("Table Cources failed");
        stmt.close();
        conn.close();
        return false;
    }

    public static boolean CreateEncryptedStudents() throws Exception{
        Connector mc = new Connector();
        Connection conn=mc.getConnection();
        String sql="CREATE TABLE IF NOT EXISTS " +
                "encrypted_students " +
                "(" +
                "en_id VARCHAR(255)," +
                "en_name VARCHAR(255)" +
                ")";
        Statement stmt=conn.createStatement();
        int result=stmt.executeUpdate(sql);//
        if(result==0){
            System.out.println("Table encrypted_students created");
            stmt.close();
            conn.close();
            return true;
        }
        System.out.println("Table encrypted_students failed");
        stmt.close();
        conn.close();
        return false;
    }

}
