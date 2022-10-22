package com.jdbc.utils;

import java.sql.*;

/**
 * JDBC工具类
 */
public class JDBCUtils {

    //1.将连接信息定义为 字符串常量
    public static final String DRIVERNAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/db2?characterEncoding=UTF-8";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    //2.静态代码块
    static {
        try {
            //1.注册驱动
            Class.forName(DRIVERNAME);
            System.out.println("这是静态代码块JDBCUtils");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //3.获取连接的静态方法
    public static Connection getConnection() {
        //获取连接对象并返回
        try {
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            //java.sql.Connection con = DriverManager.getConnection(url, "root", "123456");
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    //4.关闭资源的方法
    public static void close(Connection con, Statement statement) {
        if(null != con && null != statement) {
            try {
                statement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //方法重载
    public static void close(Connection con, Statement statement, ResultSet resultSet) {
        if(null != con && null != statement) {
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
