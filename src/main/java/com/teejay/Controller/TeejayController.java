package com.teejay.Controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teejay.Service.TeejayService;

@RestController
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RequestMapping("/teejay")
public class TeejayController {
	@Autowired
	TeejayService teejayService;


	/**
	 * Method to fetch the last traded price of the stock
	 * 
	 * @param String tickername
	 * 
	 * @return Double LTP
	 */
	@RequestMapping(value = "/getLTP/{tickerId}", produces = "application/json", method = RequestMethod.GET)
	public Double getLtp(@PathVariable String tickerId) throws IOException {
		return teejayService.getStockLTP(tickerId);
	}

}
