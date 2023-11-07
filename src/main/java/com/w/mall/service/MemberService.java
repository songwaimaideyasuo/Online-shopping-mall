package com.w.mall.service;

import com.w.mall.pojo.Member;

public interface MemberService {

    public Member login(String mobile,String pwd);


    boolean regist(Member member);
}
