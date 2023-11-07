package com.w.mall.dao.impl;

import com.w.mall.dao.CategoryDao;
import com.w.mall.pojo.Category;
import com.w.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public List<Category> findAll() {
        String sql = "select * from category";

        try {
            List<Category> categoryList = runner.query(sql, new BeanListHandler<>(Category.class));
            return categoryList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
