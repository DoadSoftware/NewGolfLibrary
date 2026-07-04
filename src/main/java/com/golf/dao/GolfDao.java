package com.golf.dao;

import java.util.List;

import com.golf.model.Fixture;
import com.golf.model.Ground;
import com.golf.model.NameSuper;
import com.golf.model.Player;
import com.golf.model.Result;
import com.golf.model.Statistics;
import com.golf.model.Team;
import com.golf.model.VariousText;

public interface GolfDao {
  Player getPlayer(int player_id);
  Team getTeam(int teamId);
  List<Player> getAllPlayer();
  List<Team> getAllTeams();
  List<NameSuper> getNameSupers();
  List<Fixture> getFixtures();
  List<VariousText> getVariousTexts();
  List<Statistics> getStatistics();
  List<Result> getResults();
  List<Ground> getGround();
}