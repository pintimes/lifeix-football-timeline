package com.lifeix.football.timeline.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import com.lifeix.football.common.util.JSONUtils;
import com.lifeix.football.timeline.Application;
import com.lifeix.football.timeline.model.TLCompetition;
import com.lifeix.football.timeline.model.TLPlayer;
import com.lifeix.football.timeline.model.TLTeam;
import com.lifeix.football.timeline.module.competition.service.TLCompetitionService;
import com.lifeix.football.timeline.module.team.service.TLTeamService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles("dev,common,system")
public class TimelineTest {

	private static final String CROOT = "/competitions";

	private static final String TROOT = "/teams";

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Autowired
	private TLCompetitionService tlCompetitionService;

	@Autowired
	private TLTeamService tlTeamService;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	int NUM=12;	

	@Test
	public void test() throws Exception {
		tlCompetitionService.clear();
		tlTeamService.clear();
		
		saveTeams();
		saveCompetions();
		
		List<TLTeam> teams = readTeams();
		Assert.assertNotNull(teams);
		Assert.assertEquals(NUM, teams.size());
		for (TLTeam tlTeam : teams) {
			Assert.assertNotNull(tlTeam);
			Assert.assertNotNull(tlTeam.getId());
			Assert.assertNotNull(tlTeam.getName());
			Assert.assertNotNull(tlTeam.getIcon());
			Assert.assertNotNull(tlTeam.getPlayers());
			List<TLPlayer> players = tlTeam.getPlayers();
			for (TLPlayer tlPlayer : players) {
				Assert.assertNotNull(tlPlayer);
				Assert.assertNotNull(tlPlayer.getId());
				Assert.assertNotNull(tlPlayer.getName());
				Assert.assertEquals(tlTeam.getName(), tlPlayer.getTeam());
				Assert.assertNotNull(tlPlayer.getCountry());
				Assert.assertNotNull(tlPlayer.getPosition());
				Assert.assertNotNull(tlPlayer.getShowNum());
//				Assert.assertNotNull(tlPlayer.getClub());
			}
		}
		/**
		 * 校验队伍
		 */
		List<TLCompetition> competitions = readCompetitions();
		Assert.assertNotNull(competitions);
		Assert.assertEquals(NUM, competitions.size());

		/**
		 * 查看数据都是一致的
		 */
		for (TLCompetition tlCompetition : competitions) {
			TLTeam hostTeam = tlCompetition.getHostTeam();
			checkTeam(teams, hostTeam);

			TLTeam guestTeam = tlCompetition.getGuestTeam();
			checkTeam(teams, guestTeam);
		}
	}
	
	private void saveCompetions() throws Exception {
		List<TLTeam> teams = readTeams();
		List<TLCompetition> competitions = new ArrayList<>();
		for (int i = 0; i < NUM; i++) {
			TLCompetition competition = new TLCompetition();
			competition.setId("Competition"+i);
			competition.setName("Competition.name"+i);
			competition.setPlace("Competition.place"+i);
			competition.setTime(new Date());
			TLTeam tlTeam1 = teams.get(i);
			TLTeam tlTeam2 = teams.get((i+1)%NUM);
			competition.setHostTeam(tlTeam1);
			competition.setGuestTeam(tlTeam2);
			competitions.add(competition);
		}
		
		tlCompetitionService.insert(competitions);
	}

	private void saveTeams(){
		List<TLTeam> teams = new ArrayList<>();
		for (int i = 0; i < NUM; i++) {
			TLTeam tlTeam = new TLTeam() ;
			tlTeam.setIcon("tl_icon.jpg");
			tlTeam.setName("team"+i);
			tlTeam.setId("team"+i);
			
			List<TLPlayer> players = new ArrayList<>();
			for (int j = 0; j < 20; j++) {
				TLPlayer tlPlayer = new TLPlayer();
				tlPlayer.setId(""+(i*100)+j);
				tlPlayer.setAvatarUrl(tlTeam.getName()+"_player"+j+".jpg");
				tlPlayer.setBirthplace("");
				tlPlayer.setCountry("");
				tlPlayer.setName("player"+i+j);
				tlPlayer.setNumber(j);
				tlPlayer.setTeam(tlTeam.getName());
				players.add(tlPlayer);
			}
			tlTeam.setPlayers(players);
			teams.add(tlTeam);
		}
		tlTeamService.insert(teams);
	}

	private void checkTeam(List<TLTeam> teams, TLTeam team) {
		TLTeam result = findTeam(teams, team.getName());
		Assert.assertNotNull(result);
		compare(result, team);
	}

	private void compare(TLTeam expect, TLTeam acture) {
		Assert.assertEquals(expect.getId(), acture.getId());
		Assert.assertEquals(expect.getName(), acture.getName());
		Assert.assertEquals(expect.getIcon(), acture.getIcon());
	}

	private TLTeam findTeam(List<TLTeam> teams, String name) {
		for (TLTeam tlTeam : teams) {
			if (tlTeam.getName().equals(name)) {
				return tlTeam;
			}
		}
		return null;
	}

	private List<TLTeam> readTeams() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(TROOT);
		String result = getResult(mvc, builder);
		return JSONUtils.json2list(result, TLTeam.class);
	}

	private List<TLCompetition> readCompetitions() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(CROOT);
		String result = getResult(mvc, builder);
		return JSONUtils.json2list(result, TLCompetition.class);
	}

	private HttpHeaders getAdminHeader() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.put("X-Consumer-Groups", Arrays.asList("admin"));
		return httpHeaders;
	}

	/**
	 * 获得Response
	 * 
	 * @description
	 * @author zengguangwei
	 * @version 2016年5月10日上午8:35:50
	 *
	 * @param mvc
	 * @param builder
	 * @param httpHeaders
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static String getResult(MockMvc mvc, MockHttpServletRequestBuilder builder, HttpHeaders httpHeaders, String content) throws Exception {
		builder.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		if (httpHeaders != null) {
			builder.headers(httpHeaders);
		}
		if (!StringUtils.isEmpty(content)) {
			builder.content(content);
		}
		return getResult(mvc, builder);
	}

	/**
	 * 获得Response
	 * 
	 * @description
	 * @author zengguangwei
	 * @version 2016年5月10日上午8:35:35
	 *
	 * @param mvc
	 * @param builder
	 * @return
	 * @throws Exception
	 */
	public static String getResult(MockMvc mvc, MockHttpServletRequestBuilder builder) throws Exception {
		ResultActions resultActions = mvc.perform(builder);
		resultActions.andDo(MockMvcResultHandlers.print());
		MvcResult result = resultActions.andReturn();
		resultActions.andExpect(status().isOk());
		MockHttpServletResponse response = result.getResponse();
		String content = response.getContentAsString();
		return content;
	}
}
