package com.shivam.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shivam.date.CurrentDate;
import com.shivam.models.EmployeeOutIn;
import com.shivam.services.DatewiseReportService;

@Controller
public class DatewiseReportController 
{
	@Autowired private DatewiseReportService service;
	
	@RequestMapping("datewise-report")
	public String reportHomeView(Model model)
	{
		model.addAttribute("dt", LocalDate.now().toString());
		return "choose-date";
	}
	@RequestMapping("current-date")
	public String getCurrentDateReport(Model model)
	{
		List<EmployeeOutIn> list = service.getCurrentDateList();
		model.addAttribute("elist", list);
		model.addAttribute("msg", "Report Of Current date");
		model.addAttribute("noout", "No employee is out yet today");
		return "date-wise-report";
	}
	@RequestMapping("any-date")
	public String getAnyDateReport(String date, Model model)
	{
		date = CurrentDate.changeDateFormat(date);
		List<EmployeeOutIn> list = service.getAnyDateList(date);
		model.addAttribute("elist", list);
		model.addAttribute("msg", "Report of date "+date);
		model.addAttribute("nout", "No employee is on "+date);
		return "date-wise-report";
	}
	@RequestMapping("date-between")
	public String getAnyDateReport(String date1, String date2, Model model)
	{
		date1 = CurrentDate.changeDateFormat(date1);
		date2 = CurrentDate.changeDateFormat(date2);
		List<EmployeeOutIn> list = service.getDateBetweenList(date1,date2);
		model.addAttribute("elist", list);
		model.addAttribute("msg", "Report of date between "+date1+" and "+date2);
		model.addAttribute("noout", "No employee is between "+date1+" and "+date2);
		return "date-wise-report";
	}
}
