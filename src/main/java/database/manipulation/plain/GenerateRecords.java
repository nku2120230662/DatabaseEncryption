package database.manipulation.plain;

import database.config.Connector;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;

public class GenerateRecords {
    public static boolean GenerateCourseRecords() throws Exception{
        Random rand = new Random();
        Connector mc = new Connector();
        Connection conn=mc.getConnection();
        Statement stmt=conn.createStatement();
        for(int i=0;i<5;i++){
            int s_id=rand.nextInt(100);
            int grades=rand.nextInt(100);
            int t_id=rand.nextInt(100);

            String sql="insert into courses values(" +
                    s_id + "," +
                    grades + "," +
                    t_id +
                    ")";
            int result=stmt.executeUpdate(sql);
            if(result==1){
                System.out.println("Record " + i + " Inserted");
            }
        }
        stmt.close();
        conn.close();
        return true;
    }
}
//        String sql="insert into courses values(" +
//                "1," +
//                "2," +
//                "3" +
//                ")";