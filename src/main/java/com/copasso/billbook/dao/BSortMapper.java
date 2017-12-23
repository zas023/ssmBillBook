package com.copasso.billbook.dao;

import com.copasso.billbook.bean.BSort;
import com.copasso.billbook.bean.BSortExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BSortMapper {
    long countByExample(BSortExample example);

    int deleteByExample(BSortExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BSort record);

    int insertSelective(BSort record);

    List<BSort> selectByExample(BSortExample example);

    //通过用户id查询用户的支出账单分类，包含系统自带
    List<BSort> selectOutByUserId(Integer userid);
    //通过用户id查询用户的收入账单分类，包含系统自带
    List<BSort> selectInByUserId(Integer userid);

    BSort selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BSort record, @Param("example") BSortExample example);

    int updateByExample(@Param("record") BSort record, @Param("example") BSortExample example);

    int updateByPrimaryKeySelective(BSort record);

    int updateByPrimaryKey(BSort record);
}