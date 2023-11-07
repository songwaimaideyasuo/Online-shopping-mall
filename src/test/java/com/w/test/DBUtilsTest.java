package com.w.test;


import com.w.mall.pojo.Category;
import com.w.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.DbUtils;


import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class DBUtilsTest {

    @Test
    public void test1() {

        //访问数据库使用QueryRunner对象来完成
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        //调用runner对象的uodate（）方法进行增删改
        String sql="insert into category values(null,?,?,?)";
        try {
            runner.update(sql,"日用百货","riyongbaihuo",10);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Test
    public void test2() {

        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        //调用runner对象的uodate（）方法进行增删改
        String sql="delete from category where id=?";
        try {
            runner.update(sql,31);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Test
    public void test3() {

        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        //调用runner对象的uodate（）方法进行增删改
        String sql="update category set name=?,alias=? where id=?";
        try {
            runner.update(sql,"家用电器","jiayongdianqi",3);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    //查询
    @Test
    public void test4() {

        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        String sql="select * from category where id=?";

        try {
            Category category = runner.query(sql, new BeanHandler<>(Category.class), 3);
            System.out.println(category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test5() throws SQLException {

        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        String sql="select * from category ";
        List<Category> categoryList = runner.query(sql, new BeanListHandler<>(Category.class));

        for (Category category : categoryList) {
            System.out.println(category);

        }
    }


    //聚合函数查询
    @Test
    public void test6() throws SQLException {

        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        String sql="select count(*) from category";
        Long count = runner.query(sql, new ScalarHandler<Long>());
        System.out.println(count);

        }


    }

