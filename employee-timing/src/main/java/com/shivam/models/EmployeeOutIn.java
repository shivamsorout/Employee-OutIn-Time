package com.shivam.models;

import javax.persistence.*;

@Entity
public class EmployeeOutIn 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int eid;
	private String outgoingTime;
	private String incomingTime;
	private String totalTime;
	private String date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getOutgoingTime() {
		return outgoingTime;
	}
	public void setOutgoingTime(String outgoingTime) {
		this.outgoingTime = outgoingTime;
	}
	public String getIncomingTime() {
		return incomingTime;
	}
	public void setIncomingTime(String incomingTime) {
		this.incomingTime = incomingTime;
	}
	public String getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
