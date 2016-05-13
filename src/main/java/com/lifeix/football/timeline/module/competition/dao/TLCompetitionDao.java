package com.lifeix.football.timeline.module.competition.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.lifeix.football.timeline.model.TLCompetition;
import com.lifeix.football.timeline.module.competition.po.TLCompetitionPO;

@Repository
public class TLCompetitionDao {

	@Autowired
	private MongoTemplate template ;
	
	public List<TLCompetitionPO> findAll() {
		Query query = new Query();
        Sort sort = new Sort(Sort.Direction.DESC, "time");
        query.with(sort);
		return template.find(query,TLCompetitionPO.class);
	}

	public void changeScore(String id, int hostScore, int guestScore) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		Update update = new Update();
		update.set("hostScore", hostScore);
		update.set("guestScore", guestScore);
		template.findAndModify(query, update, TLCompetitionPO.class);
	}

	public void save(TLCompetition tlCompetition) {
		template.save(tlCompetition);	
	}

}
