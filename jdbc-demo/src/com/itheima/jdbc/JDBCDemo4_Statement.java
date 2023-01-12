package com.itheima.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
JDBC API 详解：Statement
 */

public class JDBCDemo4_Statement {
    /**
     * 执行DML语句
     * @throws Exception
     */
    @Test
    public void testDML() throws Exception {
        //0.创建工程，导入驱动jar包

        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //MySQL5之后的驱动包，可以省略注册驱动的步骤
        //自动加载jar包中META-INF/services/java.sql.Driver文件中的驱动类

        //2.获取连接：如果连接的是本机的mysql并且端口是默认的3306，可以简化书写（去掉ip和端口号）
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql
        String sql = "update account set money = 3000 where id = 1";

        //4.获取执行sql的对象Statement
        Statement stmt = conn.createStatement();

        //5.执行sql
        int count = stmt.executeUpdate(sql); //执行完DML语句后，受影响的行数

        //6.处理结果
//        System.out.println(count);
        if (count > 0) {
            System.out.println("修改成功");
        }else {
            System.out.println("修改是吧");
        }

        //7.释放资源
        stmt.close();
        conn.close();
    }


    /**
     * 执行DDL语句
     * @throws Exception
     */
    @Test
    public void testDDL() throws Exception {
        //0.创建工程，导入驱动jar包

        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //MySQL5之后的驱动包，可以省略注册驱动的步骤
        //自动加载jar包中META-INF/services/java.sql.Driver文件中的驱动类

        //2.获取连接：如果连接的是本机的mysql并且端口是默认的3306，可以简化书写（去掉ip和端口号）
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql
        String sql = "drop database if exists db2";

        //4.获取执行sql的对象Statement
        Statement stmt = conn.createStatement();

        //5.执行sql
        int count = stmt.executeUpdate(sql); //执行完DDL语句后，可能是0

        //6.处理结果
        System.out.println(count);
//        if (count > 0) {
//            System.out.println("修改成功");
//        }else {
//            System.out.println("修改是吧");
//        }

        //7.释放资源
        stmt.close();
        conn.close();
    }
}
