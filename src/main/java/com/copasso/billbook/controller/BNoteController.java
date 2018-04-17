package com.copasso.billbook.controller;

import com.copasso.billbook.bean.*;
import com.copasso.billbook.service.BPayService;
import com.copasso.billbook.service.BSortService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 账单分类Sort和支付方式Payinfo控制类
 */
@Controller
@RequestMapping("note")
public class BNoteController {

    @Autowired
    private BSortService bSortService;
    @Autowired
    private BPayService bPayService;

    @RequestMapping("/test")
    @ResponseBody
    public String testNote(){
        return "{status:100, message:处理成功！,outSortlis:[{id:1,uid:0,sortName:还款,sortImg:sort_huankuan.png,priority:0,income:false},{id:2,uid:0,sortName:手续费,sortImg:sort_shouxufei.png,priority:null,income:false},{id:3,uid:0,sortName:违约金,sortImg:sort_weiyuejin.png,priority:null,income:false},{id:4,uid:0,sortName:住房,sortImg:sort_zhufang.png,priority:null,income:false},{id:5,uid:0,sortName:办公,sortImg:sort_bangong.png,priority:null,income:false},{id:6,uid:0,sortName:餐饮,sortImg:sort_canyin.png,priority:null,income:false},{id:7,uid:0,sortName:医疗,sortImg:sort_yiliao.png,priority:null,income:false},{id:8,uid:0,sortName:运动,sortImg:sort_yundong@2x.png,priority:null,income:false},{id:9,uid:0,sortName:娱乐,sortImg:sort_yule@2x.png,priority:null,income:false},{id:10,uid:0,sortName:居家,sortImg:sort_jujia.png,priority:null,income:false},{id:11,uid:0,sortName:宠物,sortImg:sort_chongwu.png,priority:null,income:false},{id:12,uid:0,sortName:数码,sortImg:sort_shuma.png,priority:null,income:false},{id:13,uid:0,sortName:捐赠,sortImg:sort_juanzeng.png,priority:null,income:false},{id:14,uid:0,sortName:零食,sortImg:sort_lingshi.png,priority:null,income:false},{id:15,uid:0,sortName:孩子,sortImg:sort_haizi.png,priority:null,income:false},{id:16,uid:0,sortName:长辈,sortImg:sort_zhangbei.png,priority:null,income:false},{id:17,uid:0,sortName:礼物,sortImg:sort_liwu.png,priority:null,income:false},{id:18,uid:0,sortName:学习,sortImg:sort_xuexi.png,priority:null,income:false},{id:19,uid:0,sortName:水果,sortImg:sort_shuiguo.png,priority:null,income:false},{id:20,uid:0,sortName:美容,sortImg:sort_meirong.png,priority:null,income:false},{id:21,uid:0,sortName:维修,sortImg:sort_weixiu.png,priority:null,income:false},{id:22,uid:0,sortName:旅行,sortImg:sort_lvxing.png,priority:null,income:false},{id:23,uid:0,sortName:交通,sortImg:sort_jiaotong.png,priority:null,income:false},{id:24,uid:0,sortName:饮料,sortImg:sort_jiushui.png,priority:null,income:false},{id:25,uid:0,sortName:礼金,sortImg:sort_lijin.png,priority:null,income:false}],inSortlis:[{id:26,uid:0,sortName:礼金,sortImg:sort_lijin.png,priority:null,income:true},{id:27,uid:0,sortName:奖励,sortImg:sort_jiangjin.png,priority:null,income:true},{id:28,uid:0,sortName:利息,sortImg:sort_lixi.png,priority:null,income:true},{id:29,uid:0,sortName:返现,sortImg:sort_fanxian.png,priority:null,income:true},{id:30,uid:0,sortName:兼职,sortImg:sort_jianzhi.png,priority:null,income:true}],payinfo:[{id:1,uid:0,payName:现金,payImg:cash@2x.png,payNum:null},{id:2,uid:0,payName:支付宝,payImg:account@2x.png,payNum:null},{id:3,uid:0,payName:微信,payImg:account@2x.png,payNum:null}]}";
    }

    /**
     * 通过用户id查询支付分类信息
     * @param id
     * @return
     */
    @RequestMapping("/user/{id}")
    @ResponseBody
    public NoteListBean userNoteinfo(@PathVariable("id") Integer id){
        NoteListBean noteListBean=new NoteListBean();
        noteListBean.setInSortlis(bSortService.findInSortByUserId(id));
        noteListBean.setOutSortlis(bSortService.findOutSortByUserId(id));
        noteListBean.setPayinfo(bPayService.findPayinfoByUserId(id));
        noteListBean.setSuccess();
        return noteListBean;
    }

    /**
     * 通过sortid查询分类信息
     * @param id
     * @return
     */
    @RequestMapping("/sort/{id}")
    @ResponseBody
    public List<BSort> sortinfo(@PathVariable("id") Integer id){
        return bSortService.findInSortByUserId(id);
    }


    /**
     * 添加账单分类
     * @param uid
     * @param sortName
     * @param sortImg
     * @param income
     * @return
     */
    @RequestMapping("/sort/add")
    @ResponseBody
    public BSort2 addSort(@Param("uid") Integer uid, @Param("sortName") String sortName,
                          @Param("sortImg") String sortImg, @Param("income") Boolean income){
        BSort sort=new BSort(uid,sortName,sortImg,income);
        int result=bSortService.addSort(sort);
        if (result==0)
            return (BSort2) new BSort2().fail();
        return (BSort2) new BSort2(sort).success();
    }

    /**
     * 修改自定义sort分类
     * @param id
     * @param uid
     * @param sortName
     * @param sortImg
     * @param income
     * @return
     */
    @RequestMapping("/sort/update")
    @ResponseBody
    public BSort2 updateSort(@Param("id") Integer id,@Param("uid") Integer uid,@Param("sortName") String sortName,
                         @Param("sortImg") String sortImg,@Param("income") Boolean income){
        BSort sort=new BSort(id,uid,sortName,sortImg,null,income);
        int result=bSortService.addSort(sort);
        if (result==0)
            return (BSort2) new BSort2().fail();
        return (BSort2) new BSort2(sort).success();
    }

    /**
     * 通过payid查询分类信息
     * @param id
     * @return
     */
    @RequestMapping("/pay/delete/{id}")
    @ResponseBody
    public List<BPay> deletePay(@PathVariable("id") Integer id){
        return bPayService.findPayinfoByUserId(id);
    }

    /**
     * 通过payid查询分类信息
     * @param id
     * @return
     */
    @RequestMapping("/pay/{id}")
    @ResponseBody
    public List<BPay> payinfo(@PathVariable("id") Integer id){
        return bPayService.findPayinfoByUserId(id);
    }

    /**
     * 添加支付信息
     * @param uid
     * @param payName
     * @param payImg
     * @param payNum
     * @return
     */
    @RequestMapping("/pay/add")
    @ResponseBody
    public BPay2 addPay(@Param("uid") Integer uid,@Param("payName") String payName,
                         @Param("payImg") String payImg,@Param("payNum") String payNum){
        BPay pay=new BPay(uid,payName,payImg,payNum);
        int result=bPayService.addPayinfo(pay);
        if (result==0)
            return (BPay2) new BPay2().fail();
        return (BPay2) new BPay2(pay).success();
    }

    /**
     * 修改自定义支付方式
     * @param id
     * @param uid
     * @param payName
     * @param payImg
     * @param payNum
     * @return
     */
    @RequestMapping("/pay/update")
    @ResponseBody
    public BPay2 addPay(@Param("id") Integer id, @Param("uid") Integer uid, @Param("payName") String payName,
                        @Param("payImg") String payImg, @Param("payNum") String payNum){
        BPay pay=new BPay(id,uid,payName,payImg,payNum);
        int result=bPayService.addPayinfo(pay);
        if (result==0)
            return (BPay2) new BPay2().fail();
        return (BPay2) new BPay2(pay).success();
    }

}
