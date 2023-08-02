package com.brandon.fantasy.league.controller;

import com.brandon.fantasy.league.entity.League;
import com.brandon.fantasy.league.service.CreateLeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CreateLeagueController {
    @Autowired
    private CreateLeagueService createLeagueService;

    @PostMapping("/leagues")
    public ResponseEntity<League> CreateLeague(@RequestBody League league) {
        createLeagueService.save(league);
        return ResponseEntity.status(HttpStatus.CREATED).body(league);
    }
}
