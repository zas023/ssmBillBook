package com.copasso.billbook.bean;

import java.util.Date;

public class BBill {
    private Integer id;

    private Float cost;

    private String content;

    private Integer userid;

    private Integer payid;

    private Integer sortid;

    private Date crdate;

    private Boolean income;

    private BSort sort;

    public BBill(){
        super();
    }

    public BBill(Float cost, String content, Integer userid, Integer sortid,Integer payid,  Date crdate, Boolean income) {
        this.cost = cost;
        this.content = content;
        this.userid = userid;
        this.payid = payid;
        this.sortid = sortid;
        this.crdate = crdate;
        this.income = income;
    }

    public BSort getSort() {
        return sort;
    }

    public void setSort(BSort sort) {
        this.sort = sort;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPayid() {
        return payid;
    }

    public void setPayid(Integer payid) {
        this.payid = payid;
    }

    public Integer getSortid() {
        return sortid;
    }

    public void setSortid(Integer sortid) {
        this.sortid = sortid;
    }

    public Date getCrdate() {
        return crdate;
    }

    public void setCrdate(Date crdate) {
        this.crdate = crdate;
    }

    public Boolean getIncome() {
        return income;
    }

    public void setIncome(Boolean income) {
        this.income = income;
    }
}