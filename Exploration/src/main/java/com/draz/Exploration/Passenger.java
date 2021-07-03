package com.draz.Exploration;

public class Passenger {
	private String pclass;
	private String survived;
	private String name;
	private String sex;
	private Double age;
	private String sibsp;
	private String parch;
	private String ticket;
	private Double fare;
	private String cabin;
	private String embarked;
	private String boat;
	private String body;
	private String home_dest;	

	public Passenger(String pclass, String survived, String name, String sex, Double age, String sibsp,
				String parch,String ticket, Double fare, String cabin, String embarked,
				String boat, String body, String home_dest) {
		this.pclass = pclass;
		this.survived = survived;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.sibsp = sibsp;
		this.parch = parch;
		this.ticket = ticket;
		this.fare = fare;
		this.cabin  = cabin;
		this.embarked = embarked;
 		this.boat = boat;
		this.body = body;
		this.home_dest = home_dest;
	}
	public String getPclass() {
		return this.pclass;
	}
	public String getSurvived() {
		return this.survived;
	}
	public String getName() {
		return this.name;
	}
	public String getSex() {
		return this.sex;
	}
	public Double getAge() {
		return this.age;
	}
	public String getSibsp() {
		return this.sibsp;
	}
	public String getParch() {
		return this.parch;
	}
	public String getTicket() {
		return this.ticket;
	}
	public Double getFare() {
		return this.fare;
	}
	public String getCabin() {
		return this.cabin;
	}
	public String getEmbarked() {
		return this.embarked;
	}
	public String getBoat() {
		return this.boat;
	}
	public String getBody() {
		return this.body;
	}
	public String getHome_dest() {
		return this.home_dest;
	}
}
