package com.lifeix.football.timeline.module.player.service;

import java.util.List;

import com.lifeix.football.timeline.model.TLPlayer;

public interface PlayerService {

    public List<TLPlayer> getPlayers(TLPlayer player, int limit, String orderBy, boolean isAsc);

    public TLPlayer addPlayer(TLPlayer player);

}
