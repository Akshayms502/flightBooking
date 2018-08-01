package com.booking.service;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.booking.dao.BookFlightDao;
import com.booking.domain.BookFlightDomain;
import com.booking.domain.ReturnBookFlight;
import com.booking.domain.UpdateBooking;
import com.booking.model.BookFlightModel;
import com.booking.utils.CommonUtils;
import com.booking.utils.Response;
import com.booking.utils.StatusCode;

@Service
public class BookFlightServiceImpl implements BookFlightService{

	@Autowired
	BookFlightDao bookFlightDao;
	
	
	Logger logger=LoggerFactory.getLogger(BookFlightServiceImpl.class);
	
	Response response;
	
	@Override
	public Response bookTicket(BookFlightModel bookFlightModel) throws Exception {
		try{
			
			BookFlightDomain bookFlightDomain = new BookFlightDomain();
			BeanUtils.copyProperties(bookFlightModel, bookFlightDomain);
			bookFlightDomain.setTicketNo(UUID.randomUUID().toString());
			bookFlightDomain.setBookingReference(UUID.randomUUID().toString());
			bookFlightDomain.setBookingDate(new Date().toString());
			bookFlightDomain.setBookingTime(CommonUtils.getTime());
			bookFlightDomain.setStatus(StatusCode.CONFIRMED.name());
			bookFlightDomain.setNoOfPerson(bookFlightModel.getFullname().size());
			bookFlightDomain.setAmount(getDiscount(bookFlightDomain.getNoOfPerson(),bookFlightModel.getAmount()));
			response=bookFlightDao.bookTicket(bookFlightDomain);
			return response;
			
		}
		catch(Exception e){
			logger.info("exception in booking ticket"+e.getMessage());
			
		}return null;
		
	}
	
	
	public static int getDiscount(int noOfPerson, int amount) {
		if(noOfPerson>=6){
			int val=(amount-((amount*25)/100));
			return val;
		}else{
			return amount;
		}
		 
	}


	


	@Override
	public BookFlightModel getbookingReference(String ticketNo) throws Exception {
		try{
			BookFlightDomain bookFlightDomain=bookFlightDao.getbookingReference(ticketNo);
			BookFlightModel bookFlightModel=new BookFlightModel();
			BeanUtils.copyProperties(bookFlightDomain, bookFlightModel);
			return bookFlightModel;
			
		}catch(Exception e){
			
		}
		return null;
	}


	@Override
	public Response updateBookTicket(String ticketNo, String status) throws Exception {
		
		return bookFlightDao.updateBookTicket(ticketNo,status);
	}


	@Override
	public Response bookTickets(BookFlightModel bookFlightModel) throws Exception {
		try{
			
			BookFlightDomain bookFlightDomain = new BookFlightDomain();
			ReturnBookFlight returnBookFlight=new ReturnBookFlight();
			BeanUtils.copyProperties(bookFlightModel, bookFlightDomain);
			BeanUtils.copyProperties(bookFlightModel, returnBookFlight);
			bookFlightDomain.setTicketNo(UUID.randomUUID().toString());
			returnBookFlight.setTicketNo(bookFlightDomain.getTicketNo());
			bookFlightDomain.setBookingReference(UUID.randomUUID().toString());
			returnBookFlight.setRbookingReference(bookFlightDomain.getBookingReference());
			bookFlightDomain.setBookingDate(new Date().toString());
		
			bookFlightDomain.setBookingTime(CommonUtils.getTime());
			bookFlightDomain.setStatus(StatusCode.CONFIRMED.name());
		
			bookFlightDomain.setNoOfPerson(bookFlightModel.getFullname().size());
			returnBookFlight.setRnoOfPerson(bookFlightModel.getRfullname().size());
			bookFlightDomain.setAmount(getDiscount(bookFlightDomain.getNoOfPerson(),bookFlightModel.getAmount()));
			returnBookFlight.setRamount(getDiscount(returnBookFlight.getRnoOfPerson(),bookFlightModel.getRamount()));
			response=bookFlightDao.bookTickets(bookFlightDomain,returnBookFlight);
			return response;
			
		}
		catch(Exception e){
			logger.info("exception in booking ticket"+e.getMessage());
			
		}return null;

	
	}
	
}
