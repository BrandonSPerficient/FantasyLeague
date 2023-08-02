package com.brandon.fantasy.controller;


import com.brandon.fantasy.league.controller.GetLeagueByIdController;
import com.brandon.fantasy.league.controller.GetLeaguesController;
import com.brandon.fantasy.league.entity.League;
import com.brandon.fantasy.league.service.GetLeagueByIdService;
import com.brandon.fantasy.league.service.GetLeaguesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetLeagueByIdControllerTest {

    @InjectMocks
    private GetLeagueByIdController leagueByIdController;

    @Mock
    private GetLeagueByIdService leagueByIdService;

    @Test
    void retrieveLeague_ValidId_ReturnsLeague(){
        int id = 1;
        League league = new League();
        league.setId(id);

        when(leagueByIdService.findById(id)).thenReturn(league);

        ResponseEntity<League> leagueResponseEntity = leagueByIdController.findById(id);

        assertTrue(leagueResponseEntity.getStatusCode().is2xxSuccessful());
        assertEquals(league, leagueResponseEntity.getBody());
    }
}
