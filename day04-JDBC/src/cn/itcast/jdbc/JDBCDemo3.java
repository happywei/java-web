package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 修改记录
 */
public class JDBCDemo3 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、定义sql
            String sql = "UPDATE student SET math = 100 WHERE id = 1";
            //3、获取connection对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
            //4、获取执行sql的对象Statement
            stmt = conn.createStatement();
            //5、执行sql
            int count = stmt.executeUpdate(sql);
            //6、处理结果
            System.out.println(count);
            if(count > 0)
                System.out.println("修改成功");
            else
                System.out.println("修改失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //7. 释放资源 先释放statement再执行connection
            //避免空指针异常
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
