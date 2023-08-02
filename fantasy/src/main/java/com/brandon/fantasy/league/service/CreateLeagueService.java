package com.brandon.fantasy.league.service;


import com.brandon.fantasy.league.entity.League;
import com.brandon.fantasy.league.repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class CreateLeagueService {

    private final LeagueRepository leagueRepository;

    public CreateLeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public League save(League league) {
        league.setCreationDate(LocalDate.now());
        return leagueRepository.save(league);
    }
}

