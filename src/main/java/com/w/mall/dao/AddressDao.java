package com.w.mall.dao;

import com.w.mall.pojo.Address;

import java.util.List;

public interface AddressDao {

    public List<Address> findByMemberId(int memberid);

    public void add(Address address);

    public void updateDefaultValue(int memberid);

    Address findById(int id);
}
