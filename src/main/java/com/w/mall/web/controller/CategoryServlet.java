package com.w.mall.web.controller;

import com.w.mall.common.Result;
import com.w.mall.pojo.Category;
import com.w.mall.service.CategoryService;
import com.w.mall.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {

    private CategoryService categoryService = new CategoryServiceImpl();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        List<Category> categoryList = categoryService.findAll();


        Result result = new Result();
        result.setFlag(true);
        result.setMsg("查询成功");
        result.setData(categoryList);

        //将结果对象转换成json
        writeJson(response, result);

    }

}
