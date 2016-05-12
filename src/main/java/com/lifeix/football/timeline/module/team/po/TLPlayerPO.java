package com.lifeix.football.timeline.module.team.po;

import org.springframework.data.mongodb.core.mapping.Document;

import com.lifeix.football.timeline.module.team.po.bean.TLClubBean;

@Document(collection = "tlplayers")
public class TLPlayerPO {

	private String id = null;
	private String name = null;
	private String avatarUrl = null;
	private Integer number = null;
	private Integer score = null;
	private String country = null;
	private String showNum = null;
	private String birthplace = null;
	private String position = null;
	private String team = null;
	private Integer likeNum = null;
	private TLClubBean club = null;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getShowNum() {
		return showNum;
	}

	public void setShowNum(String showNum) {
		this.showNum = showNum;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Integer getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(Integer likeNum) {
		this.likeNum = likeNum;
	}

	public TLClubBean getClub() {
		return club;
	}

	public void setClub(TLClubBean club) {
		this.club = club;
	}
}
