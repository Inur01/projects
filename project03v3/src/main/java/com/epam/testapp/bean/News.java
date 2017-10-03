package com.epam.testapp.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="news2")
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
	private Long id;
	
	@NotNull(message="is required")
	@Size(min=3, message="minimum 3 symbols")
	@Size(max=100, message="maximum 100 symbols")
	@Column(name="newsTitle")
	private String newsTitle;
	
	@NotNull(message="is required")
	@Size(max=10, message="maximum 10 symbols in format dd/mm/yyyy")
	//@Pattern(regexp="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\\\d\\\\d)", message="Invalid   date. Use dd/MM/yyyy")
	//@Pattern(regexp="(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}", message="Invalid   date. Use dd/MM/yyyy")
	//@Pattern(regexp="(((0[1-9]|[12][0-9]|3[01])([-./])(0[13578]|10|12)([-./])(\\d{4}))|(([0][1-9]|[12][0-9]|30)([-./])(0[469]|11)([-./])(\\d{4}))|((0[1-9]|1[0-9]|2[0-8])([-./])(02)([-./])(\\d{4}))|((29)(\\.|-|\\/)(02)([-./])([02468][048]00))|((29)([-./])(02)([-./])([13579][26]00))|((29)([-./])(02)([-./])([0-9][0-9][0][48]))|((29)([-./])(02)([-./])([0-9][0-9][2468][048]))|((29)([-./])(02)([-./])([0-9][0-9][13579][26])))", message="change date")
	@Column(name="newsDate")
	private String newsDate;
	
	@NotNull(message="is required")
	@Size(max=500, message="maximum 500 symbols")
	@Column(name="brief")
	private String brief;
	
	@NotNull(message="is required")
	@Size(max=2048, message="maximum 2048 symbols")
	@Column(name="content")
	private String content;
	
	public News() {	
	}
	public News(Long id, String newsTitle, String newsDate, String brief, String content) {
	}
	public News(String id, String newsTitle, String newsDate, String brief, String content) {
	}
	
	public String getNewsTitle() {
		//System.out.println("getNewsTitle: "+newsTitle);
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		//System.out.println("setNewsTitle: "+newsTitle);
		this.newsTitle = newsTitle;
	}
	public String getNewsDate() {
	    if(newsDate!=null) {
		try {
			SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
			SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
			Date date = oldDateFormat.parse(newsDate);
			newsDate = newDateFormat.format(date);
		} catch (ParseException e) {
			//e.printStackTrace();
			System.out.println("Processing date in News.getNewsDate(String newsDate)");
			}
		}
	    else {	    	
	    	  LocalDate date = LocalDate.now();
	    	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    	  newsDate = date.format(formatter);
	    }
		return newsDate;
	}
	
	public void setNewsDate(String newsDate) {
	    try {
			SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
			SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
			Date date = oldDateFormat.parse(newsDate);
			newsDate = newDateFormat.format(date);
		} catch (ParseException e) {
			//e.printStackTrace();
			System.out.println("Processing date in News.setNewsDate(String newsDate)");
		}
		this.newsDate = newsDate;
	}
	
	public String getBrief() {
		return brief;
	}
	
	public void setBrief(String brief) {
		this.brief=brief;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content=content;
	}

	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setId(String id) {
		this.id = Long.valueOf(id);
	}
}
