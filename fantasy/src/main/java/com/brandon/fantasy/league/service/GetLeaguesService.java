package com.brandon.fantasy.league.service;


import com.brandon.fantasy.league.entity.League;
import com.brandon.fantasy.league.repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetLeaguesService {

    private final LeagueRepository leagueRepository;


    public GetLeaguesService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public List<League> retrieveAllLeagues() {

        List<League> leagues = leagueRepository.findAll();
        //input if no league, throw exception handler

        return leagueRepository.findAll();
    }
}
