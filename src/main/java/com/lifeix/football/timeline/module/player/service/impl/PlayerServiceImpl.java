package com.lifeix.football.timeline.module.player.service.impl;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lifeix.football.common.exception.IllegalparamException;
import com.lifeix.football.timeline.model.TLPlayer;
import com.lifeix.football.timeline.module.player.dao.PlayerDao;
import com.lifeix.football.timeline.module.player.po.TLPlayerPo;
import com.lifeix.football.timeline.module.player.service.PlayerService;
import com.lifeix.football.timeline.util.AdapterUtil;

@Service
public class PlayerServiceImpl implements PlayerService {

    private Logger logger = LoggerFactory.getLogger(PlayerServiceImpl.class);

    @Autowired
    private PlayerDao playerDao;

    @Override
    public List<TLPlayer> getPlayers(TLPlayer player, int limit, String orderBy, boolean isAsc) {
        if (player == null) {
            throw new IllegalparamException("getPlayers:player can not be null");
        }
        List<TLPlayerPo> players = playerDao.getPlayers(player, limit, orderBy, isAsc);
        return AdapterUtil.toTs(players, TLPlayer.class);
    }

    @Override
    public TLPlayer addPlayer(TLPlayer player) {
        if (player == null) {
            throw new IllegalparamException("addPlayer:player can not be null");
        }
        // teamId
        if (StringUtils.isEmpty(player.getTeamId())) {
            throw new IllegalparamException("addPlayer:player's teamId can not be null");
        }
        // name
        if (StringUtils.isEmpty(player.getName())) {
            throw new IllegalparamException("addPlayer:player's name can not be null");
        }
        // avatarUrl
        if (StringUtils.isEmpty(player.getAvatarUrl())) {
            throw new IllegalparamException("addPlayer:player's avatarUrl can not be null");
        }
        // birthday
        if (StringUtils.isEmpty(player.getBirthday())) {
            throw new IllegalparamException("addPlayer:player's birthday can not be null");
        }
        String id = new ObjectId().toString();
        logger.info("generate post's id ={} , post = {} ", id, player);
        player.setId(id);
        player.setLikeNum(0);
        player.setCreateTime(new Date());
        playerDao.addPlayer(player);
        return player;
    }

}
