package com.lifeix.football.timeline.module.team.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.lifeix.football.timeline.module.team.po.TLTeamPO;

@Repository
public class TLTeamDao {

	@Autowired
	private MongoTemplate template;

	public TLTeamPO findById(String id) {
		return template.findById(id, TLTeamPO.class);
	}

	public List<TLTeamPO> findAll() {
		return template.findAll(TLTeamPO.class);
	}

	public void insert(List<TLTeamPO> pos) {
		template.insert(pos, TLTeamPO.class);
	}

	public void clear() {
		template.remove(new Query(),TLTeamPO.class);
	}

}
