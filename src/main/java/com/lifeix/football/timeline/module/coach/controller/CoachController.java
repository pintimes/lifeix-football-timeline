package com.lifeix.football.timeline.module.coach.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lifeix.football.common.exception.AuthorizationException;
import com.lifeix.football.timeline.model.TLCoach;
import com.lifeix.football.timeline.module.coach.service.CoachService;

@RestController
@RequestMapping(value = "/coaches")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<TLCoach> getCoachs(TLCoach coach,
            @RequestParam(defaultValue = "10", value = "limit", required = false) int limit,
            @RequestParam(value = "orderBy", defaultValue = "order", required = false) String orderBy,
            @RequestParam(value = "isAsc", defaultValue = "true", required = false) boolean isAsc) {
        return coachService.getCoachs(coach, limit, orderBy, isAsc);
    }

    @RequestMapping(value = "/{coachId}", method = RequestMethod.GET)
    public TLCoach getCoach(@PathVariable(value = "coachId") String coachId) {
        return coachService.getCoach(coachId);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public TLCoach addCoach(@RequestHeader(required = true, value = "X-Consumer-Groups") String groups,
            @RequestBody(required = true) TLCoach coach) {
        if (!"admin".equals(groups)) {
            throw new AuthorizationException("addPlayer: only admin can add player");
        }
        return coachService.addCoach(coach);
    }

}
