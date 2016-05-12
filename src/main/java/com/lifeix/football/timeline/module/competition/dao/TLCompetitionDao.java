package com.lifeix.football.timeline.module.competition.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.lifeix.football.timeline.module.competition.po.TLCompetitionPO;

@Repository
public class TLCompetitionDao {

	private MongoTemplate template ;
	
	public List<TLCompetitionPO> findAll() {
		return template.findAll(TLCompetitionPO.class);
	}

}
