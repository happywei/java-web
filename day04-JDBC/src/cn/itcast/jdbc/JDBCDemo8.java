package cn.itcast.jdbc;

import cn.itcast.domain.Stu;
import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个方法，查询student表的数据将其封装为对象，然后装载集合，返回
 */
public class JDBCDemo8 {

    public static void main(String[] args) {
        List<Stu> list = new JDBCDemo8().findAll2();
        System.out.println(list);
    }


    /**
     * 演示JDBC的工具类
     * @return
     */
    public List<Stu> findAll2(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Stu> list = null;
        try {
            conn = JDBCUtils.getConnection();
            //3、定义sql
            String sql = "select * from student";
            //4、获取执行sql的对象
            stmt = conn.createStatement();
            //5、执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Stu stu = null;
            list = new ArrayList<>();
            while(rs.next()){
                //获取数据
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                String address = rs.getString("address");
                int math = rs.getInt("math");
                int english = rs.getInt("english");
                //创建stu对象,并赋值
                stu = new Stu();
                stu.setId(id);
                stu.setName(name);
                stu.setAge(age);
                stu.setSex(sex);
                stu.setAddress(address);
                stu.setMath(math);
                stu.setEnglish(english);

                list.add(stu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, stmt, conn);
        }
        return list;
    }



    /**
     * 查询所有stu对象
     * @return
     */
    public List<Stu> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Stu> list = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
            //3、定义sql
            String sql = "select * from student";
            //4、获取执行sql的对象
            stmt = conn.createStatement();
            //5、执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Stu stu = null;
            list = new ArrayList<>();
            while(rs.next()){
                //获取数据
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                String address = rs.getString("address");
                int math = rs.getInt("math");
                int english = rs.getInt("english");
                //创建stu对象,并赋值
                stu = new Stu();
                stu.setId(id);
                stu.setName(name);
                stu.setAge(age);
                stu.setSex(sex);
                stu.setAddress(address);
                stu.setMath(math);
                stu.setEnglish(english);

                list.add(stu);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
        return list;
    }
}
