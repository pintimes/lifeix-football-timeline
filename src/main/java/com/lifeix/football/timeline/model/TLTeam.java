package com.lifeix.football.timeline.model;

import java.util.ArrayList;
import java.util.List;

public class TLTeam {

    private String id;

    private String name;

    private String avatarUrl;

    private String coach;

    /**
     * 球员列表
     */
    private List<TLPlayer> players = new ArrayList<TLPlayer>();

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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public List<TLPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<TLPlayer> players) {
        this.players = players;
    }

}
