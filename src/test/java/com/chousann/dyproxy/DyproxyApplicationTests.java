package com.chousann.dyproxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.chousann.dyproxy.model.Message;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DyproxyApplicationTests {

	@Test
	public void contextLoads() {
		
		FileSystemXmlApplicationContext appcx = new FileSystemXmlApplicationContext("D:\\workspaces\\springworkspaces\\dyproxy\\src\\main\\resources/*.xml");
		DefaultListableBeanFactory defaultListableBeanFactory =(DefaultListableBeanFactory) ((ConfigurableApplicationContext)appcx).getBeanFactory();
		BeanDefinition beanDefinition = defaultListableBeanFactory.getBeanDefinition("message");
		String[] beans = appcx.getBeanDefinitionNames();
		for (String beanName : beans) {
			Class<?> beanType = appcx.getType(beanName);
			System.out.println("BeanName:" + beanName);
			System.out.println("Bean的类型：" + beanType);
			System.out.println("Bean所在的包：" + beanType.getPackage());
			System.out.println("Bean：" + appcx.getBean(beanName));
			System.out.println("");
		}
		Message msg1 = (Message)appcx.getBean("message");
	}

}
