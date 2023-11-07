package com.w.mall.dao.impl;

import com.w.mall.dao.ProductDao;
import com.w.mall.pojo.Product;
import com.w.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public List<Product> findByCateId(int cateid) {

        String sql = "select * from product where cate_id=?";
        try {
            List<Product> productList = runner.query(sql, new BeanListHandler<>(Product.class), cateid);
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Product findById(int id) {
        String sql = "select * from product where id=?";
        try {
            Product product = runner.query(sql, new BeanHandler<>(Product.class), id);
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findByPage(int cateid, int start, int pageSize) {

        String sql = "select * from product where cate_id=? limit ?,?";
        try {
            List<Product> productList = runner.query(sql, new BeanListHandler<>(Product.class),cateid, start, pageSize);
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public long findTotalCount(int cateid) {
        String sql = "select count(*) from product where cate_id=?";
        Long totalCount = 0L;
        try {
            totalCount = runner.query(sql, new ScalarHandler<Long>(), cateid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalCount;
    }
}
