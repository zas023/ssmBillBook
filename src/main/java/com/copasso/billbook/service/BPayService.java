package com.copasso.billbook.service;

import com.copasso.billbook.bean.BPay;
import com.copasso.billbook.dao.BPayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 支付信息payInfo操作类
 */
@Service
public class BPayService {

    @Autowired
    private BPayMapper bPayMapper;

    /**
     *通过用户id查询用户的支付方式，包含系统自带
     * @param id
     * @return
     */
    public List<BPay> findPayinfoByUserId(int id){
        return bPayMapper.selectByUserId(id);
    }

    /**
     * 添加支付方式，返回操作数
     * @param bPay
     * @return
     */
    public int addPayinfo(BPay bPay){
        return bPayMapper.insert(bPay);
    }

    /**
     * 更新支付方式，返回操作数
     * @param bPay
     * @return
     */
    public int updatePayinfo(BPay bPay){
        return bPayMapper.updateByPrimaryKey(bPay);
    }
}
