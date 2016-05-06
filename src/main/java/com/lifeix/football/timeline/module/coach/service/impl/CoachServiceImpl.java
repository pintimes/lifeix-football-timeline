package com.lifeix.football.timeline.module.coach.service.impl;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lifeix.football.common.exception.IllegalparamException;
import com.lifeix.football.common.exception.NotFindException;
import com.lifeix.football.timeline.model.TLCoach;
import com.lifeix.football.timeline.module.coach.dao.CoachDao;
import com.lifeix.football.timeline.module.coach.po.TLCoachPo;
import com.lifeix.football.timeline.module.coach.service.CoachService;
import com.lifeix.football.timeline.util.AdapterUtil;

@Service
public class CoachServiceImpl implements CoachService {

    private Logger logger = LoggerFactory.getLogger(CoachServiceImpl.class);

    @Autowired
    private CoachDao coachDao;

    @Override
    public List<TLCoach> getCoachs(TLCoach coach, int limit, String orderBy, boolean isAsc) {
        if (coach == null) {
            throw new IllegalparamException("getCoachs:coach can not be null");
        }
        List<TLCoachPo> Coachs = coachDao.getCoachs(coach, limit, orderBy, isAsc);
        return AdapterUtil.toTs(Coachs, TLCoach.class);
    }

    @Override
    public TLCoach addCoach(TLCoach coach) {
        if (coach == null) {
            throw new IllegalparamException("addCoach:Coach can not be null");
        }
        // teamId
        if (StringUtils.isEmpty(coach.getTeamId())) {
            throw new IllegalparamException("addCoach:Coach's teamId can not be null");
        }
        // name
        if (StringUtils.isEmpty(coach.getName())) {
            throw new IllegalparamException("addCoach:Coach's name can not be null");
        }
        // avatarUrl
        if (StringUtils.isEmpty(coach.getAvatarUrl())) {
            throw new IllegalparamException("addCoach:Coach's avatarUrl can not be null");
        }
        // birthday
        if (StringUtils.isEmpty(coach.getBirthday())) {
            throw new IllegalparamException("addCoach:Coach's birthday can not be null");
        }
        String id = new ObjectId().toString();
        logger.info("generate post's id ={} , post = {} ", id, coach);
        coach.setId(id);
        coach.setCreateTime(new Date());
        coachDao.addCoach(AdapterUtil.toT(coach, TLCoachPo.class));
        return coach;
    }

    @Override
    public TLCoach getCoach(String CoachId) {
        logger.debug("getPost id = {} ", CoachId);
        TLCoachPo po = coachDao.getById(CoachId);
        if (po == null) {
            throw new NotFindException("getCoach: Coach not find");
        }
        return AdapterUtil.toT(po, TLCoach.class);
    }

}
