package com.example.demo.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.DateCalculation;
import com.example.demo.model.SearchDate;
import com.example.demo.service.DateCalcService;

@Controller
public class DateCalcController {

	@Autowired
	private DateCalcService service;

	@GetMapping("/home")
	public String getHome(@ModelAttribute SearchDate searchDate, Model model) {
		return "home/home";

	}

	@GetMapping("/search")
	public String search(@ModelAttribute @Validated SearchDate searchDate, BindingResult bindingResult, Model model)
			throws ParseException {
		if (bindingResult.hasErrors()) {
			return getHome(searchDate, model);
		}

		List<DateCalculation> resultDate = service.selectAll();
		Map<Integer, Object> resultCalc = new HashMap<>();

		for (int i = 0; i < resultDate.size(); i++) {
			DateCalculation date = resultDate.get(i);
			LocalDate result = searchDate.getSearchDate();
			result = result.plusYears(date.getYear());
			result = result.plusMonths(date.getMonth());
			result = result.plusDays(date.getDay());

			resultCalc.put(i + 1, result);
		}
		model.addAttribute("resultDate", resultDate);
		model.addAttribute("resultCalc", resultCalc);
		return "home/home";
	}

	@GetMapping("/register")
	public String registerDisplay(@ModelAttribute DateCalculation date) {
		return "home/register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute DateCalculation date) {
		service.insert(date);
		return "redirect:/home";
	}

	@GetMapping("/update/{dateId}")
	public String updateDisplay(@PathVariable String dateId, Model model) {
		DateCalculation updateDate = service.selectOne(dateId);
		model.addAttribute("updateDate", updateDate);
		return "home/update";
	}

	@PostMapping("/update/{dateId}")
	public String update(@ModelAttribute DateCalculation date) {
		service.update(date);
		return "redirect:/home";
	}

	@PostMapping("/delete/{dateId}")
	public String delete(@PathVariable String dateId) {
		service.delete(dateId);
		return "redirect:/home";
	}
}