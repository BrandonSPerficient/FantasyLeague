package com.brandon.fantasy.league.service;

import com.brandon.fantasy.league.entity.League;
import com.brandon.fantasy.league.exception.LeagueExceptionHandler;
import com.brandon.fantasy.league.repository.LeagueRepository;
import org.springframework.stereotype.Service;


@Service
public class GetLeagueByIdServiceImpl {

    private LeagueRepository repository;

    public GetLeagueByIdServiceImpl(LeagueRepository repository) {
        this.repository = repository;
    }

    public League findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new LeagueExceptionHandler("The Appointment doesn't Exist"));
    }

}
