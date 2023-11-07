package com.w.mall.service;

import com.w.mall.pojo.Address;

import java.util.List;

public interface AddressService {

    public List<Address> findByMemberId(int memberid);

    public void add(Address address);

    public Address findById(int id);
}
