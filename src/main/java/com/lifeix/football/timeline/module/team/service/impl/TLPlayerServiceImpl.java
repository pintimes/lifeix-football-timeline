package com.lifeix.football.timeline.module.team.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lifeix.football.common.util.AdapterUtil;
import com.lifeix.football.timeline.model.TLPlayer;
import com.lifeix.football.timeline.module.team.dao.TLPlayerDao;
import com.lifeix.football.timeline.module.team.po.TLPlayerPO;
import com.lifeix.football.timeline.module.team.service.TLPlayerService;

public class TLPlayerServiceImpl implements TLPlayerService{

	@Autowired
	private TLPlayerDao tlPlayerDao;
	
	@Override
	public TLPlayer get(String playerId) {
		TLPlayerPO po =  tlPlayerDao.findById(playerId);
		return AdapterUtil.toT(po, TLPlayer.class);
	}

	@Override
	public List<TLPlayer> list(String teamId) {
		List<TLPlayerPO> pos =  tlPlayerDao.findByTeam(teamId);
		return AdapterUtil.toTs(pos, TLPlayer.class);
	}

}
