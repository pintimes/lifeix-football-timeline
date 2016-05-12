package com.lifeix.football.timeline.module.competition.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifeix.football.common.util.AdapterUtil;
import com.lifeix.football.timeline.model.TLCompetition;
import com.lifeix.football.timeline.module.competition.dao.TLCompetitionDao;
import com.lifeix.football.timeline.module.competition.po.TLCompetitionPO;
import com.lifeix.football.timeline.module.competition.service.TLCompetitionService;

@Service
public class TLCompetitionServiceImpl implements TLCompetitionService {

	@Autowired
	private TLCompetitionDao tlCompetitionDao;

	@Override
	public List<TLCompetition> list() {
		List<TLCompetitionPO> pos = tlCompetitionDao.findAll();
		return AdapterUtil.toTs(pos, TLCompetition.class);
	}

}
