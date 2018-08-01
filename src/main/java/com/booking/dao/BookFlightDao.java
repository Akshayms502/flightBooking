package com.booking.dao;

import com.booking.domain.BookFlightDomain;
import com.booking.domain.ReturnBookFlight;
import com.booking.utils.Response;



public interface BookFlightDao {

	Response bookTicket(BookFlightDomain bookFlightDomain) throws Exception;

	BookFlightDomain getbookingReference(String ticketNo)throws Exception;

	Response updateBookTicket(String ticketNo, String status)throws Exception;

	Response bookTickets(BookFlightDomain bookFlightDomain, ReturnBookFlight returnBookFlight)throws Exception;

//	Response updateBookTicket(BookFlightDomain bookFlightDomain)throws Exception;

	

}
