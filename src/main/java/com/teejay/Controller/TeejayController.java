package com.teejay.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teejay.Exceptions.IncorrectPasswordException;
import com.teejay.Exceptions.UserNotFoundException;
import com.teejay.Model.TradeEntries;
import com.teejay.Model.User;
import com.teejay.Service.TeejayService;

@RestController
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RequestMapping("/teejay/tj")
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
	
	/*
	 * Method to fetch the trade entries from the database
	 * 
	 * @param String loginId
	 * 
	 * @return List<tradeEntries>
	 */
	@RequestMapping(value = "/fetch/{loginId}", produces = "application/json", method = RequestMethod.GET)
	public List<TradeEntries> fetchTradeEntries(@PathVariable String loginId) throws Exception {

		try {
			List<TradeEntries> result = teejayService.fetchTradeEntries(loginId);
			System.out.println();
			return result;
		} catch (Exception e) {
			throw e;
		}

	}

}
