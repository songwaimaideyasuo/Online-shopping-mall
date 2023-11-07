package com.w.mall.service.impl;

import com.w.mall.dao.AddressDao;
import com.w.mall.dao.impl.AddressDaoImpl;
import com.w.mall.pojo.Address;
import com.w.mall.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {

    private AddressDao addressDao = new AddressDaoImpl();

    @Override
    public List<Address> findByMemberId(int memberid) {
        return addressDao.findByMemberId(memberid);
    }

    @Override
    public void add(Address address) {

        //应该对address进行判断如果不是默认地址，则直接将期添加到数据库中
        if(address.getDefault_value()==0){
            addressDao.add(address);
        }else{
            //如果address是默认地址，则需要将该会员所对应的地址的default_value先更新成0,然后再添加
            addressDao.updateDefaultValue(address.getMbr_id());
            addressDao.add(address);
        }
    }

    @Override
    public Address findById(int id) {
        return addressDao.findById(id);
    }

}
