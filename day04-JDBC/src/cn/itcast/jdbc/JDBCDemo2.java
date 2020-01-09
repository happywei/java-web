package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * student表 添加一条记录 insert语句
 */

public class JDBCDemo2 {
    public static void main(String[] args) {

        Statement stmt = null;
        Connection conn = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、定义sql
            String sql = "INSERT INTO student (id, NAME, age, sex, address, math, english) " +
                    "VALUES (9, 'liuwei', 24, '男', '哈尔滨', 150, 150)";
            String sql2 = "DELETE FROM student WHERE id = 9";
            //3、获取connection对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
            //4、获取执行sql的对象 Statement
            stmt = conn.createStatement();
            //5、执行sql
            int count = stmt.executeUpdate(sql2);
            //6、处理结果
            System.out.println(count);
            if(count > 0)
                System.out.println("添加成功");
            else
                System.out.println("添加失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //7、释放资源，避免空指针异常
            if(stmt != null){
                try {
                    stmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try{
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
