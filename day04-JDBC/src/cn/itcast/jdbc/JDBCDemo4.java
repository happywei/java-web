package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo4 {
    /**
     * 删除表中的一条记录
     */
    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、定义sql
            String sql = "DELETE FROM student WHERE id = 9";
            //3、获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
            //4、获取执行sql的对象Statement
            stmt = conn.createStatement();
            //5、执行sql
            int count = stmt.executeUpdate(sql);
            //6、处理结果
            System.out.println(count);
            if(count > 0)
                System.out.println("删除成功");
            else
                System.out.println("删除失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //7、释放资源，先释放statement，再释放connection
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
