package com.lifeix.football.timeline.module.player.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.lifeix.football.timeline.model.TLClub;

@Document(collection = "tlplayers")
public class TLPlayerPo {
    private String id;

    /**
     * 归属队伍的id
     */
    private String teamId;

    private String name;

    private String avatarUrl;

    /**
     * 球衣号码
     */
    private Integer clotheNum;

    private Date birthday;

    private Float height;

    private Float weight;

    private String birthPlace;

    private String clubId;

    private TLClub club;

    /**
     * 场上位置
     */
    private List<String> position = new ArrayList<String>();

    /**
     * 球员介绍
     */
    private String introduction;

    /**
     * 进球数
     */
    private Integer goals;

    /**
     * 入选次数
     */
    private Integer selectedTimes;

    /**
     * 出场次数
     */
    private Integer gamePlayedTimes;

    /**
     * 首发次数
     */
    private Integer firstTimes;

    /**
     * 点赞数
     */
    private Integer likeNum;

    /**
     * 录入时间
     */
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
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

    public Integer getClotheNum() {
        return clotheNum;
    }

    public void setClotheNum(Integer clotheNum) {
        this.clotheNum = clotheNum;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public TLClub getClub() {
        return club;
    }

    public void setClub(TLClub club) {
        this.club = club;
    }

    public List<String> getPosition() {
        return position;
    }

    public void setPosition(List<String> position) {
        this.position = position;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getSelectedTimes() {
        return selectedTimes;
    }

    public void setSelectedTimes(Integer selectedTimes) {
        this.selectedTimes = selectedTimes;
    }

    public Integer getGamePlayedTimes() {
        return gamePlayedTimes;
    }

    public void setGamePlayedTimes(Integer gamePlayedTimes) {
        this.gamePlayedTimes = gamePlayedTimes;
    }

    public Integer getFirstTimes() {
        return firstTimes;
    }

    public void setFirstTimes(Integer firstTimes) {
        this.firstTimes = firstTimes;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
