package com.copasso.billbook.utils;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 邮件工具类
 */
public class MailUtils {

    /**
     * @param to      邮件接收着地址
     * @param subject 邮件主题
     * @param msg     邮件正文
     * @return true发送成功|false发送失败
     */
    public static boolean send(String to, String subject, String msg) {
        Properties props = new Properties();
        // 邮件传输的协议
        props.setProperty("mail.transport.protocol", "smtp");
        // 连接的邮件服务器
        props.setProperty("mail.host", "smtp.163.com");
        props.setProperty("mail.smtp.auth", "true");
        // 发送人
        //props.put("mail.from", "18725912261@163.com");

        // 第一步：创建Session
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        try {
            // 第二步：获取邮件传输对象
            Transport ts = session.getTransport();
            // 连接邮件服务器
            ts.connect("smtp.163.com","18725912261@163.com", "zas19960607zyr");
            // 第三步: 创建邮件消息体
            MimeMessage message = new MimeMessage(session);
            // 设置邮件的主题
            message.setSubject(subject);
            // 设置邮件的内容
            message.setContent(msg, "text/html;charset=utf-8");
            // 第四步：设置发送昵称
            String nick = "";
            try {
                nick = javax.mail.internet.MimeUtility.encodeText("Mr.x");
            } catch (Exception e) {
                e.printStackTrace();
            }
            //设置发件人地址
            message.setFrom(new InternetAddress(nick + " <18725912261@163.com>"));
            // 第五步：设置接收人信息
            ts.sendMessage(message, InternetAddress.parse(to));
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

}