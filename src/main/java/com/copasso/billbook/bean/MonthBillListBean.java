package com.copasso.billbook.bean;

import java.util.List;

/**
 * 月账单明细详情
 */
public class MonthBillListBean extends BaseBean{
    private String  t_income;    //本月总收入
    private String t_outcome;    //本月总支出
    private String l_outcome;    //上月总支出
    private List<DayBillList> daylist;

    public String getT_income() {
        return t_income;
    }

    public void setT_income(String t_income) {
        this.t_income = t_income;
    }

    public String getT_outcome() {
        return t_outcome;
    }

    public void setT_outcome(String t_outcome) {
        this.t_outcome = t_outcome;
    }

    public String getL_outcome() {
        return l_outcome;
    }

    public void setL_outcome(String l_outcome) {
        this.l_outcome = l_outcome;
    }

    public List<DayBillList> getDaylist() {
        return daylist;
    }

    public void setDaylist(List<DayBillList> daylist) {
        this.daylist = daylist;
    }

    public static class DayBillList {

        private String time;
        private String  money;
        private List<BBill> list;


        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String  getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public List<BBill> getList() {
            return list;
        }

        public void setList(List<BBill> list) {
            this.list = list;
        }
    }
}

