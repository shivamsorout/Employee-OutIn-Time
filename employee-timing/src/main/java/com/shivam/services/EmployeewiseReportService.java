package com.shivam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivam.models.EmployeeOutIn;
import com.shivam.repositories.EmployeewiseReportRepository;

@Service
public class EmployeewiseReportService 
{
	@Autowired private EmployeewiseReportRepository repo;

	public List<EmployeeOutIn> getCurrentDateList(int eid)
	{
		return repo.getCurrentDateList(eid);
	}

	public List<EmployeeOutIn> getAnyDateList(String date,int eid) 
	{
		return repo.getAnyDateList(date,eid);
	}

	public List<EmployeeOutIn> getDateBetweenList(String date1, String date2,int eid) 
	{
		return repo.getDateBetweenReport(date1,date2,eid);
	}
}
