package com.shivam.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.shivam.date.CurrentDate;
import com.shivam.models.EmployeeOutIn;
import com.shivam.session.CurrentSession;

@Repository
public class DatewiseReportRepository 
{
	private Session ses;
	private Transaction t;
	public DatewiseReportRepository(SessionFactory factory)
	{
		if(CurrentSession.ses==null)
		{
			CurrentSession.ses = factory.openSession();
		}
		ses=CurrentSession.ses;
		t=ses.getTransaction();
	}

	public List<EmployeeOutIn> getCurrentDateList()
	{
		Query<EmployeeOutIn> q = ses.createQuery("from EmployeeOutIn where date=:arg");
		q.setParameter("arg", CurrentDate.getDate());
		List<EmployeeOutIn> elist = q.list();
		return elist;
	}

	public List<EmployeeOutIn> getAnyDateList(String date) 
	{
		Query<EmployeeOutIn> q = ses.createQuery("from EmployeeOutIn where date=:arg");
		q.setParameter("arg", date);
		List<EmployeeOutIn> elist = q.list();
		return elist;
	}

	public List<EmployeeOutIn> getDateBetweenReport(String date1, String date2) 
	{
		Query<EmployeeOutIn> q = ses.createQuery("from EmployeeOutIn where date between :arg1 and :arg2");
		q.setParameter("arg1", date1);
		q.setParameter("arg2", date2);
		List<EmployeeOutIn> elist = q.list();
		return elist;
	}

}
