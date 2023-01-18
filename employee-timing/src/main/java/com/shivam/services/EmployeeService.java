package com.shivam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivam.models.EmployeeOutIn;
import com.shivam.models.Employee;
import com.shivam.repositories.EmployeeRepositories;

@Service
public class EmployeeService
{
	@Autowired
	private EmployeeRepositories repo;
	
	public List<Employee> getList() 
	{
		List<Employee> list = repo.getCustomerList();
		return list;
	}

	public void saveEmployeeOutgoingTimeRecord(EmployeeOutIn outin) 
	{
		repo.saveEmployeeOutgoingTime(outin);
	}
	public boolean getEmployeeIncomingTimeRecord(int eid) 
	{
		return repo.isIncomingTimeRecordExist(eid);
	}

	public void updateEmployeeIncomingTimeRecord(int eid) 
	{	
		repo.setEmployeeIncomingTime(eid);
	}

	public Employee getEmployeeRecord(int eid) 
	{
		return repo.getRecord(eid);
	}

	public String getEmployeeName(int eid)
	{
		
		return repo.getName(eid);
	}
}
