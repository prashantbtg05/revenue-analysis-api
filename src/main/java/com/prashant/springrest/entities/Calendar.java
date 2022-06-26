package com.prashant.springrest.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calendar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int calendar_id;
	Date calendar_date;
	int calendar_year;
	int calendar_month_number;
	String calendar_month_name;
	int calendar_day_of_month;
	int calendar_day_of_week;
	String calendar_day_name;
	int calendar_year_month;
	
	public Date getCalendar_date() {
		return calendar_date;
	}
	public void setCalendar_date(Date calendar_date) {
		this.calendar_date = calendar_date;
	}
	public int getCalendar_year() {
		return calendar_year;
	}
	public void setCalendar_year(int calendar_year) {
		this.calendar_year = calendar_year;
	}
	public int getCalendar_month_number() {
		return calendar_month_number;
	}
	public void setCalendar_month_number(int calendar_month_number) {
		this.calendar_month_number = calendar_month_number;
	}
	public String getCalendar_month_name() {
		return calendar_month_name;
	}
	public void setCalendar_month_name(String calendar_month_name) {
		this.calendar_month_name = calendar_month_name;
	}
	public int getCalendar_day_of_month() {
		return calendar_day_of_month;
	}
	public void setCalendar_day_of_month(int calendar_day_of_month) {
		this.calendar_day_of_month = calendar_day_of_month;
	}
	public int getCalendar_day_of_week() {
		return calendar_day_of_week;
	}
	public void setCalendar_day_of_week(int calendar_day_of_week) {
		this.calendar_day_of_week = calendar_day_of_week;
	}
	public String getCalendar_day_name() {
		return calendar_day_name;
	}
	public void setCalendar_day_name(String calendar_day_name) {
		this.calendar_day_name = calendar_day_name;
	}
	public int getCalendar_year_month() {
		return calendar_year_month;
	}
	public void setCalendar_year_month(int calendar_year_month) {
		this.calendar_year_month = calendar_year_month;
	}	

	
}
