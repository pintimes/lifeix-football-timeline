package com.lifeix.football.timeline.model;

import java.util.ArrayList;
import java.util.List;

public class TLTeam {

    private String id;

    private String name;

    private String nickname;

    private String avatarUrl;

    /**
     * 教练和领队
     */
    private List<TLCoach> coach = new ArrayList<TLCoach>();

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public List<TLCoach> getCoach() {
        return coach;
    }

    public void setCoach(List<TLCoach> coach) {
        this.coach = coach;
    }

    public List<TLPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<TLPlayer> players) {
        this.players = players;
    }

}
