package com.lifeix.football.timeline.module.competition.service;

import java.util.List;

import com.lifeix.football.timeline.model.TLCompetition;

public interface TLCompetitionService {

	List<TLCompetition> list();

	void changeScore(String id,int hostScore, int guestScore);

	void save(List<TLCompetition> competitions);

}
