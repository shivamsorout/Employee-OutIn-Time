package com.shivam.repositories;

import java.time.LocalTime;
import java.util.List;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shivam.models.EmployeeOutIn;
import com.shivam.session.CurrentSession;
import com.shivam.date.CurrentDate;
import com.shivam.models.Employee;

@Repository
public class EmployeeRepositories
{
	private Session ses;
	private Transaction t;
	@Autowired
	public EmployeeRepositories(SessionFactory factory)
	{
		if(CurrentSession.ses==null)
		{
			CurrentSession.ses=factory.openSession();
		}
		ses=CurrentSession.ses;
		t=ses.getTransaction();
	}
	public List<Employee> getCustomerList() 
	{
		Query<Employee> q = ses.createQuery("from Employee");
//		List<Employee> elist = q.list();
		return q.list();
	}
	public void saveEmployeeOutgoingTime(EmployeeOutIn outin) 
	{
		t.begin();
		ses.save(outin);
		t.commit();
	}
	public boolean isIncomingTimeRecordExist(int eid)
	{
		Query<Long> q = ses.createQuery("select count(*) from EmployeeOutIn where eid=:arg1 and incomingTime is null and date=:arg2");
		q.setParameter("arg1", eid);
		q.setParameter("arg2", CurrentDate.getDate());
		long n = q.getSingleResult();
		return n==0;
	}
	public void setEmployeeIncomingTime(int eid) 
	{
		Query<EmployeeOutIn> q = ses.createQuery("from EmployeeOutIn where eid=:arg1 and incomingTime is null and date=:arg2");
		q.setParameter("arg1", eid);
		q.setParameter("arg2", CurrentDate.getDate());
		EmployeeOutIn emp = q.getSingleResult();
		LocalTime lt = LocalTime.now();
		int total = totalTime(emp.getOutgoingTime(),lt);
		String time = lt.getHour()+":"+lt.getMinute();
		t.begin();
		emp.setIncomingTime(time);
		emp.setTotalTime(total+" minute");
		t.commit();
	}
	private int totalTime(String out, LocalTime lt) 
	{
		String [] str = out.split(":");
		int total = (lt.getHour()*60+lt.getMinute())-(Integer.parseInt(str[0])*60+Integer.parseInt(str[1]));
		return total;
	}
	public Employee getRecord(int eid) 
	{
		return ses.get(Employee.class,eid);
	}
	public String getName(int eid) 
	{
		Query<String> q = ses.createQuery("select e.name from Employee e where eid=:arg1");
		q.setParameter("arg1", eid);
		return q.getSingleResult();
	}

}
