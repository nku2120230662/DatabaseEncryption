package database;

import database.config.Connector;
import database.manipulation.plain.GenerateRecords;
import org.junit.Test;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class TestGenerateRecords {
    @Test
    public void testGenerateCourseRecords() throws Exception {
        Connector mc = new Connector();
        Connection conn=mc.getConnection();
        GenerateRecords.GenerateCourseRecords(conn);
        mc.closeConnection();
    }

    @Test
    public void testGenerateStudentRecords() throws Exception {
        Connector mc = new Connector();
        Connection conn=mc.getConnection();
        GenerateRecords.GenerateStudentRecords(conn);
        mc.closeConnection();
    }

}
