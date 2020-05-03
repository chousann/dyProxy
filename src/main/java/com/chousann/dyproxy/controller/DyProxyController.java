package com.chousann.dyproxy.controller;

import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chousann.dyproxy.proxy.IModelMath;
import com.chousann.dyproxy.proxy.IModelMathImpl;
import com.chousann.dyproxy.proxy.JdkDynamicProxy;

@RestController
@CrossOrigin
public class DyProxyController {
	@RequestMapping(value = "/dy")
	@CrossOrigin
	public String getSecret(String userId, String password) {
		// 需要被代理的动态对象
		IModelMath imm = new IModelMathImpl();
		// 代理对象
		IModelMath math = new JdkDynamicProxy(imm).iModelMathmethod();
		
		math.print("被代理");
		return "ok";
	}
}
