package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
JDBC快速入门
 */

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        //0.创建工程，导入驱动jar包

        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //MySQL5之后的驱动包，可以省略注册驱动的步骤
        //自动加载jar包中META-INF/services/java.sql.Driver文件中的驱动类

        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql
        String sql = "update account set money = 2000 where id = 1";

        //4.获取执行sql的对象Statement
        Statement stmt = conn.createStatement();

        //5.执行sql
        int count = stmt.executeUpdate(sql); //受影响的行数

        //6.处理结果
        System.out.println(count);

        //7.释放资源
        stmt.close();
        conn.close();
    }
}
