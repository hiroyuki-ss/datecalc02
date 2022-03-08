package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DateCalculation;
import com.example.demo.repository.DateCalcMapper;

@Service
public class DateCalcService {

	@Autowired
	private DateCalcMapper mapper;

	public List<DateCalculation> selectAll() {
		return mapper.selectAll();
	}

	public DateCalculation selectOne(String dateId) {
		return mapper.selectOne(dateId);
	}

	public void insert(DateCalculation date) {
		mapper.insert(date);
	}

	public void update(DateCalculation date) {
		mapper.update(date);
	}

	public void delete(String dateId) {
		mapper.delete(dateId);
	}

}