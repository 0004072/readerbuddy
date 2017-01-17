package com.hsenid.reader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.security.NoSuchAlgorithmException;

/**
 * Created by 0004072 on 1/16/17.
 *
 */
public class ReaderBuddy
{
    public static void main( String[] args )
    {
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("META-INF/Beans.xml");
        UserJDBCTemplate userJbdcObj = beanFactory.getBean("userJDBCTemplate", UserJDBCTemplate.class);
        Utilities utils = beanFactory.getBean("utilities", Utilities.class);
        LoginForm loginForm = beanFactory.getBean("loginform", LoginForm.class);
    }
}
