package com.epam.testapp.dao;

public class DAOFactory {
	private static DAOFactory instance=null;
	private final DAOImpl daoImpl=new DAOImpl();
	
	private DAOFactory() {}
	
	
	public static DAOFactory getInstance() {
		if(instance == null){
			instance = new DAOFactory();
		}
		return instance;
	}
	
	public DAOImpl getDAOImpl() {
		return daoImpl;
	}

}
