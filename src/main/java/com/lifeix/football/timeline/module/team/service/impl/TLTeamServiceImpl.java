package com.lifeix.football.timeline.module.team.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifeix.football.common.util.AdapterUtil;
import com.lifeix.football.timeline.model.TLPlayer;
import com.lifeix.football.timeline.model.TLTeam;
import com.lifeix.football.timeline.module.team.dao.TLPlayerDao;
import com.lifeix.football.timeline.module.team.dao.TLTeamDao;
import com.lifeix.football.timeline.module.team.po.TLPlayerPO;
import com.lifeix.football.timeline.module.team.po.TLTeamPO;
import com.lifeix.football.timeline.module.team.service.TLTeamService;

@Service
public class TLTeamServiceImpl implements TLTeamService {

	@Autowired
	private TLTeamDao tlTeamDao;
	@Autowired
	private TLPlayerDao tlPlayerDao;

	@Override
	public TLTeam get(String teamId) {
		TLTeamPO po = tlTeamDao.findById(teamId);
		TLTeam team = AdapterUtil.toT(po, TLTeam.class);
		List<TLPlayerPO> playerpos = tlPlayerDao.findByTeam(teamId);
		List<TLPlayer> players = AdapterUtil.toTs(playerpos, TLPlayer.class);
		team.setPlayers(players);
		return team;
	}

	@Override
	public List<TLTeam> list() {
		List<TLTeamPO> pos = tlTeamDao.findAll();
		return AdapterUtil.toTs(pos, TLTeam.class);
	}

	@Override
	public void save(List<TLTeam> teams) {
		List<TLTeamPO> pos = AdapterUtil.toTs(teams, TLTeamPO.class);
		tlTeamDao.save(pos);
	}

}
