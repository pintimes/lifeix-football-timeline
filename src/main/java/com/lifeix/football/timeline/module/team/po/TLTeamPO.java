package com.lifeix.football.timeline.module.team.po;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tlteams")
public class TLTeamPO {

	private String avatarUrl = null;
	private String name = null;
	private String id = null;

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
}
