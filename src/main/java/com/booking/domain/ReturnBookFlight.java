package com.booking.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "returnticket")
public class ReturnBookFlight {
	private List<String> rfullname;
	private int rnoOfPerson;
	private int ramount;
	@Id
	private String ticketNo;
	private String journeyType;
	private String rflightNo;
	private String rdepature;
	private String rdepatureTime;
	private String rarrival;
	private String rarrivalTime;
	private String rbookingReference;
	private String rselectClass;
	
	public List<String> getRfullname() {
		return rfullname;
	}
	public void setRfullname(List<String> rfullname) {
		this.rfullname = rfullname;
	}
	public int getRnoOfPerson() {
		return rnoOfPerson;
	}
	public void setRnoOfPerson(int rnoOfPerson) {
		this.rnoOfPerson = rnoOfPerson;
	}
	public int getRamount() {
		return ramount;
	}
	public void setRamount(int ramount) {
		this.ramount = ramount;
	}
	public String getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getJourneyType() {
		return journeyType;
	}
	public void setJourneyType(String journeyType) {
		this.journeyType = journeyType;
	}
	public String getRflightNo() {
		return rflightNo;
	}
	public void setRflightNo(String rflightNo) {
		this.rflightNo = rflightNo;
	}
	public String getRdepature() {
		return rdepature;
	}
	public void setRdepature(String rdepature) {
		this.rdepature = rdepature;
	}
	public String getRdepatureTime() {
		return rdepatureTime;
	}
	public void setRdepatureTime(String rdepatureTime) {
		this.rdepatureTime = rdepatureTime;
	}
	public String getRarrival() {
		return rarrival;
	}
	public void setRarrival(String rarrival) {
		this.rarrival = rarrival;
	}
	public String getRarrivalTime() {
		return rarrivalTime;
	}
	public void setRarrivalTime(String rarrivalTime) {
		this.rarrivalTime = rarrivalTime;
	}
	public String getRbookingReference() {
		return rbookingReference;
	}
	public void setRbookingReference(String rbookingReference) {
		this.rbookingReference = rbookingReference;
	}
	public String getRselectClass() {
		return rselectClass;
	}
	public void setRselectClass(String rselectClass) {
		this.rselectClass = rselectClass;
	}
	
	

}
