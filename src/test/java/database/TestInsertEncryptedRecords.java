package database;

import database.manipulation.crypt.InsertEncryptedRecords;
import org.junit.Test;

public class TestInsertEncryptedRecords {
    @Test
    public void testInsertEncryptedStudent() {
        try {
            InsertEncryptedRecords.InsertEncryptedStudent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
