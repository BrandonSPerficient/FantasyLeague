package com.brandon.fantasy.league.controller;

import com.brandon.fantasy.league.entity.League;
import com.brandon.fantasy.league.service.GetLeaguesService;
import org.apache.coyote.Response;
import org.hibernate.engine.spi.Resolution;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GetLeaguesController {
    public GetLeaguesController(GetLeaguesService leaguesService) {
        this.leaguesService = leaguesService;
    }
    private GetLeaguesService leaguesService;


    @GetMapping("/leagues")
    public ResponseEntity<List<League>> retrieveAllLeagues() {
        List<League> leagues = leaguesService.retrieveAllLeagues();
        return ResponseEntity.status(HttpStatus.OK).body(leagues);
    }
}
