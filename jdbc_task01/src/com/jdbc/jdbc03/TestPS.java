package com.jdbc.jdbc03;

import com.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPS {

    public static void main(String[] args) throws SQLException {

        Connection connection = JDBCUtils.getConnection();

        //获取statement对象
        Statement statement = connection.createStatement();

        //向数据库中插入两条数据
        statement.executeUpdate("insert into jdbc_user values(null,'张三','123456','2000/12/26')");
        statement.executeUpdate("insert into jdbc_user values(null,'李四','654321','1900/12/26')");

        //获取预处理对象
        PreparedStatement ps = connection.prepareStatement("insert into jdbc_user values(?,?,?,?)");

        //先插入一条数据
        ps.setObject(1,null);
        ps.setString(2,"小语");
        ps.setString(3,"qwer");
        ps.setString(4,"1991/11/11");
        ps.executeUpdate();
        //插入第二条数据
        ps.setObject(1,null);
        ps.setString(2,"小王");
        ps.setString(3,"qwerd");
        ps.setString(4,"1990/1/11");

        //执行插入操作
        ps.executeUpdate();

        //释放资源
        ps.close();
        statement.close();
        connection.close();
        
    }
}
