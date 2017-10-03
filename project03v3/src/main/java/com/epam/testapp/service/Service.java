package com.epam.testapp.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.epam.testapp.bean.ForCheckboxes;
import com.epam.testapp.bean.News;

public interface Service {
	public List<News> showNewsListServ();
	public News addNewsServ();
	public void processAddNewsServ(News addNews);
	public News viewNewsServ(HttpServletRequest request);
	public News editNewsServ(HttpServletRequest request);
	public void processEditNewsServ(News processEditNewsModel, HttpServletRequest request);
	public List<News> processCheckboxServ(ForCheckboxes first);
	public void processDeleteNewsServ(HttpServletRequest request);
}
