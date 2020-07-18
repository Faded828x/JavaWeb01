package com.JDBC;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class QueryRunnerTest {

    @Test
    public void insertTest(){
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = DruidTest.getConnection();
            String sql = "insert into pet(name,age) values(?,?);";
            queryRunner.update(connection, sql, "Jie",5);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtils.closeConnection(connection, null);
        }
    }

    @Test
    public void queryTest() {
        List<Pet> query = null;
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = DruidTest.getConnection();
            String sql = "select * from pet where age<?";
            BeanListHandler<Pet> petBeanHandler = new BeanListHandler<>(Pet.class);
            query = queryRunner.query(connection, sql, petBeanHandler, 6);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, null);
        }
        query.forEach(System.out::println);
    }
}
