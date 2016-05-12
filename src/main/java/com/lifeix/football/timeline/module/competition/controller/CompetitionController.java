package com.lifeix.football.timeline.module.competition.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lifeix.football.common.util.AuthorizationUtil;
import com.lifeix.football.timeline.model.TLCompetition;
import com.lifeix.football.timeline.module.competition.service.TLCompetitionService;

@RestController
@RequestMapping(value = "/tlcompetitions")
public class CompetitionController {

	private TLCompetitionService tlCompetitionService;

	/**
	 * 按时间倒叙返回赛事信息
	 * 
	 * @description
	 * @author zengguangwei
	 * @version 2016年5月12日下午1:44:27
	 *
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<TLCompetition> getTLCompetitions() {
		return tlCompetitionService.list();
	}

	/**
	 * 修改比赛比分
	 * 
	 * @description
	 * @author zengguangwei
	 * @version 2016年5月12日下午1:44:44
	 *
	 * @param groups
	 * @param competition
	 * @return
	 */
	@RequestMapping(value = "/{tlcompetitionId}/score", method = RequestMethod.PUT)
	public void updateTLCompetitionScore(@RequestHeader(required = true, value = "X-Consumer-Groups") String groups,
			@PathVariable(value = "tlcompetitionId") String tlcompetitionId, @RequestParam(value = "hostScore", required = false) Integer hostScore,
			@RequestParam(value = "guestScore", required = false) Integer guestScore) {
		AuthorizationUtil.adminAuthorization(groups);
		tlCompetitionService.changeScore(tlcompetitionId, hostScore, guestScore);
	}

}
