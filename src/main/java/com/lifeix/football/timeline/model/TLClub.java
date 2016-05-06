package com.lifeix.football.timeline.model;

/**
 * 俱乐部
 * 
 * @author gcc
 */
public class TLClub {

    private String id;

    /**
     * 俱乐部名称
     */
    private String name;

    /**
     * 俱乐部队徽
     */
    private String clubIconUrl;

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

    public String getClubIconUrl() {
        return clubIconUrl;
    }

    public void setClubIconUrl(String clubIconUrl) {
        this.clubIconUrl = clubIconUrl;
    }

}
