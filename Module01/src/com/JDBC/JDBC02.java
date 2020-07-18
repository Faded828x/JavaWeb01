package com.JDBC;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBC02 {
    public static void insertTest(String sql,Object...args)  {
        Connection connection1 = null;
        PreparedStatement preparedStatement = null;
        try {
            //读取配置文件中的信息获取连接
            connection1 = JDBCUtils.getConnection();
            //预编译sql
            preparedStatement = connection1.prepareStatement(sql);
            //填充占位符
            for(int i=0; i<args.length; i++){
                preparedStatement.setObject(i+1, args[i]);
            }
            //执行sql
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭z
            JDBCUtils.closeConnection(connection1, preparedStatement);
        }
    }

    @Test
    public void test222(){
        String sql = "insert into pet(name,owner)values(?,?);";
        JDBC02.insertTest(sql, "Kaka","Sandy");
    }
}


