package com.epam.testapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.epam.testapp.bean.ForCheckboxes;
import com.epam.testapp.bean.News;

public class DAOImpl implements DAO {
	
	@Override
	public Session hiberanteStart() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(News.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		return session;
	}

	@Override
	public void hibernateCommit(Session session) {
		session.getTransaction().commit();
		System.out.println("Succesfully commited");
	}

	@Override
	public void hibernateClose(SessionFactory factory) {
		System.out.println(factory.isClosed());
		factory.close();
		System.out.println(factory.isClosed());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<News> showNewsListDAOMethod(List<News> NewsList) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(News.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			NewsList = session.createQuery("FROM News ORDER BY newsDate desc, id desc").list();//LoginData--имя класса
			session.getTransaction().commit();
		} finally {
			System.out.println(factory.isClosed());
			factory.close();
			System.out.println(factory.isClosed());
		}
		/*if(session!=null) {
			System.out.println("У нас течь, капитан!");
			factory.close();
		}*/
		return NewsList;
	}
	
	@Override
	public News viewDAOMethod(News viewNews, HttpServletRequest request) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(News.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			viewNews = session.load(News.class, Long.valueOf(request.getParameter("id")));
			session.getTransaction().commit();
		} finally {
			//factory.close(); //not allowed to close		
		}
		return viewNews;
	}
	
	@Override
	public void addNewsDAOMethod() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(News.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.getTransaction().commit();
		} finally {
			factory.close();		
		}		
	}
	
	@Override
	public void processAddDAOMethod(News addNews) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(News.class)
				.buildSessionFactory();
				Session session = factory.openSession();
					session.beginTransaction();
					session.save(addNews);
					session.getTransaction().commit();
					factory.close();
					System.out.println("addprocess was succesfull");	
	}

	@Override
	public News editNewsDAOMethod(News editNews, HttpServletRequest request) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(News.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			editNews = session.load(News.class, Long.valueOf(request.getParameter("id")));
			session.getTransaction().commit();
			} finally {
			//factory.close();	
			}
		return editNews;
	}

	@Override
	public void processEditNewsDAOMethod(News processEditNewsModel, HttpServletRequest request) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(News.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		try {								
			session.beginTransaction();
			News processEditNews = session.load(News.class, Long.valueOf(request.getParameter("idForUpdate")));
			processEditNews.setNewsTitle(processEditNewsModel.getNewsTitle());
			processEditNews.setNewsDate(processEditNewsModel.getNewsDate());
			processEditNews.setBrief(processEditNewsModel.getBrief());
			processEditNews.setContent(processEditNewsModel.getContent());
			session.saveOrUpdate(processEditNews);
			session.getTransaction().commit();
			System.out.println("Editprocess was succesfull");
		}
		finally {
			factory.close();
			}
	}

	@Override
	public List<News> processCheckboxDAOMethod(ForCheckboxes first) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(News.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		List<News> NewsListForDelete=new ArrayList<News>();		
		for(String s:first.getCheckedId()) {
			News deleteConfirmedNews = session.load(News.class, Long.valueOf(s));
			NewsListForDelete.add(deleteConfirmedNews);		
		}
		//factory.close();
		return NewsListForDelete;
	}

	@Override
	public void processDeleteNewsDAOMethod(String[] arrayForHQL) {		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(News.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		for(int i=0; i<arrayForHQL.length; i++) {
			session.beginTransaction();
			News deleteConfirmedUser = session.load(News.class, Long.valueOf(arrayForHQL[i]));
			session.delete(deleteConfirmedUser);
			session.getTransaction().commit();
		}
		factory.close();
	}

}
