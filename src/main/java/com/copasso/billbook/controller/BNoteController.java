package com.copasso.billbook.controller;

import com.copasso.billbook.bean.BSort;
import com.copasso.billbook.bean.NoteListBean;
import com.copasso.billbook.service.BPayService;
import com.copasso.billbook.service.BSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public BSort sortinfo(@PathVariable("id") Integer id){
        return bSortService.findSortById(id);
    }
}
