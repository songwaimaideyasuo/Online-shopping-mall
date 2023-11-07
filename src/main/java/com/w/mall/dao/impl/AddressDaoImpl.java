package com.w.mall.dao.impl;

import com.w.mall.dao.AddressDao;
import com.w.mall.pojo.Address;
import com.w.mall.pojo.Member;
import com.w.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AddressDaoImpl implements AddressDao {

    QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());


    @Override
    public List<Address> findByMemberId(int memberid) {
        String sql = "select * from address where mbr_id=?";
        try {
            List<Address> addressList = runner.query(sql, new BeanListHandler<>(Address.class), memberid);
            return addressList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateDefaultValue(int memberid) {
        String sql = "update address set default_value=0 where mbr_id=?";
        try {
            runner.update(sql,memberid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Address findById(int id) {
        String sql ="select * from address where id=?";
        try {
            Address address = runner.query(sql, new BeanHandler<>(Address.class), id);
            return address;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(Address address) {
        String sql = "insert into address values(null,?,?,?,?,?,?)";
        try {
            runner.update(sql,address.getContact(),address.getMobile(),address.getStreet(),address.getZipcode(),address.getMbr_id(),address.getDefault_value());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
