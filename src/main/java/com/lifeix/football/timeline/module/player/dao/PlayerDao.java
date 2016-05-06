package com.lifeix.football.timeline.module.player.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.lifeix.football.common.util.ObjectReflect;
import com.lifeix.football.timeline.model.TLClub;
import com.lifeix.football.timeline.model.TLPlayer;
import com.lifeix.football.timeline.module.player.po.TLPlayerPo;

@Repository
public class PlayerDao {
    private Logger logger = LoggerFactory.getLogger(PlayerDao.class);

    @Autowired
    private MongoTemplate template;

    public List<TLPlayerPo> getPlayers(TLPlayer player, int limit, String orderBy, boolean isAsc) {
        Map<String, Object> notNullAttribute = null;
        try {
            notNullAttribute = new ObjectReflect<TLClub>().getNotNullAttribute(player, player.getClub());
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
        Sort.Direction s = Sort.Direction.ASC;
        if (isAsc) {
            s = Sort.Direction.DESC;
        }
        Sort sort = new Sort(s, orderBy);
        query.with(sort);
        List<TLPlayerPo> list = template.find(query, TLPlayerPo.class);
        return list;
    }

    public void addPlayer(TLPlayer player) {
        template.insert(player);
    }

    private Query getQuery(Map<String, Object> map) {
        Query query = new Query();
        if (map != null && map.size() > 0) {
            for (String key : map.keySet()) {
                if (map.get(key) != null && !map.get(key).equals("")) {
                    if ("club".equals(key)) {
                        Map<String, Object> notNullAttribute = null;
                        try {
                            notNullAttribute = new ObjectReflect().getNotNullAttribute(map.get(key), null);
                        } catch (Exception e) {
                            logger.info("postDao-getQuery:getNotNullAttribute error");
                            e.printStackTrace();
                        }
                        for (String attr : notNullAttribute.keySet()) {
                            if ("id".equals(attr)) {
                                Criteria criteria = Criteria.where("clubId").is(notNullAttribute.get(attr));
                                query.addCriteria(criteria);
                                continue;
                            }
                            Criteria criteria = Criteria.where(key + "." + attr)
                                    .is(notNullAttribute.get(attr));
                            query.addCriteria(criteria);
                        }

                    }
                    Criteria criteria = Criteria.where(key).is(map.get(key));
                    query.addCriteria(criteria);
                }
            }
        }
        return query;
    }

}
