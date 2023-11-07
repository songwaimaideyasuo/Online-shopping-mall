package com.w.mall.service.impl;

import com.w.mall.common.PageBean;
import com.w.mall.dao.ProductDao;
import com.w.mall.dao.impl.ProductDaoImpl;
import com.w.mall.pojo.Product;
import com.w.mall.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl();


    @Override
    public List<Product> findByCateId(int cateid) {

        return productDao.findByCateId(cateid);
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public PageBean<Product> findPage(int cateid, int currentPage, int pageSize) {

        //获取当前分类的总记录数
        long totalCount = productDao.findTotalCount(cateid);

        //获取总页数
        long totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;

        //获取一个存有分页商品的集合
        //将当前页转换成一个起始位置
        int start = (currentPage-1)*pageSize;
        List<Product> productList = productDao.findByPage(cateid, start, pageSize);

        //构建一个PageBean对象
        PageBean<Product> pageBean =new PageBean<>();
        pageBean.setList(productList);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }


}
