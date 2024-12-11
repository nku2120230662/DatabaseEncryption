package database.manipulation.plain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchRecord {

    // 查询表student的全部字段
    public static boolean SearchStudents(Connection conn) throws Exception{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("select * from students");
        // 展开结果集数据库
        while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("id");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print("\n");
            }
            stmt.close();
        return true;
    }
}