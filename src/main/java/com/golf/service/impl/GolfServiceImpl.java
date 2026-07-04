package com.golf.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.golf.dao.GolfDao;
import com.golf.model.Fixture;
import com.golf.model.Ground;
import com.golf.model.NameSuper;
import com.golf.model.Player;
import com.golf.model.Result;
import com.golf.model.Statistics;
import com.golf.model.Team;
import com.golf.model.VariousText;
import com.golf.service.GolfService;

@Service("golfService")
@Transactional
public class GolfServiceImpl implements GolfService {

 @Autowired
 private GolfDao golfDao;
 
@Override
public Player getPlayer(int player_id) {
	return golfDao.getPlayer(player_id);
}
@Override
public List<Player> getAllPlayer() {
	return golfDao.getAllPlayer();
}
@Override
public List<NameSuper> getNameSupers() {
	return golfDao.getNameSupers();
}
@Override
public List<Fixture> getFixtures() {
	return golfDao.getFixtures();
}

@Override
public List<Result> getResults() {
	return golfDao.getResults();
}

@Override
public List<VariousText> getVariousTexts() {
	return golfDao.getVariousTexts();
}
@Override
public List<Statistics> getStatistics() {
	return golfDao.getStatistics();
}
@Override
public List<Team> getAllTeams() {
	return golfDao.getAllTeams();
}
@Override
public Team getTeam(int teamId) {
	return golfDao.getTeam(teamId);
}
@Override
public List<Ground> getGround() {
	return golfDao.getGround();
}
}