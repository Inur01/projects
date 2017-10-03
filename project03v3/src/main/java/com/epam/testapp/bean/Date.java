package com.epam.testapp.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
	private String date;

	Date(){
  	  LocalDate date = LocalDate.now();
  	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  	  this.date = date.format(formatter);
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
