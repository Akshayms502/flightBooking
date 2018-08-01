package com.booking.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.booking.domain.BookFlightDomain;
import com.booking.domain.ReturnBookFlight;
import com.booking.service.BookFlightServiceImpl;
import com.booking.utils.CommonUtils;
import com.booking.utils.ErrorObject;
import com.booking.utils.Response;
import com.booking.utils.StatusCode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BookFlightDaoImpl implements BookFlightDao {

	@Autowired
	MongoTemplate mongoTemplate;
	
	
	
	Logger logger=LoggerFactory.getLogger(BookFlightDaoImpl.class);
	ErrorObject error;

	@Override
	public Response bookTicket(BookFlightDomain bookFlightDomain) throws Exception {
		Response response=CommonUtils.getResponseObject("Booking customer ticket:\t customer reference:"+bookFlightDomain.getBookingReference()+"\t"+"Ticket no:"+bookFlightDomain.getTicketNo());
		try {
			mongoTemplate.save(bookFlightDomain, "tickets");
			response.setStatus(StatusCode.SUCCESS.name());
			response.setData(bookFlightDomain);
			return response;
		} catch (Exception e) {
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			return response;
		}
	}
	
	@Override
	public BookFlightDomain getbookingReference(String ticketNo)throws Exception{
		return mongoTemplate.findById(ticketNo, BookFlightDomain.class);
	
	}

	@Override
	public Response updateBookTicket(String ticketNo, String status) throws Exception {
		Response response=CommonUtils.getResponseObject("updating customer ticket");
		try{
		BookFlightDomain bookFlightDomain=getbookingReference(ticketNo);
		bookFlightDomain.setStatus(status);
		mongoTemplate.save(bookFlightDomain);
		response.setStatus(StatusCode.SUCCESS.name());
		response.setData(bookFlightDomain);
		return response;
		
		}
		catch (Exception e) {
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			return response;
		}
	}

	@Override
	public Response bookTickets(BookFlightDomain bookFlightDomain, ReturnBookFlight returnBookFlight) throws Exception {
		Response response=CommonUtils.getResponseObject("single Booking customer ticket:\t customer reference:"+bookFlightDomain.getBookingReference()+"\t"+"Ticket no:"+bookFlightDomain.getTicketNo());
		Response response1=CommonUtils.getResponseObject("single Booking customer ticket:\t customer reference:"+bookFlightDomain.getBookingReference()+"\t"+"Ticket no:"+bookFlightDomain.getTicketNo());
		try {
			mongoTemplate.save(bookFlightDomain, "tickets");
			mongoTemplate.save(returnBookFlight, "returnticket");
			response.setStatus(StatusCode.SUCCESS.name());
			response.setData(bookFlightDomain);
			response1.setStatus(StatusCode.SUCCESS.name());
			response1.setData(returnBookFlight);
			return response1 ;
			
		} catch (Exception e) {
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			return response;
		}
	}


}

	
