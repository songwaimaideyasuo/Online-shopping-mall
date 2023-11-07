package com.w.mall.service.impl;

import com.w.mall.dao.MemberDao;
import com.w.mall.dao.impl.MemberDaoImpl;
import com.w.mall.pojo.Member;
import com.w.mall.service.MemberService;

public class MemberServiceImpl implements MemberService {

    MemberDao memberDao = new MemberDaoImpl();    //创建数据库访问的对象

    @Override
    public Member login(String mobile, String pwd) {

        Member member = memberDao.findByMobileAndPwd(mobile, pwd);
        return member;
    }


    @Override
    public boolean regist(Member member) {
        //判断手机号码是否存在
        Member mobile = memberDao.findByMobile(member.getMobile());
        if (mobile!=null){
            return false;
        }

        memberDao.add(member);
        return true;
    }
}
