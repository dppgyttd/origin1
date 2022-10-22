package com.jdbc.jdbc02;

import com.jdbc.utils.JDBCUtils;
import org.junit.Test;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDML {
    @Test
    public void testInsert() throws SQLException {
        //1.通过JDBCUtils工具类获取连接
        Connection con = JDBCUtils.getConnection();

        //2.获取statement对象
        Statement statement = con.createStatement();

        //2.1编写sql
        String sql = "insert into jdbc_user values(null,'张三','123','2020/11/11')";

        //2.2执行sql
        int i = statement.executeUpdate(sql);
        System.out.println(i);

        //3.关闭流
        JDBCUtils.close(con,statement);



    }

    /**
     *更新操作 根据id修改用户名
     */
    @Test
    public void testUpdate() throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        Statement statement = connection.createStatement();

        String sql = "update jdbc_user set username = '刘能' where id = 1";
        statement.executeUpdate(sql);

        JDBCUtils.close(connection,statement);

    }

    /**
     * 删除操作
     * 删除id为1 和 2的数据
     * @throws SQLException
     */
    @Test
    public void testDelete() throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        Statement statement = connection.createStatement();

        String sql = "delete from jdbc_user where id in (1,2)";

        statement.executeUpdate(sql);
        JDBCUtils.close(connection,statement);
    }


}
