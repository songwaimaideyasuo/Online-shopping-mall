package com.w.mall.web.controller;

import com.w.mall.common.Result;
import com.w.mall.pojo.CartItem;
import com.w.mall.pojo.Product;
import com.w.mall.service.ProductService;
import com.w.mall.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart/*")
public class CateServlet extends BaseServlet {

    private ProductService productService = new ProductServiceImpl();

    public void addCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException{

        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //获取到前台传过来的商品编号和数量
        int productId = Integer.parseInt(request.getParameter("productId"));
        int numbeer = Integer.parseInt(request.getParameter("number"));

        //创建一个购物车项对象（商品+数量）
        Product product = productService.findById(productId);
        CartItem cartItem = new CartItem(product,numbeer);

        //获取购物车
        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>)session.getAttribute("cart");
        if(cart==null){     //用户是第一次购物，session中并没有存放购物车，此时应该创建一个购物
            cart = new ArrayList<>();
        }
        cart.add(cartItem);    //将购物车项装进购物车中

        session.setAttribute("cart", cart);

        Result result = new Result();
        result.setFlag(true);
        result.setMsg("添加成功");

        writeJson(response,result);

    }

    public void viewCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //获取Session
        HttpSession session = request.getSession();

        //从session中取出购物车对象（List）
        List<CartItem> cart = (List<CartItem>)session.getAttribute("cart");

        Result result = new Result();
        if(cart==null){

            result.setFlag(false);
            result.setMsg("购物车为空");
        }else{
            result.setFlag(true);
            result.setMsg("查询成功");
            result.setData(cart);
        }

        writeJson(response,result);
    }
}
