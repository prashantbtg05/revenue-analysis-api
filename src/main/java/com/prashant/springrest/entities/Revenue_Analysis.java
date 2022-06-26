package com.prashant.springrest.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Revenue_Analysis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	int member_id;
	Date activity_date;
	int game_id;
	float wager_amount;
	int number_of_wagers;
	float win_amount;
	int activity_year_month;
	int bank_type_id;
	
	public Date getActivity_date() {
		return activity_date;
	}
	public void setActivity_date(Date activity_date) {
		this.activity_date = activity_date;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getGame_id() {
		return game_id;
	}
	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}
	public float getWager_amount() {
		return wager_amount;
	}
	public void setWager_amount(float wager_amount) {
		this.wager_amount = wager_amount;
	}
	public int getNumber_of_wagers() {
		return number_of_wagers;
	}
	public void setNumber_of_wagers(int number_of_wagers) {
		this.number_of_wagers = number_of_wagers;
	}
	public float getWin_amount() {
		return win_amount;
	}
	public void setWin_amount(float win_amount) {
		this.win_amount = win_amount;
	}
	public int getActivity_year_month() {
		return activity_year_month;
	}
	public void setActivity_year_month(int activity_year_month) {
		this.activity_year_month = activity_year_month;
	}
	public int getBank_type_id() {
		return bank_type_id;
	}
	public void setBank_type_id(int bank_type_id) {
		this.bank_type_id = bank_type_id;
	}

	
	
}
