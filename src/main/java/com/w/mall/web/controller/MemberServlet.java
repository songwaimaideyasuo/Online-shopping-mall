package com.w.mall.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.w.mall.common.Result;
import com.w.mall.pojo.Member;
import com.w.mall.service.MemberService;
import com.w.mall.service.impl.MemberServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

@WebServlet("/member/*")
public class MemberServlet extends BaseServlet {

    MemberService memberService = new MemberServiceImpl();

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //1.接收用户传过来的手机号和密码
        String mobile=request.getParameter("mobile");
        String pwd = request.getParameter("pwd");

        //2.调用业务层判断手机号和密码
        Member member = memberService.login(mobile, pwd);

        //对member对象进行判断
        //创建一个结果对象
        Result result = new Result();
        if(member==null){
            result.setFlag(false);
            result.setMsg("登陆失败");
        }else {

            //登陆成功之后需要将用户的信息保存到session中
            HttpSession session = request.getSession();
            session.setAttribute("member", member);


            result.setFlag(true);
            result.setMsg("登陆成功");
        }

        //将结果对象转换成json
        ObjectMapper mapper = new ObjectMapper();
        String resultJson = mapper.writeValueAsString(result);
        out.print(resultJson);

    }


    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //销毁session
        HttpSession session = request.getSession();

        session.invalidate();

        Result result = new Result();
        result.setFlag(true);

        //转换成json
        writeJson(response, result);
    }


    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

/*       如果当前台数据很多时，可以使用BeanUtils.Populdate()方法快速的将表单中的数据封装到实体对象中。
        前提要保存表单数据的名字要和实体对象的属性名一致*/
        Map<String, String[]> parameterMap = request.getParameterMap();
        Member member = new Member();


        try {
            BeanUtils.populate(member, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //设置用户注册时间
        member.setRegister_time(new Date());


        //调用业务层完成添加的任务
        boolean result = memberService.regist(member);

        //根据注册的结果返回对应的消息
        Result result1 = new Result();
        if (result==true){
            //说明注册成功
            result1.setFlag(true);
            result1.setMsg("注册成功");
        }else {
            result1.setFlag(false);
            result1.setMsg("注册失败");
        }

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(result1);

        response.getWriter().print(s);
    }



    public void findNickName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("application/json"); //表示响应在前端的数据是一个json数据
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();   //无则创建，有则获取
        Member member = (Member)session.getAttribute("member");   //如果已经登录过member对象不为null，否则为null

        //返回的结果对象
        Result result = new Result();
        result.setFlag(true);
        result.setMsg("");
        result.setData(member);


        //转换成json
        writeJson(response, result);

    }


}
