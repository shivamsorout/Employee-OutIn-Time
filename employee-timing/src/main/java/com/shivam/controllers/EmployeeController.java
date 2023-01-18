package com.shivam.controllers;

import java.time.LocalTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shivam.models.EmployeeOutIn;
import com.shivam.date.CurrentDate;
import com.shivam.models.Employee;
import com.shivam.services.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/")
	public String getHomeView()
	{
		return "home";
	}
	@RequestMapping("out")
	public String getEmployeeOutView(Model model)
	{
		List<Employee> list = service.getList();
		model.addAttribute("elist", list);
		return "employee-out";
	}
	@RequestMapping("saveOutgoingTime")
	public String saveEmployeeOutgoingTime(EmployeeOutIn outin)
	{
		boolean exist = service.getEmployeeIncomingTimeRecord(outin.getEid());
		if(!exist)
		{
			return "outgoing-fail";
		}
		LocalTime lt = LocalTime.now();
		String time = lt.getHour()+":"+lt.getMinute();
		outin.setOutgoingTime(time);
		outin.setDate(CurrentDate.getDate());
		service.saveEmployeeOutgoingTimeRecord(outin);
		return "outgoing-success";
	}
	@RequestMapping("in")
	public String getEmployeeInView(Model model)
	{
		List<Employee> list = service.getList();
		model.addAttribute("elist", list);
		return "employee-in";
	}
	@RequestMapping("saveIncomingTime")
	public String saveEmployeeIncomingTime(int eid)
	{
		boolean exist = service.getEmployeeIncomingTimeRecord(eid);
		if(exist)
		{
			return "incoming-fail";
		}
		service.updateEmployeeIncomingTimeRecord(eid);
		return "incoming-success";
	}
	@RequestMapping("emp-details")
	public String getEmployeeDetails(int eid, Model model)
	{
		Employee emp = service.getEmployeeRecord(eid);
		model.addAttribute("employee", emp);
		return "employee-details";
	}
}
