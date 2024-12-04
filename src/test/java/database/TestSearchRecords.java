package database;

import database.manipulation.plain.SearchRecord;
import org.junit.Test;

public class TestSearchRecords {
    @Test
    public void testSearch() throws Exception {
        SearchRecord bs = new SearchRecord();
        if (bs.Search()) {
            return;
        }
    }
}
