package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DateCalculation {

	@NotBlank
	private String dateId;

	@NotBlank
	private String dateName;

	@NotNull
	private Integer year;

	@NotNull
	private Integer month;

	@NotNull
	private Integer day;

	public String getDateId() {
		return dateId;
	}

	public void setDateId(String dateId) {
		this.dateId = dateId;
	}

	public String getDateName() {
		return dateName;
	}

	public void setDateName(String dateName) {
		this.dateName = dateName;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}
}
