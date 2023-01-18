package com.shivam.date;

import java.time.LocalDate;

public class CurrentDate 
{
	public static String getDate()
	{
		LocalDate dt = LocalDate.now();
		String date = dt.getDayOfMonth()+"-"+dt.getMonthValue()+"-"+dt.getYear();
		return date;
	}
	public static String changeDateFormat(String date)
	{
		String [] str = date.split("-");
		date = str[2]+"-"+str[1]+"-"+str[0];
		return date;
	}
}
