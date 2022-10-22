package com.jdbc.jdbc01;


import java.sql.*;

public class JDBCDemo03 {

    public static void main(String[] args) {

        //1.注册驱动  省略
        Connection con = null;
        Statement statement =null;
        ResultSet resultSet = null;

        //2.获取连接
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "123456");

            //3.获取语句执行对象
            statement = con.createStatement();

            //4.执行sql
            String sql = "select * from jdbc_user";
            resultSet = statement.executeQuery(sql);

            //5.处理结果集


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //1.关闭流
            try {
                resultSet.close();
                statement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
