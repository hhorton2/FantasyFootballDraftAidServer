package org.hhorton.services;

import org.hhorton.queries.lists.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by hunterhorton on 6/4/17.
 */
@Service
public class PlayerService {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PlayerService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> getAllQuarterBacksFromSeason(int season) {
        return new GetAllQuarterbacksWhoPlayedInSeason(this.jdbcTemplate).execute(season);
    }

    public List<Map<String, Object>> getAllQuarterBacksFromSeasonWithStats(int season) {
        return new PassingService(this.jdbcTemplate)
                .getPassingStatsForPlayersBySeason(season,
                        new GetAllQuarterbacksWhoPlayedInSeasonWithStats(this.jdbcTemplate).execute(season));
    }

    public List<Map<String, Object>> getAllRunningBacksFromSeason(int season) {
        return new GetAllRunningBacksWhoPlayedInSeason(this.jdbcTemplate).execute(season);

    }

    public List<Map<String, Object>> getAllRunningBacksFromSeasonWithStats(int season) {
        return new RushingService(this.jdbcTemplate)
                .getRushingStatsForPlayersBySeason(season,
                        new GetAllRunningBacksWhoPlayedInSeasonWithStats(this.jdbcTemplate).execute(season));
    }

    public List<Map<String, Object>> getAllWideReceiversFromSeason(int season) {
        return new GetAllWideReceiversWhoPlayedInSeason(this.jdbcTemplate).execute(season);

    }

    public List<Map<String, Object>> getAllWideReceiversFromSeasonWithStats(int season) {
        return new ReceivingService(this.jdbcTemplate)
                .getReceivingStatsForPlayersBySeason(season,
                        new GetAllWideReceiversWhoPlayedInSeasonWithStats(this.jdbcTemplate).execute(season));
    }

    public List<Map<String, Object>> getAllTightEndsFromSeason(int season) {
        return new GetAllTightEndsWhoPlayedInSeason(this.jdbcTemplate).execute(season);

    }

    public List<Map<String, Object>> getAllTightEndsFromSeasonWithStats(int season) {
        return new ReceivingService(this.jdbcTemplate)
                .getReceivingStatsForPlayersBySeason(season,
                        new GetAllTightEndsWhoPlayedInSeasonWithStats(this.jdbcTemplate).execute(season));
    }

    public List<Map<String, Object>> getAllKsFromSeason(int season) {
        return new GetAllKickersWhoPlayedInSeason(this.jdbcTemplate).execute(season);

    }

    public List<Map<String, Object>> getAllKsFromSeasonWithStats(int season) {
        return new KickingService(this.jdbcTemplate)
                .getKickingStatsForPlayersBySeason(season,
                        new GetAllKickersWhoPlayedInSeasonWithStats(this.jdbcTemplate).execute(season));
    }

    public List<Map<String, Object>> getAllDefensesFromSeason(int season) {
        return new GetAllDefensesWhoPlayedInSeason(this.jdbcTemplate).execute(season);

    }

    public List<Map<String, Object>> getAllDefensesFromSeasonWithStats(int season) {
        return new DefenseService(this.jdbcTemplate)
                .getDefensiveStatsForTeamsBySeason(season,
                        new GetAllDefensesWhoPlayedInSeasonWithStats(this.jdbcTemplate).execute(season));
    }
}
