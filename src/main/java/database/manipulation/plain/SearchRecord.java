package database.manipulation.plain;

import database.config.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchRecord {

    // 查询表hello的全部字段
    public boolean Search() throws Exception{
        Connector mc = new Connector();
        Statement stmt = null;
        stmt = mc.getConnection().createStatement();

        ResultSet rs = stmt.executeQuery("select * from hello");
        // 展开结果集数据库
        while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("id");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print("\n");
            }
            stmt.close();
        mc.closeConnection();
        return true;
    }
}