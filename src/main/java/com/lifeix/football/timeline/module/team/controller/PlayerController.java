package com.lifeix.football.timeline.module.team.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifeix.football.timeline.model.TLPlayer;
import com.lifeix.football.timeline.module.team.service.TLPlayerService;

@RestController
@RequestMapping(value = "/tlplayers")
public class PlayerController {
	
	@Autowired
	private TLPlayerService tlPlayerService;

	@RequestMapping(value = "/{tlteamId}", method = RequestMethod.GET)
	public List<TLPlayer> getTeam(@PathParam(value = "tlteamId") String teamId) {
		return tlPlayerService.list(teamId);
	}
}
