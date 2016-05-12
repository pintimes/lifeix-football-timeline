package com.lifeix.football.timeline.module.competition.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifeix.football.timeline.model.TLCompetition;
import com.lifeix.football.timeline.module.competition.service.TLCompetitionService;


@RestController
@RequestMapping(value = "/tlcompetitions")
public class CompetitionController {

	private TLCompetitionService tlCompetitionService ;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<TLCompetition> list() {
		return tlCompetitionService.list();
	}
}
