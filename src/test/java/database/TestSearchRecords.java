package database;

import database.manipulation.crypt.SearchEncryptedRecords;
import database.manipulation.plain.SearchRecord;
import org.junit.Test;

public class TestSearchRecords {
    @Test
    public void testSearchEncryptedStudent() throws Exception {
        SearchEncryptedRecords.SearchEncryptedStudent();
    }
}
