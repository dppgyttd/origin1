package com.jdbc.jdbc01;

import java.sql.*;

public class JDBCDemo02 {

    public static void main(String[] args) throws Exception {


        //1.注册驱动（其实是可以省略的，从jdbc3开始就可以省略了）
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接 connection连接对象  Connection本身是一个接口
        String url = "jdbc:mysql://localhost:3306/db2?characterEncoding=UTF-8";
        Connection con = DriverManager.getConnection(url, "root", "123456");//

        //打印连接对象
        System.out.println(con);  //com.mysql.jdbc.JDBC4Connection@4524411f

        //获取语句执行平台对象 statement
        Statement statement = con.createStatement();

        //通过statement对象的executeQuery查询
        String sql = "select * from jdbc_user";

        //resultset是结果集对象，它是一个接口
        ResultSet resultSet = statement.executeQuery(sql);

        //处理结果集对象resultset
        /*boolean next = resultSet.next(); //判断是否有下一条数据
        System.out.println(next);*/

        //获取id
        /*int id = resultSet.getInt("id");//通过列名的方式获取第一行数据中列名为id的数据
        System.out.println("通过列名的方式获取" + id);

        int anInt = resultSet.getInt(1); //通过列号的方式获取第一行数据中列号为1的数据
        System.out.println("通过列号的方式获取" + anInt);*/

        //通过while循环 遍历获取resultset中的数据
        while (resultSet.next()) {
            //1.获取id
            int id = resultSet.getInt("id");

            //2.获取姓名
            String username = resultSet.getString("username");

            //3.获取密码
            String password = resultSet.getString("password");

            //4.获取生日
            Date birthday = resultSet.getDate("birthday");
          
        int i = 1;
            System.out.println("hhh");
        }


        //关闭流
        resultSet.close();
        statement.close();
        con.close();
    }
}
