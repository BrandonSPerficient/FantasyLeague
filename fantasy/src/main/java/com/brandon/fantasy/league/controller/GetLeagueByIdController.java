package com.brandon.fantasy.league.controller;


import com.brandon.fantasy.league.entity.League;
import com.brandon.fantasy.league.service.GetLeagueByIdServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GetLeagueByIdController {

    private GetLeagueByIdServiceImpl leagueByIdService;

    public GetLeagueByIdController(GetLeagueByIdServiceImpl leagueByIdService) {
        this.leagueByIdService = leagueByIdService;
    }

    @GetMapping("/leagues/{id}")
    public ResponseEntity<League> findById(@PathVariable int id) {
        League league = leagueByIdService.findById(id);
        return ResponseEntity.ok(league);
    }
}
