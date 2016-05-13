package com.lifeix.football.timeline.module.team.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifeix.football.timeline.model.TLTeam;
import com.lifeix.football.timeline.module.team.service.TLTeamService;

@RestController
@RequestMapping(value = "/tlteams")
public class TeamController {

	@Autowired
	private TLTeamService tlTeamService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<TLTeam> list() {
		return tlTeamService.list();
	}

	@RequestMapping(value = "/{tlteamId}", method = RequestMethod.GET)
	public TLTeam getTeam(@PathParam(value = "tlteamId") String teamId) {
		TLTeam tlTeam = tlTeamService.get(teamId);
		return tlTeam;
	}
}
