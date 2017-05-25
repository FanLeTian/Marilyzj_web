package com.marilyzj.utils;

import java.io.IOException;
import java.util.Properties;  

import javax.mail.Authenticator;  
import javax.mail.Message;  
import javax.mail.Message.RecipientType;  
import javax.mail.MessagingException;  
import javax.mail.PasswordAuthentication;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.AddressException;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
/** 
 * 邮件发送工具类 
 * @author 丁国华 
 * 
 */  
public class MailUitls {  
    /** 
     * 发送邮件的方法 
     * @param to    :收件人 
     * @param code  :激活码 
     * @throws IOException 
     */  
    public static void sendMail(String to,String code){  
        /** 
         * 1.获得一个Session对象. 
         * 2.创建一个代表邮件的对象Message. 
         * 3.发送邮件Transport 
         */  
        // 1.获得连接对象  
    	Properties props = new Properties();  
        props.setProperty("mail.smtp.auth", "true");//需要验证身份
        Session session = Session.getInstance(props, new Authenticator() {  
            @Override  
            protected PasswordAuthentication getPasswordAuthentication() {  
                return new PasswordAuthentication(Constant.mail_Authen, Constant.mail_password);  
            }  
        });  
        // 2.创建邮件对象:  
        Message message = new MimeMessage(session);  
        // 设置发件人:  
        try {  
            message.setFrom(new InternetAddress(Constant.mail_Authen));  
            // 设置收件人:  
            message.addRecipient(RecipientType.TO, new InternetAddress(to));  
            message.setSubject("来自Marilyzj的官方邮件");  
            // 设置邮件正文:  
//            message.setContent("<h1>来自Marilyzj的官方邮件!点下面链接完成操作!</h1><h3><a href='http://172.27.35.10:8080/sm/login_active.action?code="+code+"'>http://172.27.35.10:8080/sm/login_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8"); 
            message.setContent("<h1>来自Marilyzj的官方邮件!点下面链接完成操作!</h1>"
            		+ "<h3><a href='http://172.27.35.10:8080/sm/login_active.action?code="+code+"'>"+code+"</a></h3>", "text/html;charset=UTF-8"); 

            // 3.发送邮件:  
            Transport.send(message);  
        } catch (AddressException e) {  
            e.printStackTrace();  
        } catch (MessagingException e) {  
            e.printStackTrace();  
        }  
          
    }  
      
   
}  
