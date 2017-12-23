package com.copasso.billbook.bean;

import java.util.List;

public class NoteListBean extends BaseBean {

    private List<BSort> outSortlis;    //记一笔支出数据
    private List<BSort> inSortlis;     //记一笔收入数据

    private List<BPay> payinfo;    //记一笔支付信息数据

    public List<BSort> getOutSortlis() {
        return outSortlis;
    }

    public void setOutSortlis(List<BSort> outSortlis) {
        this.outSortlis = outSortlis;
    }

    public List<BSort> getInSortlis() {
        return inSortlis;
    }

    public void setInSortlis(List<BSort> inSortlis) {
        this.inSortlis = inSortlis;
    }

    public List<BPay> getPayinfo() {
        return payinfo;
    }

    public void setPayinfo(List<BPay> payinfo) {
        this.payinfo = payinfo;
    }
}
