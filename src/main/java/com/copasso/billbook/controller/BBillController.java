package com.copasso.billbook.controller;

import com.copasso.billbook.bean.*;
import com.copasso.billbook.service.BBillService;
import com.copasso.billbook.service.BPayService;
import com.copasso.billbook.service.BSortService;
import com.copasso.billbook.utils.DateUtils;
import com.copasso.billbook.utils.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 账单Bill控制类
 */
@Controller
@RequestMapping("bill")
public class BBillController {

    @Autowired
    private BBillService bBillService;
    @Autowired
    private BSortService bSortService;
    @Autowired
    private BPayService bPayService;

    /**
     * 添加账单
     *
     * @param cost
     * @param content
     * @param userid
     * @param sortid
     * @param payid
     * @param crdate
     * @param income
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public BBill addBill(@Param("cost") Float cost, @Param("content") String content,
                       @Param("userid") int userid, @Param("sortid") int sortid, @Param("payid") int payid,
                       @Param("crdate") String crdate, @Param("income") boolean income) {

        BBill bBill = new BBill(cost, content, userid, sortid, payid, DateUtils.strToDate(crdate), income);
        int result = bBillService.insertBill(bBill);
        if (result != 0)
            return null;
        return bBill;
    }

    /**
     * 更新账单
     *
     * @param id
     * @param cost
     * @param content
     * @param userid
     * @param sortid
     * @param payid
     * @param crdate
     * @param income
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public BBill upadteBill(@Param("id")int id, @Param("cost") Float cost, @Param("content") String content,
                         @Param("userid") int userid, @Param("sortid") int sortid, @Param("payid") int payid,
                         @Param("crdate") String crdate, @Param("income") boolean income) {

        BBill bBill = new BBill(cost, content, userid, sortid, payid, DateUtils.strToDate(crdate), income);
        bBill.setId(id);
        int result = bBillService.updateBill(bBill);
        if (result != 0)
            return null;
        return bBill;
    }

    /**
     * 通过账单id删除账单
     *
     * @param id
     * @return
     */
    @RequestMapping("delete/{id}")
    @ResponseBody
    public BaseBean removeById(@PathVariable("id") Integer id) {
        BBill bBill = bBillService.findBillById(id);
        BaseBean baseBean = new BaseBean();
        baseBean.setFail();
        if (bBillService.deleteBill(id) != 0)
            baseBean.setSuccess();
        return baseBean;
    }

    /**
     * 通过账单id查询账单
     *
     * @param id
     * @return
     */
    @RequestMapping("find/{id}")
    @ResponseBody
    public BBill findById(@PathVariable("id") Integer id) {
        return bBillService.findBillById(id);
    }


    /**
     * 通过用户id查询某月收支情况，返回账账单明细
     *
     * @param id
     * @param year
     * @param month
     * @return
     */
    @RequestMapping("user/{id}/{yy}/{mm}")
    @ResponseBody
    public MonthBillListBean findDetailByUserIdWithYM(@PathVariable("id") Integer id,
                                                      @PathVariable("yy") String year, @PathVariable("mm") String month) {

        MonthBillListBean monthBillListBean = new MonthBillListBean();
        List<MonthBillListBean.DayBillList> daylist = new ArrayList<>();

        monthBillListBean.setT_income(bBillService.getTotalIncomeByUserIdWithYearMonth(id, year + "-" + month));
        monthBillListBean.setT_outcome(bBillService.getTotalOutcomeByUserIdWithYearMonth(id, year + "-" + month));
        monthBillListBean.setL_outcome(bBillService.getTotalOutcomeByUserIdWithYearMonth(
                id, DateUtils.getLastMonth(year + "-" + month)));
        for (int day = DateUtils.getDays(Integer.parseInt(year), Integer.parseInt(month)); day > 0; day--) {
            //注意个位数的时间格式
            String day2 = String.format("%02d", day);
            List<BBill> bBills = bBillService.findBillsByUserIdWithYearMouthDay(id, year + "-" + month + "-" + day2);
            /**
             * bBills=[],此处不能直接判断bBills是否为null
             */
            if (bBills.size() != 0) {
                MonthBillListBean.DayBillList dayBillList = new MonthBillListBean.DayBillList();
                dayBillList.setList(bBills);
                String t_outcome = bBillService.getTotalOutcomeByUserIdWithYearMonthDay(id, year + "-" + month + "-" + day2);
                String t_income = bBillService.getTotalIncomeByUserIdWithYearMonthDay(id, year + "-" + month + "-" + day2);
                //money:支出：18268.00 收入：0.00
                dayBillList.setMoney("支出：" + t_outcome + " 收入：" + t_income);
                dayBillList.setTime(day2 + "日-" + DateUtils.getWeek(year + "-" + month + "-" + day2));
                daylist.add(dayBillList);
            }
        }

        monthBillListBean.setSuccess();
        if (daylist.size() == 0)
            monthBillListBean.setFail();

        monthBillListBean.setDaylist(daylist);
        return monthBillListBean;
    }

    /**
     * 通过用户id查询某月收支情况，返回报表信息
     *
     * @param userid
     * @param year
     * @param month
     * @return
     */
    @RequestMapping("chart/{userid}/{yy}/{mm}")
    @ResponseBody
    public MonthChartListBean findChartByUserIdWithYM(@PathVariable("userid") Integer userid,
                                                      @PathVariable("yy") String year, @PathVariable("mm") String month) {
        MonthChartListBean monthChartListBean = new MonthChartListBean();
        List<MonthChartListBean.SortTypeList> outSortlist=new ArrayList<>();
        List<MonthChartListBean.SortTypeList> inSortlist=new ArrayList<>();
        //获取用户的账单分类情况
        List<BSort> outSortList=bSortService.findOutSortByUserId(userid);
        List<BSort> inSortList=bSortService.findInSortByUserId(userid);
        //获取用户此月总收支
        monthChartListBean.setTotalIn(bBillService.getTotalIncomeByUserIdWithYearMonth(userid, year + "-" + month));
        monthChartListBean.setTotalOut(bBillService.getTotalOutcomeByUserIdWithYearMonth(userid, year + "-" + month));
        //获取用户上月总收支
        monthChartListBean.setL_totalIn(bBillService.getTotalIncomeByUserIdWithYearMonth(
                userid, DateUtils.getLastMonth(year + "-" + month)));
        monthChartListBean.setL_totalOut(bBillService.getTotalOutcomeByUserIdWithYearMonth(
                userid, DateUtils.getLastMonth(year + "-" + month)));

        //支出
        for (BSort sort:outSortList) {
            List<BBill> tempBBills=bBillService.findChatsByUserIdWithYSortYM(userid,sort.getId(),
                    year + "-" + month,false);
            if (tempBBills.size()!=0){
                MonthChartListBean.SortTypeList tempSortlist=new MonthChartListBean.SortTypeList();
                tempSortlist.setList(tempBBills);
                tempSortlist.setSort(sort);
                tempSortlist.setBack_color(StringUtils.randomColor());
                tempSortlist.setMoney(bBillService.getTotalOutcomeByUserIdAndSortIdYM(userid,
                        sort.getId(),year + "-" + month));
                outSortlist.add(tempSortlist);
            }
        }

        //收入
        for (BSort sort:inSortList) {
            List<BBill> tempBBills=bBillService.findChatsByUserIdWithYSortYM(userid,sort.getId(),
                    year + "-" + month,true);
            if (tempBBills.size()!=0){
                MonthChartListBean.SortTypeList tempSortlist=new MonthChartListBean.SortTypeList();
                tempSortlist.setList(tempBBills);
                tempSortlist.setSort(sort);
                tempSortlist.setBack_color(StringUtils.randomColor());
                tempSortlist.setMoney(bBillService.getTotalIncomeByUserIdAndSortIdYM(userid,
                        sort.getId(),year + "-" + month));
                inSortlist.add(tempSortlist);
            }
        }

        //添加账单分类详情
        monthChartListBean.setOutSortlist(outSortlist);
        monthChartListBean.setInSortlist(inSortlist);

        monthChartListBean.setSuccess();
        //收支均为0
        if(outSortlist.size()==0 && inSortlist.size()==0)
            monthChartListBean.setFail();

        return monthChartListBean;
    }

    /**
     * 通过用户id查询某月收支情况，返回支付方式信息
     *
     * @param userid
     * @param year
     * @param month
     * @return
     */
    @RequestMapping("pay/{userid}/{yy}/{mm}")
    @ResponseBody
    public MonthPayListBean findPayInfoByUserIdWithYM(@PathVariable("userid") Integer userid,
                                                      @PathVariable("yy") String year, @PathVariable("mm") String month) {
        MonthPayListBean monthPayListBean = new MonthPayListBean();
        List<MonthPayListBean.PayTypeListBean> list = new ArrayList<>();
        //获取用户的账单分类情况
        List<BPay> bPayList=bPayService.findPayinfoByUserId(userid);
        //获取用户此月总收支
        monthPayListBean.setTotalIn(bBillService.getTotalIncomeByUserIdWithYearMonth(userid, year + "-" + month));
        monthPayListBean.setTotalOut(bBillService.getTotalOutcomeByUserIdWithYearMonth(userid, year + "-" + month));
        //获取用户上月总收支
        monthPayListBean.setL_totalIn(bBillService.getTotalIncomeByUserIdWithYearMonth(
                userid, DateUtils.getLastMonth(year + "-" + month)));
        monthPayListBean.setL_totalOut(bBillService.getTotalOutcomeByUserIdWithYearMonth(
                userid, DateUtils.getLastMonth(year + "-" + month)));

        //支付信息
        for (BPay pay:bPayList) {

            MonthPayListBean.PayTypeListBean listBean=new MonthPayListBean.PayTypeListBean();
            listBean.setbPay(pay);

            String income=bBillService.getTotalIncomeByUserIdWithPayIdYM(userid,pay.getId(),year + "-" + month);
            String outcome=bBillService.getTotalOutcomeByUserIdWithPayIdYM(userid,pay.getId(),year + "-" + month);

            listBean.setIncome(income);
            listBean.setOutcome(outcome);
            list.add(listBean);
        }

        monthPayListBean.setList(list);
        monthPayListBean.setSuccess();

        return monthPayListBean;
    }

}
