package com.golf.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import com.golf.model.Fixture;
import com.golf.model.GolfScoresResponse.PlayerScore;
import com.golf.model.Player;
import com.golf.model.Result;
import com.golf.model.Team;
import com.golf.service.GolfService;

public class GolfFunctions { 
	

	public static class leaderboardComparator implements Comparator<PlayerScore> {
	    @Override
	    public int compare(PlayerScore gs1, PlayerScore gs2) {
    		int golf_score1 = safeParse(gs1.getScore());
    		int golf_score2 = safeParse(gs2.getScore());
    		return Integer.compare(golf_score1, golf_score2);
	    }
	    private int safeParse(String value) {
	        if (value == null || value.trim().isEmpty()) {
	            return 0;
	        }
	        return Integer.parseInt(value);
	    }
	}
	
	public static List<Fixture> processAllFixtures(GolfService golfService) {
		List<Fixture> fixtures = golfService.getFixtures();
		for(Player plyr : golfService.getAllPlayer()) {
			for(Fixture fix : fixtures) {
				if(fix.getHomePlayerFirst() == plyr.getPlayerId()) {
					fix.setHome_FirstPlayer(plyr);
				}
				if(fix.getAwayPlayerFirst() == plyr.getPlayerId()) {
					fix.setAway_FirstPlayer(plyr);
				}
				if(fix.getHomePlayerSecond() != null) {
					if(fix.getHomePlayerSecond() == plyr.getPlayerId()) {
						fix.setHome_SecondPlayer(plyr);
					}
				}
				if(fix.getAwayPlayerSecond() != null) {
					if(fix.getAwayPlayerSecond() == plyr.getPlayerId()) {
						fix.setAway_SecondPlayer(plyr);
					}
				}
			}
		}
		return fixtures;
	}
	
	public static List<Result> processAllResults(GolfService golfService) {
		List<Result> results = golfService.getResults();
		for(Team tm : golfService.getAllTeams()) {
			for(Result res : results) {
				if(res.getHomeTeam() == tm.getTeamId()) {
					res.setHome_Team(tm);
				}
				if(res.getAwayTeam() == tm.getTeamId()) {
					res.setAway_Team(tm);
				}
			}
		}
		return results;
	}
	
	
	public static String getOnlineCurrentDate() throws IOException
	{
		HttpURLConnection httpCon = (HttpURLConnection) new URL("https://mail.google.com/").openConnection();
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date(httpCon.getDate()));
	}	
	
}
