package com.epam.testapp.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.epam.testapp.bean.ForCheckboxes;
import com.epam.testapp.bean.News;
import com.epam.testapp.dao.DAOFactory;
import com.epam.testapp.dao.DAOImpl;

public class NewsServiceImpl implements Service {
	DAOFactory daoFactory= DAOFactory.getInstance();
	DAOImpl daoImpl = daoFactory.getDAOImpl();
	
	@Override
	public News editNewsServ(HttpServletRequest request) {
		News editNews=null;
		return editNews=daoImpl.editNewsDAOMethod(editNews, request);
	}

	@Override
	public News addNewsServ() {
		News addNews = new News();
		daoImpl.addNewsDAOMethod();
		return addNews;
	}
	
	@Override
	public void processAddNewsServ(News addNews) {	
		daoImpl.processAddDAOMethod(addNews);
	}
		
	@Override
	public News viewNewsServ(HttpServletRequest request) {
		News viewNews=null;	
		return viewNews=daoImpl.viewDAOMethod(viewNews, request);
	}

	@Override
	public List<News> showNewsListServ() {
		List<News> NewsList=null;
		return NewsList=daoImpl.showNewsListDAOMethod(NewsList);
	}

	@Override
	public void processEditNewsServ(News processEditNewsModel, HttpServletRequest request) {
		daoImpl.processEditNewsDAOMethod(processEditNewsModel, request);				
	}

	@Override
	public List<News> processCheckboxServ(ForCheckboxes first) {	
		return daoImpl.processCheckboxDAOMethod(first);
	}

	@Override
	public void processDeleteNewsServ(HttpServletRequest request) {
		String idForHQL=request.getParameter("id");
		String[] arrayForHQL=idForHQL.substring(1, idForHQL.length() - 1).split(", ");
		daoImpl.processDeleteNewsDAOMethod(arrayForHQL);	
	}
	
}
