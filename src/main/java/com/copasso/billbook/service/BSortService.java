package com.copasso.billbook.service;

import com.copasso.billbook.bean.BSort;
import com.copasso.billbook.dao.BSortMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账单分类Sort操作类
 */
@Service
public class BSortService {

    @Autowired
    private BSortMapper bSortMapper;

    /**
     *通过用户id查询用户的支出账单分类，包含系统自带
     * @param id
     * @return
     */
    public List<BSort> findOutSortByUserId(int id){
        return bSortMapper.selectOutByUserId(id);
    }

    /**
     *通过用户id查询用户的收入账单分类，包含系统自带
     * @param id
     * @return
     */
    public List<BSort> findInSortByUserId(int id){
        return bSortMapper.selectInByUserId(id);
    }

    /**
     *通过sortid查询用户的账单分类信息
     * @param id
     * @return
     */
    public BSort findSortById(int id){
        return bSortMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改账单分类，返回操作数
     * @param bSort
     * @return
     */
    public int updateSort(BSort bSort){
        return bSortMapper.updateByPrimaryKey(bSort);
    }

    /**
     * 添加账单分类，返回操作数
     * @param bSort
     * @return
     */
    public int addSort(BSort bSort){
        return bSortMapper.insert(bSort);
    }
}
