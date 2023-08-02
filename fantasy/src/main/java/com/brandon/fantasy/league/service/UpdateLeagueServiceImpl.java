package com.brandon.fantasy.league.service;

import com.brandon.fantasy.league.entity.League;
import com.brandon.fantasy.league.exception.LeagueExceptionHandler;
import com.brandon.fantasy.league.repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UpdateLeagueServiceImpl {

    private LeagueRepository repository;

    public UpdateLeagueServiceImpl(LeagueRepository repository) {
        this.repository = repository;
    }

    private void update(League league, League currentLeague) {
        currentLeague.setName(league.getName());
        currentLeague.setPpr(league.getPpr());
        currentLeague.setNumberOfTeams(league.getNumberOfTeams());
        currentLeague.setCreationDate(league.getCreationDate());
    }


    public League updateLeague(int id, League league) {
        Optional<League> currentLeague = repository.findById(id);
        if (currentLeague.isEmpty()) {
            throw new LeagueExceptionHandler("This league doesn't exist");
        }
        update(league, currentLeague.get());
        repository.save(currentLeague.get());
        return currentLeague.get();
    }


}
