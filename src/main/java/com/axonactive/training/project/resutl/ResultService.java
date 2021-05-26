package com.axonactive.training.project.resutl;

import java.util.ArrayList;
import java.util.List;

import com.axonactive.training.project.match.Match;

public class ResultService {

    private List<Result> results = new ArrayList<>();

    public void createResutl(List<Match> matches) {
        for (int i = 0; i < matches.size(); i++) {
            Result result = new Result(matches.get(i), 0, 0);
            results.add(result);
        }
    }

    public void setScore(int noOfMatch, int scoreOfTeamA, int scoreOfTeamB) {

        results.get(noOfMatch - 1).setScoreOfTeamA(scoreOfTeamA);
        results.get(noOfMatch - 1).setScoreOfTeamA(scoreOfTeamB);

        int teamAScore = results.get(noOfMatch - 1).getMatch().getTeamA().getScore();
        int teamBScore = results.get(noOfMatch - 1).getMatch().getTeamB().getScore();

        if (scoreOfTeamA > scoreOfTeamB) {
            results.get(noOfMatch - 1).getMatch().getTeamA().setScore(teamAScore + 3);
        } else if (scoreOfTeamA == scoreOfTeamB) {
            results.get(noOfMatch - 1).getMatch().getTeamB().setScore(teamBScore + 1);
            results.get(noOfMatch - 1).getMatch().getTeamA().setScore(teamAScore + 1);
        } else
            results.get(noOfMatch - 1).getMatch().getTeamB().setScore(teamBScore + 3);

    }
}