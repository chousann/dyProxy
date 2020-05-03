package com.chousann.dyproxy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @Configuration：指明当前类是一个配置类；就是来替代之前的Spring配置文件
 *
 * 在配置文件中用<bean><bean/>标签添加组件
 *
 */
@ImportResource("classpath:bean.xml")
@Configuration
public class config {
//	//将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
//    @Bean(name="helloService")
//    public Helloservice helloService(){
//        System.out.println("配置类@Bean给容器中添加组件了...");
//        Helloservice service = new Helloservice();
//        service.setName("zxs");
//        service.setAge("26");
//        return service;
//    }
	
}
