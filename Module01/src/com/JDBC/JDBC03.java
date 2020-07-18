package com.JDBC;

import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

public class JDBC03 {
    //不确定sql的查询字段及筛选条件的情况下的查询通用方法
    public  void queryTest(String sql,Object...args)  {
        Connection connection1 = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet1 = null;
        try {
            //读取配置文件中的信息获取连接
            connection1 = DruidTest.getConnection();
            //预编译sql
            preparedStatement = connection1.prepareStatement(sql);
            //填充占位符
            for(int i=0; i<args.length; i++){
                preparedStatement.setObject(i+1, args[i]);
            }
            //执行sql
            resultSet1 = preparedStatement.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData metaData = resultSet1.getMetaData();
            //获取结果集的列数,确定要查询的字段数量
            int columnCount = metaData.getColumnCount();
            //整个过程为将查询结果的字段值封装到对象中，而那些对象中未被查询的属性仍为默认值
            while(resultSet1.next()){
                Pet pet = new Pet();    //结果集的每一行造一个对象，在其他情况下可以将pet封装到list中
                for (int i = 0; i < columnCount; i++) {     //对要查询的各个字段进行处理
                    Object object = resultSet1.getObject(i + 1);    //获取该字段的查询值
                    String columnName = metaData.getColumnName(i + 1);  //获取该字段名，确定要set的对象属性，前提是类的属性名与表的字段名一一对应
                    //当表的字段名与属性名不同时，在写sql语句时需要为字段取别名，且用getColumnLabel\
                    //getColumnName()获取表的列名；getColumnLabel()获取列的别名（无别名则取列名）
                    Field declaredField = Pet.class.getDeclaredField(columnName);   //通过反射set对象属性（重点）
                    declaredField.setAccessible(true);              //private
                    declaredField.set(pet, object);
                }
                System.out.println(pet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.closeConnection(connection1, preparedStatement,resultSet1);
        }
    }

    @Test
    public void test(){
        String sql = "select name,species,age from pet where species=?;";
        queryTest(sql, "cat");
    }
}


