package com.shivam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivam.models.EmployeeOutIn;
import com.shivam.repositories.DatewiseReportRepository;

@Service
public class DatewiseReportService 
{
	@Autowired private DatewiseReportRepository repo;

	public List<EmployeeOutIn> getCurrentDateList()
	{
		return repo.getCurrentDateList();
	}

	public List<EmployeeOutIn> getAnyDateList(String date) 
	{
		return repo.getAnyDateList(date);
	}

	public List<EmployeeOutIn> getDateBetweenList(String date1, String date2) 
	{
		return repo.getDateBetweenReport(date1,date2);
	}

}
