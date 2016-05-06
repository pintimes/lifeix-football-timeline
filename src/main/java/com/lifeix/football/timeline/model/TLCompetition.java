package com.lifeix.football.timeline.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TLCompetition {

    private String id;

    /**
     * 主队
     */
    private TLTeam host;

    /**
     * 客队
     */
    private TLTeam away;

    private Date time;

    /**
     * 主裁
     */
    private String referee;

    /**
     * 边裁
     */
    private List<String> linesman = new ArrayList<String>();

    /**
     * 第四官员
     */
    private String fourthOfficials;

    /**
     * 比赛地点
     */
    private String location;

    /**
     * 经度
     */
    private double Longitude;

    /**
     * 纬度
     */
    private double latitude;

    private TLCourt court;

    /**
     * 战术对阵图
     */
    private String tacticUrl;

    private int hostScore;

    private int awayScore;

    /**
     * 状态
     */
    private State state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TLTeam getHost() {
        return host;
    }

    public void setHost(TLTeam host) {
        this.host = host;
    }

    public TLTeam getAway() {
        return away;
    }

    public void setAway(TLTeam away) {
        this.away = away;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public List<String> getLinesman() {
        return linesman;
    }

    public void setLinesman(List<String> linesman) {
        this.linesman = linesman;
    }

    public String getFourthOfficials() {
        return fourthOfficials;
    }

    public void setFourthOfficials(String fourthOfficials) {
        this.fourthOfficials = fourthOfficials;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getTacticUrl() {
        return tacticUrl;
    }

    public void setTacticUrl(String tacticUrl) {
        this.tacticUrl = tacticUrl;
    }

    public TLCourt getCourt() {
        return court;
    }

    public void setCourt(TLCourt court) {
        this.court = court;
    }

    public int getHostScore() {
        return hostScore;
    }

    public void setHostScore(int hostScore) {
        this.hostScore = hostScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
