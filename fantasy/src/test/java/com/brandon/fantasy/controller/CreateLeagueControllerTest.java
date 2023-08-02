package com.brandon.fantasy.controller;

import com.brandon.fantasy.league.controller.CreateLeagueController;
import com.brandon.fantasy.league.entity.League;
import com.brandon.fantasy.league.exception.LeagueExceptionHandler;
import com.brandon.fantasy.league.service.CreateLeagueService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class CreateLeagueControllerTest {
    @InjectMocks
    private CreateLeagueController createLeagueController;

    @Mock
    private CreateLeagueService createLeagueService;

    @Test
    void createLeague_ValidInput_ReturnsSuccess() {
        League league = new League();

        when(createLeagueService.save(league)).thenReturn(league);

        ResponseEntity<League> leagueResponseEntity = createLeagueController.CreateLeague(league);

        assertEquals(HttpStatus.CREATED, leagueResponseEntity.getStatusCode());
    }

    @Test
    void createLeague_InvalidInput_ReturnsConflict() {
        League league = new League();

        doThrow(new LeagueExceptionHandler("Error creating league.")).when(createLeagueService).save(league);

        ResponseEntity<League> response = createLeagueController.CreateLeague(league);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }
}
