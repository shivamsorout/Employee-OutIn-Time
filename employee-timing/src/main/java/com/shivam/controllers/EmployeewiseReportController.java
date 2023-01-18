package com.shivam.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shivam.date.CurrentDate;
import com.shivam.models.Employee;
import com.shivam.models.EmployeeOutIn;
import com.shivam.services.EmployeeService;
import com.shivam.services.EmployeewiseReportService;

@Controller
public class EmployeewiseReportController
{
	@Autowired private EmployeeService eservice;
	@Autowired private EmployeewiseReportService service;
	
	private String name;
	@RequestMapping("emplist")
	public String getEmployeeList(Model model)
	{ 
		List<Employee> list = eservice.getList();
		model.addAttribute("elist", list);
		return "employee-list";
	}
	@RequestMapping("date-menu")
	public String getDateMenu(Model model,int eid)
	{ 
		model.addAttribute("dt", LocalDate.now().toString());
		name=eservice.getEmployeeName(eid);
		model.addAttribute("eid", eid);
		model.addAttribute("name", name);
		return "choose-date2";
	}
	@RequestMapping("emp-current-date")
	public String getCurrentDateReport(Model model,int eid)
	{
		List<EmployeeOutIn> list = service.getCurrentDateList(eid);
		model.addAttribute("elist", list);
		model.addAttribute("msg", "Report Of Current date");
		model.addAttribute("noout", "No employee is out yet today");
		return "employeewise-report";
	}
	@RequestMapping("emp-any-date")
	public String getAnyDateReport(String date,int eid,Model model)
	{
		date = CurrentDate.changeDateFormat(date);
		List<EmployeeOutIn> list = service.getAnyDateList(date,eid);
		model.addAttribute("elist", list);
		model.addAttribute("msg", "Report of date "+date);
		model.addAttribute("nout", "No employee is on "+date);
		return "employeewise-report";
	}
	@RequestMapping("emp-date-between")
	public String getAnyDateReport(String date1, String date2,int eid, Model model)
	{
		date1 = CurrentDate.changeDateFormat(date1);
		date2 = CurrentDate.changeDateFormat(date2);
		List<EmployeeOutIn> list = service.getDateBetweenList(date1,date2,eid);
		model.addAttribute("elist", list);
		model.addAttribute("msg", "Report of date between "+date1+" and "+date2);
		model.addAttribute("noout", "No employee is between "+date1+" and "+date2);
		return "employeewise-report";
	}
}
