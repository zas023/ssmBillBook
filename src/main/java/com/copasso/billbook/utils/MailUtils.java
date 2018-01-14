package com.copasso.billbook.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 邮件工具类
 */
public class MailUtils {

    /**
     * @param sendTo  邮件接收着地址
     * @param subject 邮件主题
     * @param msg     邮件正文
     * @return true发送成功|false发送失败
     */
    public static boolean send(String sendTo, String subject, String msg) {
        try {
            String host = "smtp.163.com";//这是163邮箱的smtp服务器地址
//            String host = "220.181.12.14";//这是163邮箱的smtp服务器地址
            String port = "465"; //端口号
            /*
             *Properties是一个属性对象，用来创建Session对象
             */
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", host);
            props.setProperty("mail.smtp.port", port);
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.ssl.enable", "true");//"true"
            props.setProperty("mail.smtp.connectiontimeout", "5000");
            final String user = "18725912261@163.com";//用户名
            final String pwd = "zas19960607zyr";//密码
            /*
             *Session类定义了一个基本的邮件对话。
             */
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    //登录用户名密码
                    return new PasswordAuthentication(user,pwd);
                }
            });
            session.setDebug(true);
            /*
             *Transport类用来发送邮件。
             *传入参数smtp，transport将自动按照smtp协议发送邮件。
             */
            Transport transport = session.getTransport("smtp");//"smtps"
            transport.connect(host,user,pwd);
            /*
             *Message对象用来储存实际发送的电子邮件信息
             */
            MimeMessage message = new MimeMessage(session);
            message.setSubject(subject);
            //消息发送者接收者设置(发件地址，昵称)，收件人看到的昵称是这里设定的
            message.setFrom(new InternetAddress(user,"CocoBill"));
            message.addRecipients(Message.RecipientType.TO,new InternetAddress[]{
                    //消息接收者(收件地址，昵称)
                    //不过这个昵称貌似没有看到效果
                    new InternetAddress(sendTo,"Mr.x"),
            });
            message.saveChanges();

            //设置邮件内容及编码格式
            //后一个参数可以不指定编码，如"text/plain"，但是将不能显示中文字符
            message.setContent(msg, "text/plain;charset=UTF-8");
            //发送
            //transport.send(message);
            Transport.send(message);
            transport.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

}