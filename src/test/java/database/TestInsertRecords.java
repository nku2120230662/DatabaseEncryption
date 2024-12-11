package database;

import database.config.Connector;
import database.manipulation.crypt.InsertEncryptedRecords;
import database.manipulation.plain.GenerateRecords;
import org.junit.Test;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class TestInsertRecords {
    @Test
    public void testInsertEncryptedStudent() throws Exception {
        Map mp=new HashMap();
        mp.put("id","1");
        mp.put("name","duan");
        Connector mc = new Connector();
        Connection conn=mc.getConnection();

        InsertEncryptedRecords.InsertEncryptedStudent(conn,mp);

        mc.closeConnection();
    }
    @Test
    public void testInsertCourseByMap() throws Exception {
        Map mp=new HashMap();
        mp.put("courseId","11");
        mp.put("studentId","22");
        mp.put("grade","33");

        Connector mc = new Connector();
        Connection conn=mc.getConnection();

        GenerateRecords.InsertCourseRecord(conn,mp);
        InsertEncryptedRecords.InsertEncryptedCourse(conn,mp);

        mc.closeConnection();
    }
}
