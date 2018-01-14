package com.copasso.billbook.controller;

import com.copasso.billbook.bean.BMessage;
import com.copasso.billbook.bean.BUser;
import com.copasso.billbook.service.BUserService;
import com.copasso.billbook.utils.MDUtils;
import com.copasso.billbook.utils.MailUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.NoSuchAlgorithmException;

/**
 * 用户User控制类
 */
@Controller
@RequestMapping("user")
public class BUserController {

    @Autowired
    private BUserService bUserService;

    /**
     * 返回用户列表页面
     * @return
     */
    @RequestMapping("")
    public String userlist(){
        return "userlist";
    }

    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public BUser login(@Param("username")String username,@Param("password")String password){

        return bUserService.checkLogin(new BUser(username,password));
    }

    /**
     * 添加用户，返回状态值
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("sign")
    @ResponseBody
    public BUser signup(@Param("username")String username,@Param("password")String password,
                        @Param("mail")String mail){
        return bUserService.register(new BUser(username,password,mail));
    }

    /**
     * 更新用户信息
     * @param id
     * @param username
     * @param gender
     * @param phone
     * @param mail
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public BUser updateUser(@Param("id")Integer id,@Param("username")String username,
                            @Param("gender")String gender,@Param("phone")String phone,
                            @Param("mail")String mail){
        int result=bUserService.updateUser(new BUser(id,username,gender,phone,mail));
        BUser user=bUserService.findUserById(id);
        user.setSuccess();
        if (result==0)
            //result：影响行数，若为0即为失败
            user.setFail();
        return user;
    }

    /**
     * 忘记密码
     * @param username
     * @param mail
     * @return
     */

    @RequestMapping("forgetPw")
    @ResponseBody
    public BUser forgetPw(@Param("username")String username,@Param("mail")String mail){
        BUser user=bUserService.findUserByUserName(username);

        //用户名不存在
        if (user==null){
            user=new BUser();
            user.fail("用户名不存在");
            return user;
        }
        //清除密码
        //user.setPassword(null);
        //验证邮箱是否匹配
        if (user.getMail().equals(mail)){
            //随机产生6位验证码
            String code= String.valueOf((int)(Math.random()*9+1)*100000);
            user.setMailcode(code);
            //更新数据
            bUserService.updateUser(user);
            MailUtils.send(user.getMail(),"CocoBill记账系统",
                    "您正在通过注册邮箱修改密码（如非本人操作，请忽略此次操作），验证码是："+code);
            user.setSuccess();
        }else{
            user.fail("用户名与注册邮箱不匹配");
        }
        return user;
    }

    /**
     * 修改密码
     * @param username
     * @param password
     * @param code
     * @return
     */
    @RequestMapping("changePw")
    @ResponseBody
    public BUser changePw(@Param("username")String username,
                          @Param("password")String password,@Param("code")String code){
        //修改密码，不需要验证码
        if (code=="000000"){
            BUser user=bUserService.findUserByUserName(username);
            try {
                user.setPassword(MDUtils.encodeMD5ToStr(password));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            bUserService.updateUser(user);
            user.setSuccess();
            return user;
        }
        //忘记密码，需要验证码
        BUser user=bUserService.findUserByUserName(username);
        //用户名不存在
        if (user==null){
            user=new BUser();
            user.fail("用户名不存在");
            return user;
        }
        //清除密码
        //user.setPassword(null);
        //验证邮箱是否匹配
        if (user.getMailcode().equals(code)){
            try {
                user.setPassword(MDUtils.encodeMD2ToStr(password));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            //更新数据
            bUserService.updateUser(user);
            user.setSuccess();
        }else{
            user.fail("验证码不正确");
        }
        return user;
    }

    /**
     * 用户注册邮箱验证
     * @param code
     * @return
     */
    @RequestMapping("mail/verify")
    @ResponseBody
    public String  verifyMail(@Param("code")String code){
        BUser user= bUserService.verifyMail(code);
        if (user.getStatus()==100)
            return user.getMessage();
        return "邮箱验证成功，请返回登陆";
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @RequestMapping("id/{id}")
    @ResponseBody
    public BMessage lookupUserById(@PathVariable("id")Integer id ){
        return BMessage.success().add("user",bUserService.findUserById(id));
    }

    /**
     * 根据name查询用户
     * @param name
     * @return
     */
    @RequestMapping("name/{name}")
    @ResponseBody
    public BUser lookupUserByName(@PathVariable("name")String name){
        return  bUserService.findUserByUserName(name);
    }
}
