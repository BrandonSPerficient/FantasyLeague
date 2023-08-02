package com.brandon.fantasy.league.service;


import com.brandon.fantasy.league.entity.League;
import com.brandon.fantasy.league.repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreateLeagueServiceImpl {

    private final LeagueRepository leagueRepository;

    public CreateLeagueServiceImpl(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public League save(League league) {
        league.setCreationDate(LocalDate.now());
        return leagueRepository.save(league);
    }
}

