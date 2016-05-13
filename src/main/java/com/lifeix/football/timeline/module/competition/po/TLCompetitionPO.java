package com.lifeix.football.timeline.module.competition.po;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lifeix.football.timeline.module.competition.po.bean.TLTeamBean;

@Document(collection = "tlcompetitions")
public class TLCompetitionPO {

	@Id
	private String id = null;
	private String name = null;
	@Indexed
	private Date time = null;
	private Double lal = null;
	private String place = null;
	private TLTeamBean hostTeam = null;
	private TLTeamBean guestTeam = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Double getLal() {
		return lal;
	}

	public void setLal(Double lal) {
		this.lal = lal;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public TLTeamBean getHostTeam() {
		return hostTeam;
	}

	public void setHostTeam(TLTeamBean hostTeam) {
		this.hostTeam = hostTeam;
	}

	public TLTeamBean getGuestTeam() {
		return guestTeam;
	}

	public void setGuestTeam(TLTeamBean guestTeam) {
		this.guestTeam = guestTeam;
	}

}
