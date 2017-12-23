package com.copasso.billbook.service;

import com.copasso.billbook.bean.BBill;
import com.copasso.billbook.dao.BBillMapper;
import com.copasso.billbook.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账单Bill操作类
 */
@Service
public class BBillService {

    @Autowired
    private BBillMapper bBillMapper;

    /**
     * 添加账单
     * @param bill
     */
    public int insertBill(BBill bill){
       return bBillMapper.insert(bill);
    }

    /**
     * 更新账单
     * @param bill
     */
    public int updateBill(BBill bill){
        return bBillMapper.updateByPrimaryKeySelective(bill);
    }

    /**
     * 删除账单
     * @param billId
     */
    public int deleteBill(int billId){
        return bBillMapper.deleteByPrimaryKey(billId);
    }

    /**
     * 根据账单id查询账单
     * @param id
     * @return
     */
    public BBill findBillById(Integer id){
        return  bBillMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据用户id查询账单
     * @param userid
     * @return
     */
    public List<BBill> findBillsByUserId(Integer userid){
        return bBillMapper.selectByUserId(userid);
    }

    /**
     * 根据用户id查询某年某月某日账单
     * @param userid
     * @param date
     * @return
     */
    public List<BBill> findBillsByUserIdWithYearMouthDay(Integer userid,String date){
        return bBillMapper.selectBillsByUserIdWithSortYMD(userid,date);
    }

    /**
     * 根据用户id查询某年某月某日账单，返回详情
     * @param userid
     * @param date
     * @return
     */
    public List<BBill> findChatsByUserIdWithYSortYM(Integer userid,Integer sortid,String date,boolean income){
        if(income)
            return bBillMapper.selectInBillsByUserIdAndSortIdWithSortYM(userid,sortid,date);
        return bBillMapper.selectOutBillsByUserIdAndSortIdWithSortYM(userid,sortid,date);
    }

    /**
     * 返回每月收支情况，返回总额
     * @param userid
     * @param date
     * @return
     */
    public String  getTotalIncomeByUserIdWithYearMonth(Integer userid,String date){
        return StringUtils.null2Zero(bBillMapper.getTotalIncomeByUserIdWithYearMonth(userid,date));
    }
    public String  getTotalOutcomeByUserIdWithYearMonth(Integer userid,String date){
        return StringUtils.null2Zero(bBillMapper.getTotalOutcomeByUserIdWithYearMonth(userid,date));
    }

    /**
     * 返回每月每种分类收支情况，返回总额
     * @param userid
     * @param date
     * @return
     */
    public String  getTotalIncomeByUserIdAndSortIdYM(Integer userid,Integer sortid,String date){
        return StringUtils.null2Zero(bBillMapper.getTotalIncomeByUserIdWithSortIdYM(userid,sortid,date));
    }
    public String  getTotalOutcomeByUserIdAndSortIdYM(Integer userid,Integer sortid,String date){
        return StringUtils.null2Zero(bBillMapper.getTotalOutcomeByUserIdWithSortIdYM(userid,sortid,date));
    }

    /**
     * 返回每月每种支付方式收支情况，返回总额
     * @param userid
     * @param date
     * @return
     */
    public String  getTotalIncomeByUserIdWithPayIdYM(Integer userid,Integer sortid,String date){
        return StringUtils.null2Zero(bBillMapper.getTotalIncomeByUserIdWithPayIdYM(userid,sortid,date));
    }
    public String  getTotalOutcomeByUserIdWithPayIdYM(Integer userid,Integer sortid,String date){
        return StringUtils.null2Zero(bBillMapper.getTotalOutcomeByUserIdWithPayIdYM(userid,sortid,date));
    }

    /**
     * 返回每天收支情况，返回总额
     * @param userid
     * @param date
     * @return
     */
    public String  getTotalIncomeByUserIdWithYearMonthDay(Integer userid,String date){
        return StringUtils.null2Zero(bBillMapper.getTotalIncomeByUserIdWithYearMonthDay(userid,date));
    }
    public String  getTotalOutcomeByUserIdWithYearMonthDay(Integer userid,String date){
        return StringUtils.null2Zero(bBillMapper.getTotalOutcomeByUserIdWithYearMonthDay(userid,date));
    }
}
