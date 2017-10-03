package com.epam.testapp.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epam.testapp.bean.ForCheckboxes;
import com.epam.testapp.bean.News;

public interface DAO {
	public Session hiberanteStart();
	public void hibernateCommit(Session session);
	public void hibernateClose(SessionFactory factory);
	public void processAddDAOMethod(News addNews);
	public News viewDAOMethod(News viewNews, HttpServletRequest request);
	public News editNewsDAOMethod(News editNews, HttpServletRequest request);
	public void processEditNewsDAOMethod(News processEditNewsModel, HttpServletRequest request);
	public void addNewsDAOMethod();
	public List<News> showNewsListDAOMethod(List<News> NewsList);
	public List<News> processCheckboxDAOMethod(ForCheckboxes first);
	public void processDeleteNewsDAOMethod(String[] arrayForHQL);
}
