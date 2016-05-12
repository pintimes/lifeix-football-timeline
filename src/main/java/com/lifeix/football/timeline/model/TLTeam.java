package com.lifeix.football.timeline.model;

import java.util.ArrayList;
import java.util.List;

public class TLTeam {
	
	private String id = null;
	private String name = null;
	private String avatarUrl = null;
	private List<TLPlayer> players = new ArrayList<TLPlayer>();

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public List<TLPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(List<TLPlayer> players) {
		this.players = players;
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
