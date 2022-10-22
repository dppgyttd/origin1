package com.jdbc.jdbc02;

import com.jdbc.utils.JDBCUtils;

import java.sql.*;

public class TestDQL {

    //查询姓名为张百万的数据
    public static void main(String[] args) throws SQLException {

        //1.获取连接
        Connection connection = JDBCUtils.getConnection();

        //2.创建statement对象
        Statement statement = connection.createStatement();

        //3.编写sql
        String sql = "select * from jdbc_user where username = '张三'";

        ResultSet resultSet = statement.executeQuery(sql);

        //4.处理结果集
        while (resultSet.next()){
            //通过列名的方式获取
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            Date birthday = resultSet.getDate("birthday");

            System.out.println(id + username + password + birthday);

        }
    }
}
