package com.copasso.billbook.dao;

import com.copasso.billbook.bean.BBill;
import com.copasso.billbook.bean.BBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BBillMapper {
    long countByExample(BBillExample example);

    int deleteByExample(BBillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BBill record);

    int insertSelective(BBill record);

    List<BBill> selectByExample(BBillExample example);

    List<BBill> selectByUserId(Integer userid);

    List<BBill> selectBillsByUserIdWithSortYMD(Integer userid, String yearmonthday);
    List<BBill> selectBillsByUserIdYMD(Integer userid, String yearmonthday);

    List<BBill> selectOutBillsByUserIdAndSortIdWithSortYM(Integer userid, Integer sortid, String yearmonth);
    List<BBill> selectInBillsByUserIdAndSortIdWithSortYM(Integer userid, Integer sortid, String yearmonth);

    String getTotalIncomeByUserIdWithYearMonth(Integer userid, String yearmonth);
    String getTotalOutcomeByUserIdWithYearMonth(Integer userid, String yearmonth);
    String getTotalIncomeByUserIdWithSortIdYM(Integer userid, Integer sortid, String yearmonth);
    String getTotalOutcomeByUserIdWithSortIdYM(Integer userid, Integer sortid, String yearmonth);
    String getTotalIncomeByUserIdWithPayIdYM(Integer userid, Integer payid, String yearmonth);
    String getTotalOutcomeByUserIdWithPayIdYM(Integer userid, Integer payid, String yearmonth);
    String getTotalIncomeByUserIdWithYearMonthDay(Integer userid, String yearmonthday);
    String getTotalOutcomeByUserIdWithYearMonthDay(Integer userid, String yearmonthday);

    BBill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BBill record, @Param("example") BBillExample example);

    int updateByExample(@Param("record") BBill record, @Param("example") BBillExample example);

    int updateByPrimaryKeySelective(BBill record);

    int updateByPrimaryKey(BBill record);
}