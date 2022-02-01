package com.teejay.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teejay.Exceptions.ExitEntryAlreadyExistsException;
import com.teejay.Exceptions.IncorrectPasswordException;
import com.teejay.Exceptions.NoHistoryFoundException;
import com.teejay.Exceptions.UserNotFoundException;
import com.teejay.Model.TradeEntries;
import com.teejay.Model.TradeExits;
import com.teejay.Model.TradeHistories;
import com.teejay.Model.User;
import com.teejay.Service.TeejayService;
import com.teejay.VO.LtpData;

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
	@RequestMapping(value = "/getLTP", produces = "application/json", method = RequestMethod.POST)
	public List<LtpData> getLtp(@RequestBody List<String> tickerId) throws IOException {
		return teejayService.getLTP(tickerId);
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

	/*
	 * Method to add the trade entries to the database
	 * 
	 * @param TradeEntries tradeEntries
	 * 
	 * @return int tradeId
	 */
	@RequestMapping(value = "/addEntry", produces = "application/json", method = RequestMethod.POST)
	public int addTradeEntry(@RequestBody TradeEntries tradeEntries) throws Exception {

		try {
			return teejayService.addTradeEntry(tradeEntries);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/*
	 * Method to add the trade exits to the database
	 * 
	 * @param TradeExits tradeExits
	 * 
	 * @return int exit Id
	 */
	@RequestMapping(value = "/addExit", produces = "application/json", method = RequestMethod.POST)
	public int addTradeExit(@RequestBody TradeExits tradeExits) throws ExitEntryAlreadyExistsException {

		try {
			return teejayService.addTradeExit(tradeExits);
		} catch (ExitEntryAlreadyExistsException e) {
			throw e;
		}
	}
	
	/*
	 * Method to view all the trade history
	 * 
	 * @param String loginId
	 * 
	 * @return List<TradeHistories>
	 */
	@RequestMapping(value = "/fetchHistory/{loginId}", produces = "application/json", method = RequestMethod.GET)
	public List<TradeHistories> fetchTradeHistories(@PathVariable String loginId ) throws NoHistoryFoundException {

		try {
			return teejayService.fetchTradeHistories(loginId);
		} catch (NoHistoryFoundException e) {
			throw e;
		}
	}

}
