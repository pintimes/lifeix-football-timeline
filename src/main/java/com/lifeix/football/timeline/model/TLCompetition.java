package com.lifeix.football.timeline.model;

import java.util.Date;

public class TLCompetition {

	private TLTeam hostTeam = null;
	private Integer guestScore = null;
	private Integer hostScore = null;
	private Double lal = null;
	private String name = null;
	private TLTeam guestTeam = null;
	private String id = null;
	private Date time = null;
	private String place = null;

	public TLTeam getHostTeam() {
		return hostTeam;
	}

	public void setHostTeam(TLTeam hostTeam) {
		this.hostTeam = hostTeam;
	}

	public Integer getGuestScore() {
		return guestScore;
	}

	public void setGuestScore(Integer guestScore) {
		this.guestScore = guestScore;
	}

	public Integer getHostScore() {
		return hostScore;
	}

	public void setHostScore(Integer hostScore) {
		this.hostScore = hostScore;
	}

	public Double getLal() {
		return lal;
	}

	public void setLal(Double lal) {
		this.lal = lal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TLTeam getGuestTeam() {
		return guestTeam;
	}

	public void setGuestTeam(TLTeam guestTeam) {
		this.guestTeam = guestTeam;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
