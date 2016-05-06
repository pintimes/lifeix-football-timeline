package com.lifeix.football.timeline.module.coach.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.lifeix.football.common.util.ObjectReflect;
import com.lifeix.football.timeline.model.TLCoach;
import com.lifeix.football.timeline.module.coach.po.TLCoachPo;

@Repository
public class CoachDao {
    @Autowired
    private MongoTemplate template;

    public List<TLCoachPo> getCoachs(TLCoach coach, int limit, String orderBy, boolean isAsc) {
        Map<String, Object> notNullAttribute = null;
        try {
            notNullAttribute = new ObjectReflect().getNotNullAttribute(coach, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Query query = getQuery(notNullAttribute);
        // 球员列表不现实球员介绍
        query.fields().exclude("introduction");
        /**
         * 显示限制
         */
        Math.max(0, limit);
        Math.min(50, limit);
        query.limit(limit);
        /**
         * 排序
         */
        Sort.Direction s = Sort.Direction.DESC;
        if (isAsc) {
            s = Sort.Direction.ASC;
        }
        Sort sort = new Sort(s, orderBy);
        query.with(sort);
        List<TLCoachPo> list = template.find(query, TLCoachPo.class);
        return list;
    }

    public void addCoach(TLCoachPo coach) {
        template.insert(coach);
    }

    private Query getQuery(Map<String, Object> map) {
        Query query = new Query();
        if (map != null && map.size() > 0) {
            for (String key : map.keySet()) {
                if (map.get(key) != null && !map.get(key).equals("")) {
                    Criteria criteria = Criteria.where(key).is(map.get(key));
                    query.addCriteria(criteria);
                }
            }
        }
        return query;
    }

    public TLCoachPo getById(String coachId) {
        return template.findById(coachId, TLCoachPo.class);
    }

}
