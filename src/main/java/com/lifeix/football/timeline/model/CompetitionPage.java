package com.lifeix.football.timeline.model;

import java.util.ArrayList;
import java.util.List;

public class CompetitionPage {
    /**
     * 当前比赛
     */
    private TLCompetition currentCompetition;

    private List<TLCompetition> historyCompetitions = new ArrayList<TLCompetition>();

    public TLCompetition getCurrentCompetition() {
        return currentCompetition;
    }

    public void setCurrentCompetition(TLCompetition currentCompetition) {
        this.currentCompetition = currentCompetition;
    }

    public List<TLCompetition> getHistoryCompetitions() {
        return historyCompetitions;
    }

    public void setHistoryCompetitions(List<TLCompetition> historyCompetitions) {
        this.historyCompetitions = historyCompetitions;
    }

}
