package com.epam.testapp.service;

public final class ServiceFactory{
	private static ServiceFactory instance = null;
	private final NewsServiceImpl newsServiceImpl=new NewsServiceImpl();
	//private final UserServiceImpl userServiceImpl=new UserServiceImpl();--for user
	private ServiceFactory() {}

	public static ServiceFactory getInstance() {
		if(instance == null){
			instance = new ServiceFactory();
		}
		return instance;
	}
	
	public NewsServiceImpl getNewsService() {
		return newsServiceImpl;
	}

}
