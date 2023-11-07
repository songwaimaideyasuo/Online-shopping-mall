package com.w.mall.web.controller;

import com.w.mall.common.Result;
import com.w.mall.pojo.Address;
import com.w.mall.pojo.Member;
import com.w.mall.service.AddressService;
import com.w.mall.service.impl.AddressServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/address/*")
public class AddressServlet extends BaseServlet{

    private AddressService addressService = new AddressServiceImpl();

    //根据会员编号查找收货地址
    public void findByMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //获取会员的id
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");
        Integer memberId = member.getId();

        //调用业务层根据会员id获取对应的addres集合
        List<Address> addressList = addressService.findByMemberId(memberId);

        Result result = new Result(true,addressList,"查询成功");
        writeJson(response,result);
    }

    //保存新增的地址
    public void saveAddress(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{

        //获取前台传过来的地址信息，并将其它保存到一个Address对象中
        Map<String, String[]> parameterMap = request.getParameterMap();
        Address address = new Address();
        try {
            BeanUtils.populate(address,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //为地址设置对应的会员的id
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");
        address.setMbr_id(member.getId());

        //调用业务层将地址信息保存到数据库中
        addressService.add(address);

        Result r = new Result(true,"添加成功");
        writeJson(response,r);

    }

}
