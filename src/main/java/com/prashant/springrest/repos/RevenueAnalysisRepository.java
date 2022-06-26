/*
 *  @Author Prashant Kumar
 *  prashant.kumar0507@outlook.com
 */
package com.prashant.springrest.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prashant.springrest.entities.Revenue_Analysis;



/*
 * JPA Repository extension including the query methods to fetch data from data source
 */

public interface RevenueAnalysisRepository extends JpaRepository<Revenue_Analysis, Integer> {
	
	
	/*
	 *  Query method to find record by member_id
	 *  @Returns List of type RevenueAnalysis, representing all the records for a member
	 */
	@Query(value = "Select * from revenue_analysis where member_id=?1" , nativeQuery = true) 
	List<Revenue_Analysis> getMember(int member_id);
	
	/*
	 *   WAGER AMOUNT HELPER METHODS
	 *   @Param : member_id (int)
	 *   @Param : imonth (int)  - represent month ; example - 201709
	 *   @Param : igame (int)  - represent game id ; example - 1050
	 *   
	 *   @Return SUM (float) - sum of all the wager amount by a member 
	 */
	
	/* SUM of wager amount of member */
	@Query(value = "Select SUM(wager_amount) from revenue_analysis where member_id=?1" , nativeQuery = true)
	float getWagerAmountForMember(int member_id);
	
	/* SUM of wager amount of member BY MONTH and GAMEID */
	@Query(value = "Select SUM(wager_amount) from revenue_analysis where member_id=?1 and activity_year_month=?2 and game_id=?3", nativeQuery = true)
	float getWagerByMonthandGame(int mid, int imonth, int igame);
	
	/* SUM of wager amount of member BY MONTH only*/
	@Query(value = "Select SUM(wager_amount) from revenue_analysis where member_id=?1 and activity_year_month=?2", nativeQuery = true)
	float getWagerByMonth(int mid, int imonth);

	/* SUM of wager amount of member BY GAMEID only */
	@Query(value = "Select SUM(wager_amount) from revenue_analysis where member_id=?1 and game_id=?2", nativeQuery = true)
	float getWagerByGameId(int mid, int game_id);
	
	
	/*
	 *   TOTAL WIN AMOUNT HELPER METHODS
	 *   @Param : member_id (int)
	 *   @Param : imonth (int)  - represent month ; example - 201709
	 *   @Param : igame (int)  - represent game id ; example - 1050
	 *   
	 *   @Return SUM (float) - sum of all the win amounts registered by a member 
	 */
	
	/* TOTAL WIN AMOUNT of member */
	@Query(value = "Select SUM(win_amount) from revenue_analysis where member_id=?1" , nativeQuery = true)
	float getWinAmountForMember(int mid);
	
	/* TOTAL WIN AMOUNT of member BY MONTH and GAMEID  */
	@Query(value = "Select SUM(win_amount) from revenue_analysis where member_id=?1 and activity_year_month=?2 and game_id=?3", nativeQuery = true)
	float getWinAmountByMonthandGame(int mid, int imonth, int igame);
	
	/* TOTAL WIN AMOUNT of member  BY MONTH only */
	@Query(value = "Select SUM(win_amount) from revenue_analysis where member_id=?1 and activity_year_month=?2", nativeQuery = true)
	float getWinAmountByMonth(int mid, int imonth);
	
	/* TOTAL WIN AMOUNT of member  BY GAMEID only */
	@Query(value = "Select SUM(win_amount) from revenue_analysis where member_id=?1 and game_id=?2", nativeQuery = true)
	float getWinAmountByGameId(int mid, int igame);


	/*
	 *   TOTAL NUMBER OF WAGERS HELPER METHODS
	 *   @Param : member_id (int)
	 *   @Param : imonth (int)  - represent month ; example - 201709
	 *   @Param : igame (int)  - represent game id ; example - 1050
	 *   
	 *   @Return SUM (float) - sum of all the WAGERS registered by a member 
	 */
	
	/* TOTAL NO. OF WAGERS placed by member */
	@Query(value = "Select SUM(number_of_wagers) from revenue_analysis where member_id=?1" , nativeQuery = true)
	int getWagerCountForMember(int mid);
	
	/* TOTAL NO. OF WAGERS placed by member BY MONTH and GAMEID*/
	@Query(value = "Select SUM(number_of_wagers) from revenue_analysis where member_id=?1 and activity_year_month=?2 and game_id=?3", nativeQuery = true)
	int getWagerCountByMonthandGame(int mid, int imonth, int igame);

	/* TOTAL NO. OF WAGERS placed by member BY MONTH only */
	@Query(value = "Select SUM(number_of_wagers) from revenue_analysis where member_id=?1 and activity_year_month=?2", nativeQuery = true)
	int getWagerCountByMonth(int mid, int imonth);

	/* TOTAL NO. OF WAGERS placed by member BY GAMEID only */
	@Query(value = "Select SUM(number_of_wagers) from revenue_analysis where member_id=?1 and game_id=?2", nativeQuery = true)
	int getWagerCountByGameId(int mid, int igame);

}
