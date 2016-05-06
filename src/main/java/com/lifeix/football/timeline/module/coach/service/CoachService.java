package com.lifeix.football.timeline.module.coach.service;

import java.util.List;

import com.lifeix.football.timeline.model.TLCoach;

public interface CoachService {

    public List<TLCoach> getCoachs(TLCoach coach, int limit, String orderBy, boolean isAsc);

    public TLCoach addCoach(TLCoach coach);

    public TLCoach getCoach(String coachId);

}
