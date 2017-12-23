package com.copasso.billbook.dao;

import com.copasso.billbook.bean.BPay;
import com.copasso.billbook.bean.BPayExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BPayMapper {
    long countByExample(BPayExample example);

    int deleteByExample(BPayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BPay record);

    int insertSelective(BPay record);

    List<BPay> selectByExample(BPayExample example);

    //通过用户id查询用户的支付方式，包含系统自带
    List<BPay> selectByUserId(Integer userid);

    BPay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BPay record, @Param("example") BPayExample example);

    int updateByExample(@Param("record") BPay record, @Param("example") BPayExample example);

    int updateByPrimaryKeySelective(BPay record);

    int updateByPrimaryKey(BPay record);
}