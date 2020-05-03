package com.chousann.dyproxy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.chousann.dyproxy.model.Message;

@RestController
@CrossOrigin
public class TestController {
	
	@Autowired
	public ApplicationContext acx;
	
    @RequestMapping(value="/test")
    @CrossOrigin
    public String getSecret(String userId, String password){
		String[] beans = acx.getBeanDefinitionNames();
		for (String beanName : beans) {
			Class<?> beanType = acx.getType(beanName);
			System.out.println("BeanName:" + beanName);
			System.out.println("Bean的类型：" + beanType);
			System.out.println("Bean所在的包：" + beanType.getPackage());
			System.out.println("Bean：" + acx.getBean(beanName));
			System.out.println("");
		}
		DefaultListableBeanFactory defaultListableBeanFactory =(DefaultListableBeanFactory) ((ConfigurableApplicationContext)acx).getBeanFactory();
		BeanDefinition beanDefinition = defaultListableBeanFactory.getBeanDefinition("message");
		
		Message msg = (Message)acx.getBean("message");
		Map<String,String> map = msg.getContent();
		map.put("dymsg", "i am dy msg");
		
		msg.setContent(map);
		
//		beanDefinition.setAttribute("content", msg.getContent());
//		
//		defaultListableBeanFactory.removeBeanDefinition("message");
//		
//		defaultListableBeanFactory.registerBeanDefinition( "message", beanDefinition);
		
		


    	return "ok";
    }
    
}
