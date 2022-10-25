package com.jdbc.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo01 {

    public static void main(String[] args) throws Exception {

        //1.注册驱动（其实是可以省略的，从jdbc3开始就可以省略了）
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接 connection连接对象  Connection本身是一个接口
        String url = "jdbc:mysql://localhost:3306/db2?characterEncoding=UTF-8";
        Connection con = DriverManager.getConnection(url, "root", "123456");

        //打印连接对象
        System.out.println(con);  //com.mysql.jdbc.JDBC4Connection@4524411f

        //获取语句执行平台对象 statement
        Statement statement = con.createStatement();

        //通过statement对象的excuteupdate方法创建表
        String sql = "create table test(id int,name varchar(20),age int)";
        statement.executeUpdate(sql);

        //关闭流
        statement.close();
        con.close();
        //百叶


    }
}
