package com.lifeix.football.timeline.module.player.controller;

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
import com.lifeix.football.timeline.model.TLPlayer;
import com.lifeix.football.timeline.module.player.service.PlayerService;

@RestController
@RequestMapping(value = "/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    /**
     * 默认显示23人(大型比赛大名单一般23人)
     * 
     * @param player
     * @param limit
     * @param orderBy
     * @param isAsc
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<TLPlayer> getPlayers(TLPlayer player,
            @RequestParam(defaultValue = "23", value = "limit", required = false) int limit,
            @RequestParam(value = "orderBy", defaultValue = "clotheNum", required = false) String orderBy,
            @RequestParam(value = "isAsc", defaultValue = "true", required = false) boolean isAsc) {
        return playerService.getPlayers(player, limit, orderBy, isAsc);
    }

    @RequestMapping(value = "/{playerId}", method = RequestMethod.GET)
    public TLPlayer getPlayer(@PathVariable(value = "playerId") String playerId) {
        return playerService.getPlayer(playerId);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public TLPlayer addPlayer(@RequestHeader(required = true, value = "X-Consumer-Groups") String groups,
            @RequestBody(required = true) TLPlayer player) {
        if (!"admin".equals(groups)) {
            throw new AuthorizationException("addPlayer: only admin can add player");
        }
        return playerService.addPlayer(player);
    }

}
