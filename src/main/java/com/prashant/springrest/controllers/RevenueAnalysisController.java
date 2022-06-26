/*
 *  @Author Prashant Kumar
 *  prashant.kumar0507@outlook.com
 */
package com.prashant.springrest.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.springrest.entities.Revenue_Analysis;
import com.prashant.springrest.repos.RevenueAnalysisRepository;


/*
 *  CONTROLLER class to accept client request,
 *  redirect to appropriate API method 
 *  and return the data for API calls
 */

@RestController
public class RevenueAnalysisController {

	
	private static final Logger logger = LogManager.getLogger(RevenueAnalysisController.class);

	@Autowired
	RevenueAnalysisRepository revenue_analysis_repository;


	/* 
	 * API Method to return all the revenue analysis data
	 * EXAMPLE - http://localhost:8080/revenue
	 */
	
	@RequestMapping(value = "/revenue" , method = RequestMethod.GET)
	public List<Revenue_Analysis> getAllRevenueData(){
		return revenue_analysis_repository.findAll();
	}



	/*
	 * API Method to return all the revenue analysis data by MEMBER_ID
	 * EXAMPLE - http://localhost:8080/revenue/member/1001
	 */
	@RequestMapping(value = "/revenue/member/{mid}" , method = RequestMethod.GET)
	public List<Revenue_Analysis> getRevenueByMemberID(@PathVariable("mid") int mid) {

		return revenue_analysis_repository.getMember(mid);

	}


	/*
	 *  REST API Method to return TOTAL WAGER AMOUNT by MEMBER_ID
	 *  Optional Parameters - Month & Game ID
	 *  EXAMPLE - 				http://localhost:8080/revenue/wager/1001  
	 *  BY MONTH & GAME ID - 	http://localhost:8080/revenue/wager/1001?month=201709&game_id=1050
	 *  BY MONTH  - 			http://localhost:8080/revenue/wager/1001?month=201709
	 *  BY GAME ID - 			http://localhost:8080/revenue/wager/1001?game_id=1050
	 */
	
	@RequestMapping(value = "/revenue/wager/{mid}" , method = RequestMethod.GET)
	public ResponseEntity<Float> getTotalWagerByMemberID(@PathVariable("mid") int mid , @RequestParam(name = "month", required = false) String month, @RequestParam(name="game_id", required = false) String game_id ) {

		logger.info("Getting TOTAL WAGER AMOUNT for "+mid);
		int imonth=0;
		int igame =0;


		if (month !=null && game_id!=null) {

			logger.info(" TWagA Optional Parameter Found - MONTH & GAMEID");
			try {
				imonth=Integer.parseInt(month);
				igame=Integer.parseInt(game_id);

				return ResponseEntity.ok(revenue_analysis_repository.getWagerByMonthandGame(mid,imonth,igame));
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return ResponseEntity.badRequest().body((float)0.0);
			}
		}

		if(month!=null) {
			logger.info("TWagA Optional Parameter Found - MONTH ONLY");
			try {
				imonth=Integer.parseInt(month);
				return ResponseEntity.ok(revenue_analysis_repository.getWagerByMonth(mid, imonth));
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return ResponseEntity.badRequest().body((float)0.0);
			}
		}

		if(game_id !=null) {
			logger.info("TWagA Optional Parameter Found - GAMEID ONLY");
			try {
				igame=Integer.parseInt(game_id);
				return ResponseEntity.ok(revenue_analysis_repository.getWagerByGameId(mid,igame));
			}catch (Exception e) {
				System.out.println(e.getMessage());
				ResponseEntity.badRequest().body((float)0.0);
			}
		}

		return ResponseEntity.ok(revenue_analysis_repository.getWagerAmountForMember(mid));

	}


	
	/*
	 *  API Method to return TOTAL WIN AMOUNT by MEMBER_ID
	 *  Optional Parameters - Month & Game ID
	 *  EXAMPLE - 				http://localhost:8080/revenue/winamt/1001  
	 *  BY MONTH & GAME ID - 	http://localhost:8080/revenue/winamt/1001?month=201709&game_id=1050
	 *  BY MONTH  - 			http://localhost:8080/revenue/winamt/1001?month=201709
	 *  BY GAME ID - 			http://localhost:8080/revenue/winamt/1001?game_id=1050
	 */
	@RequestMapping(value = "/revenue/winamt/{mid}" , method = RequestMethod.GET)
	public ResponseEntity<Float> getTotalWinAmountByMemberID(@PathVariable("mid") int mid , @RequestParam(name = "month", required = false) String month, @RequestParam(name="game_id", required = false) String game_id ) {

		logger.info("Getting TOTAL WIN AMOUNT for "+mid);
		int imonth=0;
		int igame =0;

		if (month !=null && game_id!=null) {

			logger.info("TWinA - Optional Parameter Found - MONTH & GAMEID");
			try {
				imonth=Integer.parseInt(month);
				igame=Integer.parseInt(game_id);
				return ResponseEntity.ok(revenue_analysis_repository.getWinAmountByMonthandGame(mid,imonth,igame));
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return ResponseEntity.badRequest().body((float)0.0);
			}
		}

		if(month!=null) {
			logger.info("TWinA Optional Parameter Found - MONTH ONLY");
			try {
				imonth=Integer.parseInt(month);
				return ResponseEntity.ok(revenue_analysis_repository.getWinAmountByMonth(mid, imonth));
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return ResponseEntity.badRequest().body((float)0.0);
			}
		}

		if(game_id !=null) {
			logger.info("TWinA Optional Parameter Found - GAMEID ONLY");
			try {
				igame=Integer.parseInt(game_id);
				return ResponseEntity.ok(revenue_analysis_repository.getWinAmountByGameId(mid,igame));
			}catch (Exception e) {
				System.out.println(e.getMessage());
				ResponseEntity.badRequest().body((float)0.0);
			}
		}

		return ResponseEntity.ok(revenue_analysis_repository.getWinAmountForMember(mid));
	}


	/*
	 *  API Method to return TOTAL WIN AMOUNT by MEMBER_ID
	 *  Optional Parameters - Month & Game ID
	 *  EXAMPLE - 				http://localhost:8080/revenue/wagercount/1001  
	 *  BY MONTH & GAME ID - 	http://localhost:8080/revenue/wagercount/1001?month=201709&game_id=1050
	 *  BY MONTH  - 			http://localhost:8080/revenue/wagercount/1001?month=201709
	 *  BY GAME ID - 			http://localhost:8080/revenue/wagercount/1001?game_id=1050
	 */
	@RequestMapping(value = "/revenue/wagercount/{mid}" , method = RequestMethod.GET)
	public ResponseEntity<Integer> getWagerCountByMemberID(@PathVariable("mid") int mid , @RequestParam(name = "month", required = false) String month, @RequestParam(name="game_id", required = false) String game_id ) {

		logger.info("Getting TOTAL WAGER COUNT for "+mid);
		int imonth=0;
		int igame =0;

		if (month !=null && game_id!=null) {

			logger.info("TWC - Optional Parameter Found - MONTH & GAMEID");
			try {
				imonth=Integer.parseInt(month);
				igame=Integer.parseInt(game_id);
				return ResponseEntity.ok(revenue_analysis_repository.getWagerCountByMonthandGame(mid,imonth,igame));
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return ResponseEntity.badRequest().body(0);
			}
		}

		if(month!=null) {
			logger.info("TWC Optional Parameter Found - MONTH ONLY");
			try {
				imonth=Integer.parseInt(month);
				return ResponseEntity.ok(revenue_analysis_repository.getWagerCountByMonth(mid, imonth));
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return ResponseEntity.badRequest().body(0);
			}
		}

		if(game_id !=null) {
			logger.info("TWC Optional Parameter Found - GAMEID ONLY");
			try {
				igame=Integer.parseInt(game_id);
				return ResponseEntity.ok(revenue_analysis_repository.getWagerCountByGameId(mid,igame));
			}catch (Exception e) {
				System.out.println(e.getMessage());
				ResponseEntity.badRequest().body(0);
			}
		}

		return ResponseEntity.ok(revenue_analysis_repository.getWagerCountForMember(mid));
	}



	@RequestMapping(value = "/revenue/{id}" , method = RequestMethod.GET)
	public Revenue_Analysis getRevenueByID(@PathVariable("id") int id) {
		return revenue_analysis_repository.findById(id).get();
	}

	@RequestMapping(value = "/revenue/" , method = RequestMethod.POST)
	public Revenue_Analysis createRevenue(@RequestBody Revenue_Analysis p) {
		return revenue_analysis_repository.save(p);
	}

	@RequestMapping(value = "/revenue/" , method = RequestMethod.PUT)
	public Revenue_Analysis updateRevenue(@RequestBody Revenue_Analysis p) {
		return revenue_analysis_repository.save(p);
	}

	@RequestMapping(value = "/revenue/{id}" , method = RequestMethod.DELETE)
	public void deleteRevenue(@PathVariable("id") int id) {
		revenue_analysis_repository.deleteById(id);
	}


}
