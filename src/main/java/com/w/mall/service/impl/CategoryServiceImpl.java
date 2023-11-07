package com.w.mall.service.impl;

import com.w.mall.dao.CategoryDao;
import com.w.mall.dao.impl.CategoryDaoImpl;
import com.w.mall.pojo.Category;
import com.w.mall.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
