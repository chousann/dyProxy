package com.chousann.dyproxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 动态代理模式类 第一种代理模式：Jdk动态代理 注意：实现InvocationHandler这个接口
 *
 * 基于接口的
 */
public class JdkDynamicProxy implements InvocationHandler {
	// 定义需要代理的接口
	protected IModelMath iModelMath;

	// 将需要代理的接口作为参数传入到动态代理设计模式类中
	public JdkDynamicProxy(IModelMath iModelMath) {
		this.iModelMath = iModelMath;
	}

	/**
	 * 生成代理对象 使用java.lang.reflect.Proxy这个类调用newProxyInstance方法 返回 动态代理类对象
	 */
	public IModelMath iModelMathmethod() {
		IModelMath iModelMathProxy = (IModelMath) Proxy.newProxyInstance(iModelMath.getClass().getClassLoader(),
				iModelMath.getClass().getInterfaces(), this);
		return iModelMathProxy;
	}

	/**
	 * 开始做代理的操作 Object proxy 代理对象的引用 Method method 当前执行的方法 Object[] args 当前执行方法的参数
	 * 返回 与被代理对象返回的值相同
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("你调用的方法为：" + method.getName());
		System.out.println("你调用的方法参数有：" + Arrays.toString(args));
		Object invoke = method.invoke(iModelMath, args);
		System.out.println("方法的返回数据：" + invoke);
		return invoke;
	}
}
