package com.lifeix.football.timeline.module.team.service;

import java.util.List;

import com.lifeix.football.timeline.model.TLTeam;

public interface TLTeamService {

	TLTeam get(String teamId);

	List<TLTeam> list();

	void save(List<TLTeam> teams);

}
