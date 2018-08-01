package com.booking.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.model.BookFlightModel;
import com.booking.service.BookFlightService;
import com.booking.utils.CommonUtils;
import com.booking.utils.Response;
import com.booking.utils.StatusCode;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@RestController
@RequestMapping("/v1")
public class BookFlightController {
	
	@Autowired
	BookFlightService bookFlightService;
	
	Logger logger=LoggerFactory.getLogger(BookFlightController.class);
	
	@PostMapping(path="bookticket")
	public Response bookTicket(@RequestBody BookFlightModel bookFlightModel,HttpServletRequest req,HttpServletResponse res) throws Exception{
		logger.info("BookTicket: Received request URL: " + req.getRequestURL().toString()
				+ ((req.getQueryString() == null) ? "" : "?" + req.getQueryString().toString()));
		return bookFlightService.bookTicket(bookFlightModel);
		
	}
	
	@PostMapping(path="booktickets")
	public Response bookTickets(@RequestBody BookFlightModel bookFlightModel,HttpServletRequest req,HttpServletResponse res) throws Exception{
		logger.info("BookTicket: Received request URL: " + req.getRequestURL().toString()
				+ ((req.getQueryString() == null) ? "" : "?" + req.getQueryString().toString()));
		return bookFlightService.bookTickets(bookFlightModel);
		
	}
	
	@GetMapping(path="getReference/{ticketNo}")
	public @ResponseBody String getbookingReference(@PathVariable String ticketNo) throws Exception{
		BookFlightModel bookFlightModel=bookFlightService.getbookingReference(ticketNo);
		Response response=CommonUtils.getResponseObject("getting ticketNo");
		if(bookFlightModel==null){
			response.setStatus(StatusCode.FAILURE.name());
		}else{
		response.setData(bookFlightModel);
		}
		return (String) CommonUtils.getJson(response);
	}
	
	
	@PutMapping(path="updateBooking/{ticketNo}/{status}")
	public Response updateBookTicket(@PathVariable String ticketNo,@PathVariable String status)throws Exception{
		return bookFlightService.updateBookTicket(ticketNo,status);
		
	} 
	
	

}
