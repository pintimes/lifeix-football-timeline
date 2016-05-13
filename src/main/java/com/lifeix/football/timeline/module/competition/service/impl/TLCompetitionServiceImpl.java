package com.lifeix.football.timeline.module.competition.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifeix.football.common.util.AdapterUtil;
import com.lifeix.football.timeline.model.TLCompetition;
import com.lifeix.football.timeline.model.TLTeam;
import com.lifeix.football.timeline.module.competition.dao.TLCompetitionDao;
import com.lifeix.football.timeline.module.competition.po.TLCompetitionPO;
import com.lifeix.football.timeline.module.competition.po.bean.TLTeamBean;
import com.lifeix.football.timeline.module.competition.service.TLCompetitionService;

@Service
public class TLCompetitionServiceImpl implements TLCompetitionService {

	@Autowired
	private TLCompetitionDao tlCompetitionDao;

	@Override
	public List<TLCompetition> list() {
		List<TLCompetitionPO> pos = tlCompetitionDao.findAll();
		
		List<TLCompetition> result =  new ArrayList<>();
		for (TLCompetitionPO tlCompetitionPO : pos) {
			TLCompetition t = AdapterUtil.toT(tlCompetitionPO, TLCompetition.class);
			TLTeam host = AdapterUtil.toT(tlCompetitionPO.getHostTeam(), TLTeam.class);
			TLTeam guest = AdapterUtil.toT(tlCompetitionPO.getGuestTeam(), TLTeam.class);
			t.setHostTeam(host);
			t.setGuestTeam(guest);
			result.add(t);
		}
		return result;
	}

	@Override
	public void changeScore(String id, int hostScore, int guestScore) {
		tlCompetitionDao.changeScore(id, hostScore, guestScore);
	}

	@Override
	public void insert(List<TLCompetition> competitions) {
		List<TLCompetitionPO> pos = new ArrayList<>();
		for (TLCompetition tlCompetition : competitions) {
			TLCompetitionPO e = AdapterUtil.toT(tlCompetition, TLCompetitionPO.class);
			TLTeamBean host = AdapterUtil.toT(tlCompetition.getHostTeam(), TLTeamBean.class);
			TLTeamBean guest = AdapterUtil.toT(tlCompetition.getGuestTeam(), TLTeamBean.class);
			e.setHostTeam(host);
			e.setGuestTeam(guest);
			pos.add(e);
		}
		tlCompetitionDao.insert(pos);
	}

	@Override
	public void clear() {
		tlCompetitionDao.clear();
	}

}
