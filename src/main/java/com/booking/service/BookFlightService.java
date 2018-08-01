package com.booking.service;

import com.booking.model.BookFlightModel;
import com.booking.utils.Response;

public interface BookFlightService {

	Response bookTicket(BookFlightModel bookFlightModel) throws Exception;



	BookFlightModel getbookingReference(String ticketNo)throws Exception;

	Response updateBookTicket(String ticketNo, String status)throws Exception;



	Response bookTickets(BookFlightModel bookFlightModel)throws Exception;

	

}
