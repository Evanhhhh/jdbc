package com.itheima.jdbc;

import org.junit.Test;

import java.sql.*;

/*
API详解：PreparedStatement
 */

public class JDBCDemo7_PreparedStatement {

    @Test
    public void testPreparedStatement() throws Exception {

        //2.获取连接：如果连接的是本机的mysql并且端口是默认的3306，可以简化书写（去掉ip和端口号）
        String url = "jdbc:mysql:///test?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //接收用户输入的用户名和密码
        String name = "zhangsan";
        String pwd = "123";

        //定义sql
        String sql = "select * from user where username = ? and password = ?";

        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置?的值
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);

        //执行sql
        ResultSet rs = pstmt.executeQuery();
        //调用这个方法时不需要传递SQL语句，因为获取SQL语句执行对象时已经对SQL语句进行预编译了

        //判断登录是否成功
        if (rs.next()) {
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }


        //释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }

    /**
     * PreparedStatement原理
     * @throws Exception
     */
    @Test
    public void testPreparedStatement2() throws Exception {

        //2.获取连接：如果连接的是本机的mysql并且端口是默认的3306，可以简化书写（去掉ip和端口号）
        //useServerPrepStmts=true 参数开启预编译功能
        String url = "jdbc:mysql:///test?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //接收用户输入的用户名和密码
        String name = "zhangsan";
        String pwd = "' or '1' = '1";

        //定义sql
        String sql = "select * from user where username = ? and password = ?";

        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置?的值
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);

        //执行sql
        ResultSet rs = pstmt.executeQuery();
        //调用这个方法时不需要传递SQL语句，因为获取SQL语句执行对象时已经对SQL语句进行预编译了

        //判断登录是否成功
        if (rs.next()) {
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }


        //释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }



    /**
     * 演示SQL注入
     * @throws Exception
     */
    @Test
    public void testLogin_Inject() throws Exception {

        //2.获取连接：如果连接的是本机的mysql并且端口是默认的3306，可以简化书写（去掉ip和端口号）
        String url = "jdbc:mysql:///test?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //接收用户输入的用户名和密码
        String name = "kasdhbkjd";
        String pwd = "' or '1' = '1";

        String sql = "select * from user where username = '"+name+"' and password = '"+pwd+"'";
        System.out.println(sql);

        //获取stmt对象
        Statement stmt = conn.createStatement();

        //执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //判断登录是否成功
        if (rs.next()) {
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }


        //释放资源
        rs.close();
        stmt.close();
        conn.close();
    }


}
