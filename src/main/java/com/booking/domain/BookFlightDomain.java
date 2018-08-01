package com.booking.domain;



import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tickets")
public class BookFlightDomain {
	
	
	private List<String> fullname;
	private int amount;
	private int noOfPerson;
	private String flightNo;
	private String depature;
	private String depatureTime;
	private String arrival;
	private String arrivalTime;
	private String bookingReference;
	private String selectClass;
	private String BookingTime;
	private String BookingDate;
	@Id
	private String ticketNo;
	private String selectAirport;
	private String status;
	
	
	
	
	
	
	
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getNoOfPerson() {
		return noOfPerson;
	}
	public void setNoOfPerson(int noOfPerson) {
		this.noOfPerson = noOfPerson;
	}
	public List<String> getFullname() {
		return fullname;
	}
	public void setFullname(List<String> fullname) {
		this.fullname = fullname;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getDepature() {
		return depature;
	}
	public void setDepature(String depature) {
		this.depature = depature;
	}
	public String getDepatureTime() {
		return depatureTime;
	}
	public void setDepatureTime(String depatureTime) {
		this.depatureTime = depatureTime;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getBookingReference() {
		return bookingReference;
	}
	public void setBookingReference(String bookingReference) {
		this.bookingReference = bookingReference;
	}
	public String getSelectClass() {
		return selectClass;
	}
	public void setSelectClass(String selectClass) {
		this.selectClass = selectClass;
	}
	public String getBookingTime() {
		return BookingTime;
	}
	public void setBookingTime(String bookingTime) {
		BookingTime = bookingTime;
	}
	public String getBookingDate() {
		return BookingDate;
	}
	public void setBookingDate(String bookingDate) {
		BookingDate = bookingDate;
	}
	public String getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getSelectAirport() {
		return selectAirport;
	}
	public void setSelectAirport(String selectAirport) {
		this.selectAirport = selectAirport;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
