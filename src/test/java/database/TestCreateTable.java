package database;

import database.manipulation.plain.CreateTable;
import org.junit.Test;

public class TestCreateTable {
    @Test
    public void testCreateTable() throws Exception {
        CreateTable.CreateCourses();
    }
}
