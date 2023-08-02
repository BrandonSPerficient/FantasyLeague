package com.brandon.fantasy.league.controller;


import com.brandon.fantasy.league.entity.League;
import com.brandon.fantasy.league.service.UpdateLeagueServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UpdateLeagueController {

    private UpdateLeagueServiceImpl updateLeagueService;

    public UpdateLeagueController(UpdateLeagueServiceImpl updateLeagueService) {
        this.updateLeagueService = updateLeagueService;
    }

    @PutMapping("/leagues/{id}")
    public ResponseEntity<League> updateAppointment(
            @PathVariable int id,
            @Valid @RequestBody League league) {
        League updatedLeague = updateLeagueService.updateLeague(id, league);
        return ResponseEntity.ok(updatedLeague);
    }
}
