package com.epam.testapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.epam.testapp.bean.News;
import com.epam.testapp.service.NewsServiceImpl;
import com.epam.testapp.service.ServiceFactory;
import com.epam.testapp.bean.ForCheckboxes;

@Controller
@RequestMapping("/startpage")
public class NewsController {
	ServiceFactory serviceFactory = ServiceFactory.getInstance();
	NewsServiceImpl NewsServiceImpl = serviceFactory.getNewsService();
	
	@RequestMapping("/mainpage")
	public String newsManagment(Model firstListModel) {
		ForCheckboxes fchb=new ForCheckboxes();
		firstListModel.addAttribute("DeleteList", fchb);
		firstListModel.addAttribute("firstPageList", NewsServiceImpl.showNewsListServ());
		return "news-management";
	}
	
	@RequestMapping("/add")
	public String addNews(Model addModel) {
		addModel.addAttribute("addNewsModel", NewsServiceImpl.addNewsServ());
		return "add-news-form";
	}
	@RequestMapping("processAddNews")
	public String processAddNews(@Valid@ModelAttribute ("addNewsModel") News addNews/*, Model dateModel*/, BindingResult theBindingResult) {	
		if (theBindingResult.hasErrors()) {
			return "add-news-form";
		}
		else {
		serviceFactory.getNewsService().processAddNewsServ(addNews);
		return "redirect:mainpage";}
	}
	
	@RequestMapping("/view")
	public String viewNews(Model viewModel, HttpServletRequest request, HttpServletResponse response) {
		viewModel.addAttribute("viewModel", NewsServiceImpl.viewNewsServ(request));
		ForCheckboxes fchb=new ForCheckboxes();
		viewModel.addAttribute("DeleteList", fchb);
		return "full-news-content";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/edit")
	public String editNews(Model editModel, HttpServletRequest request) {
		editModel.addAttribute("editModel", NewsServiceImpl.editNewsServ(request));
		return "edit-news-page";
	}
	
	@RequestMapping("/show-edited-content")
	public String processEditNews(@ModelAttribute("editModel") News processEditNewsModel, HttpServletRequest request) {
		NewsServiceImpl.processEditNewsServ(processEditNewsModel, request);
		return "show-result";
	}
	
	@RequestMapping("/processCheckbox")
	public String processCheckbox(@ModelAttribute("DeleteList") ForCheckboxes first, Model checkboxModel) { 
		checkboxModel.addAttribute("checkboxInfo", serviceFactory.getNewsService().processCheckboxServ(first));
		return "checkbox-content";
	}
	
	@RequestMapping("/delete")
	public String processDeleteNews(HttpServletRequest request) {		
		NewsServiceImpl.processDeleteNewsServ(request);
		return "redirect:mainpage";
		}
	////////////////////
	
	@RequestMapping("/mainpage-rus")
	public String newsManagmentRus(Model firstListModel) {
		ForCheckboxes fchb=new ForCheckboxes();
		firstListModel.addAttribute("DeleteList", fchb);
		firstListModel.addAttribute("firstPageList", NewsServiceImpl.showNewsListServ());
		return "news-management-rus";
	}
	
	@RequestMapping("/add-rus")
	public String addNewsRus(Model addModel) {
		addModel.addAttribute("addNewsModel", NewsServiceImpl.addNewsServ());
		return "add-news-form-rus";
	}
	@RequestMapping("processAddNews-rus")
	public String processAddNewsRus(@Valid@ModelAttribute ("addNewsModel") News addNews, BindingResult theBindingResult) {	
		if (theBindingResult.hasErrors()) {
			return "add-news-form-rus";
		}
		else {
			NewsServiceImpl.processAddNewsServ(addNews);
		return "redirect:mainpage-rus";}
	}
	
	@RequestMapping("/view-rus")
	public String viewNewsRus(Model viewModel, HttpServletRequest request, HttpServletResponse response) {
		viewModel.addAttribute("viewModel", NewsServiceImpl.viewNewsServ(request));
		ForCheckboxes fchb=new ForCheckboxes();
		viewModel.addAttribute("DeleteList", fchb);
		return "full-news-content-rus";
	}
	
	
	@RequestMapping("/edit-rus")
	public String editNewsRus(Model editModel, HttpServletRequest request) {
		editModel.addAttribute("editModel", NewsServiceImpl.editNewsServ(request));
		return "edit-news-page-rus";
	}
	
	@RequestMapping("/show-edited-content-rus")
	public String processEditNewsRus(@ModelAttribute("editModel") News processEditNewsModel, HttpServletRequest request) {
		NewsServiceImpl.processEditNewsServ(processEditNewsModel, request);
		return "show-result-rus";
	}
	
	@RequestMapping("/processCheckbox-rus")
	public String processCheckboxRus(@ModelAttribute("DeleteList") ForCheckboxes first, Model checkboxModel) { 
		checkboxModel.addAttribute("checkboxInfo", NewsServiceImpl.processCheckboxServ(first));
		return "checkbox-content-rus";
	}
	
	@RequestMapping("/delete-rus")
	public String processDeleteNewsRus(HttpServletRequest request) {		
		NewsServiceImpl.processDeleteNewsServ(request);
		return "redirect:mainpage-rus";
		}	
}
