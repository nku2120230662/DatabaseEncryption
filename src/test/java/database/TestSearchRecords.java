package database;

import database.config.Connector;
import database.manipulation.crypt.SearchEncryptedRecords;
import database.manipulation.plain.SearchRecord;
import org.junit.Test;

import java.sql.Connection;

import static database.manipulation.plain.SearchRecord.SearchStudentsJoinCourses;

public class TestSearchRecords {

    @Test
    public void testPlainJoinQuery() throws Exception {
        Connector mc = new Connector();
        Connection conn=mc.getConnection();

        SearchRecord.SearchStudentsJoinCourses(conn);

        mc.closeConnection();
    }

    @Test
    public void testSearchEncryptedStudents() throws Exception {
        Connector mc = new Connector();
        Connection conn=mc.getConnection();

        SearchEncryptedRecords.SearchEncryptedStudents(conn);

        mc.closeConnection();
    }

    @Test
    public void testSearchEncryptedJoinQuery() throws Exception {
        Connector mc = new Connector();
        Connection conn=mc.getConnection();

        SearchEncryptedRecords.SearchEncryptedStudentsJoinCourses(conn);

        mc.closeConnection();
    }

}
