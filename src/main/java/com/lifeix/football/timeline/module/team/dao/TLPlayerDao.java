package com.lifeix.football.timeline.module.team.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.lifeix.football.timeline.module.team.po.TLPlayerPO;

@Repository
public class TLPlayerDao {

	@Autowired
	private MongoTemplate template;

	public TLPlayerPO findById(String id) {
		return template.findById(id, TLPlayerPO.class);
	}

	public List<TLPlayerPO> findByTeam(String teamId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("teamId").is(teamId));
		return template.find(query, TLPlayerPO.class);
	}

}
