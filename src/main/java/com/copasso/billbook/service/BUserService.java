package com.copasso.billbook.service;

import com.copasso.billbook.bean.BUser;
import com.copasso.billbook.dao.BUserMapper;
import com.copasso.billbook.utils.MDUtils;
import com.copasso.billbook.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * 用户User操作类
 */
@Service
public class BUserService {

    @Autowired
    private BUserMapper bUserMapper;

    /**
     * 添加用户
     * @param user
     * @return
     */
    public BUser register(BUser user){
        BUser user2=bUserMapper.selectByUserName(user.getUsername());
        user.setSuccess();
        if(user2!=null){
            user.setFail("用户名已经存在");
            return user;
        }
        user2=user;
        user2.setSuccess();
        try {
            //将明文密码转换成MD5存储
            user2.setPassword(MDUtils.encodeMD2ToStr(user.getPassword()));
            //生成UUID作邮箱验证
            String code = UUID.randomUUID().toString() + UUID.randomUUID().toString();
            code = code.replaceAll("-", "");
            user2.setMailcode(code);
            //向注册邮箱发送验证文件
            MailUtils.send(user2.getMail(), "CocoBill",
                    "恭喜注册成功，请点击链接激活！http://139.199.176.173:8080/ssmBillBook/user/mail/verify?code="+code);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        user2.setState(0);
        bUserMapper.insert(user2);
        return user2;
    }

    /**
     * 用户登陆检测
     * @param user
     * @return
     */
    public BUser checkLogin(BUser user) {

        BUser user2=bUserMapper.selectByUserName(user.getUsername());

        if (user2==null){
            user.setFail("用户不存在");
            return user;
        }else{
            try {
                if(user2.getPassword().equals(MDUtils.encodeMD2ToStr(user.getPassword()))){
                    user2.setSuccess();
                    return user2;
                }else{
                    user.setFail("密码错误");
                    return user;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        user.setFail("未知错误");
        return user;
    }

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    public BUser findUserById(Integer id){
        return bUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据用户username查询用户
     * @param name
     * @return
     */
    public BUser findUserByUserName(String name){
        BUser user=bUserMapper.selectByUserName(name);
        if (user==null){
            user=new BUser();
            user.setFail("用户名不存在");
            return user;
        }
        return user;
    }

    /**
     * 注册邮箱验证
     * @param code
     * @return
     */
    public BUser verifyMail(String code) {
        BUser user=bUserMapper.selectByMailCode(code);
        user.setSuccess();
        if(user==null){
            user.setFail("验证链接已失效");
            return user;
        }
        user.setState(1);
        bUserMapper.updateByPrimaryKey(user);
        return user;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public int updateUser(BUser user){
        return bUserMapper.updateByPrimaryKeySelective(user);
    }
}
