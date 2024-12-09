package database;

import database.config.Connector;
import database.manipulation.crypt.InsertEncryptedRecords;
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

}
