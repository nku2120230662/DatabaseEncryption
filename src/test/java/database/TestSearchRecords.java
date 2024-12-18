package database;

import database.config.Connector;
import database.manipulation.crypt.SearchEncryptedRecords;
import database.manipulation.plain.SearchRecord;
import org.junit.Test;

import java.sql.Connection;

public class TestSearchRecords {

    @Test
    public void testPlainSelection() throws Exception {
        Connector mc = new Connector();
        Connection conn=mc.getConnection();

        SearchRecord.SearchStudents(conn);

        mc.closeConnection();
    }

    @Test
    public void testPlainJoinQuery() throws Exception {
        Connector mc = new Connector();
        Connection conn=mc.getConnection();

        SearchRecord.SearchStudentsJoinCourses(conn);

        mc.closeConnection();
    }

    @Test
    public void testMyPlainJoinQuery() throws Exception {
        Connector mc = new Connector();
        Connection conn=mc.getConnection();

        String[] condition={"students","courses","students.id=courses.s_id"};

        SearchRecord.MyPlainJoinQueries(conn,condition);

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

        String[] condition={"students","courses","students.id=courses.s_id","id=2"};
        SearchEncryptedRecords.MyEncryptedJoinQueries(conn,condition);

        mc.closeConnection();
    }

}
