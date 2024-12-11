package database;

import database.config.Connector;
import database.manipulation.crypt.SearchEncryptedRecords;
import org.junit.Test;

import java.sql.Connection;

public class TestSearchRecords {
    @Test
    public void testSearchEncryptedStudent() throws Exception {
        Connector mc = new Connector();
        Connection conn=mc.getConnection();

        SearchEncryptedRecords.SearchEncryptedStudents(conn);

        mc.closeConnection();
    }
}
