package com.example.demo.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class SearchDate {

	@NotNull
	@DateTimeFormat(pattern = "yyyyMMdd")
	private LocalDate searchDate;

	public LocalDate getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(LocalDate searchDate) {
		this.searchDate = searchDate;
	}
}
