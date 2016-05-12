package com.lifeix.football.timeline.module.team.service;

import java.util.List;

import com.lifeix.football.timeline.model.TLPlayer;

public interface TLPlayerService {

	TLPlayer get(String playerId);

	List<TLPlayer> list(String teamId);

}
