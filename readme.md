A：动态刷新bean
	1：首先获取applicationContext
		@Autowired
		public ApplicationContext acx;
	2：从applicationContext中获取指定bean
		Message msg = (Message)acx.getBean("message");
	3：更新bean的属性值
		msg.getContent().put("dymsg", "i am dy msg");
	以上只对单例（singlestone）模式有用
	
B：更新.xml文件厚，重新加载.xml文件
	1：首先获取applicationContext
		@Autowired
		public ApplicationContext acx;
	2：加载指定的.xml文件到一个临时applicationContext中（默认从classPath加载，指定"file:"前缀可以从文件路径加载）
		ClassPathXmlApplicationContext appcx = new ClassPathXmlApplicationContext("file:D:\\workspaces\\springworkspaces\\dyproxy\\src\\main\\resources\\bean.xml");
	3：从临时applicationContext中获取指定bean的属性值更新到工作化境的applicationContext中
		Message msg1 = (Message)appcx.getBean("message"); //从临时applicationContext中获取指定bean
		Message msg = (Message)acx.getBean("message");	  //工作化境的applicationContext中获取指定bean
		msg.setContent(msg1.getContent());                //从临时applicationContext中获取指定bean的属性值更新到工作化境的applicationContext中
	以上也只对单例（singlestone）模式有用
C：