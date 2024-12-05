package database;

import database.manipulation.crypt.InsertEncryptedRecords;
import database.manipulation.plain.GenerateRecords;
import org.junit.Test;

public class TestGenerateRecords {
    @Test
    public void testGenerateRecords() throws Exception {
        InsertEncryptedRecords.InsertEncryptedStudent();
    }
}
