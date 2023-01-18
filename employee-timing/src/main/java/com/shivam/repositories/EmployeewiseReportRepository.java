package com.shivam.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shivam.date.CurrentDate;
import com.shivam.models.EmployeeOutIn;
import com.shivam.session.CurrentSession;

@Repository
public class EmployeewiseReportRepository 
{
	private Session ses;
	private Transaction t;
	
	@Autowired
	public EmployeewiseReportRepository(SessionFactory factory)
	{
		if(CurrentSession.ses==null)
		{
			CurrentSession.ses = factory.openSession();
		}
		ses=CurrentSession.ses;
		t=ses.getTransaction();
	}

	public List<EmployeeOutIn> getCurrentDateList(int eid)
	{
		Query<EmployeeOutIn> q = ses.createQuery("from EmployeeOutIn where date=:arg1 and eid=:arg2");
		q.setParameter("arg1", CurrentDate.getDate());
		q.setParameter("arg2", eid);
		List<EmployeeOutIn> elist = q.list();
		return elist;
	}

	public List<EmployeeOutIn> getAnyDateList(String date,int eid) 
	{
		Query<EmployeeOutIn> q = ses.createQuery("from EmployeeOutIn where date=:arg1 and eid=:arg2");
		q.setParameter("arg1", date);
		q.setParameter("arg2", eid);
		List<EmployeeOutIn> elist = q.list();
		return elist;
	}

	public List<EmployeeOutIn> getDateBetweenReport(String date1, String date2,int eid) 
	{
		Query<EmployeeOutIn> q = ses.createQuery("from EmployeeOutIn where date between :arg1 and :arg2 and eid=:arg3");
		q.setParameter("arg1", date1);
		q.setParameter("arg2", date2);
		q.setParameter("arg3", eid);
		List<EmployeeOutIn> elist = q.list();
		return elist;
	}
}
