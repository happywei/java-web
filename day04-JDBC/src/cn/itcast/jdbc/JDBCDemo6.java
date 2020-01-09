package cn.itcast.jdbc;

import java.sql.*;

public class JDBCDemo6 {
    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、定义sql
            String sql = "SELECT * FROM student";
            //3、获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
            //4、获取执行sql的对象Statement
            stmt = conn.createStatement();
            //5、执行sql
            rs = stmt.executeQuery(sql);
            //6、处理结果
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString("name");
                int age = rs.getInt(3);
                String sex = rs.getString("sex");
                String address = rs.getString("address");
                int math = rs.getInt(6);
                int english = rs.getInt(7);
                System.out.println(id + " " + name + " " + age + " " + sex + " "
                        + address + " " + math + " " + english);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //7、释放资源，先释放statement，再释放connection
            if(rs != null){
                try {
                    rs.close();
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
