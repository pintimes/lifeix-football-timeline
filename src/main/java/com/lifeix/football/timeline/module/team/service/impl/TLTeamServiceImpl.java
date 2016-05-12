package com.lifeix.football.timeline.module.team.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lifeix.football.common.util.AdapterUtil;
import com.lifeix.football.timeline.model.TLTeam;
import com.lifeix.football.timeline.module.team.dao.TLTeamDao;
import com.lifeix.football.timeline.module.team.po.TLTeamPO;
import com.lifeix.football.timeline.module.team.service.TLTeamService;

public class TLTeamServiceImpl implements TLTeamService {

	@Autowired
	private TLTeamDao tlTeamDao;

	@Override
	public TLTeam get(String teamId) {
		TLTeamPO po = tlTeamDao.findById(teamId);
		return AdapterUtil.toT(po, TLTeam.class);
	}

	@Override
	public List<TLTeam> list() {
		List<TLTeamPO> pos = tlTeamDao.findAll();
		return AdapterUtil.toTs(pos, TLTeam.class);
	}

}
