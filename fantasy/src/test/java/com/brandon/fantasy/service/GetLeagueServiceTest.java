package com.brandon.fantasy.service;


import com.brandon.fantasy.league.entity.League;
import com.brandon.fantasy.league.repository.LeagueRepository;
import com.brandon.fantasy.league.service.GetLeaguesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetLeagueServiceTest {

    @InjectMocks
    private GetLeaguesService leaguesService;

    @Mock
    private LeagueRepository repository;

    @Test
    void retrieveAlLeagues_ReturnAllLeagues() {
        List<League> leagueList = new ArrayList<>();
        leagueList.add(new League(1, "Brandon's League", Boolean.TRUE, 10, LocalDate.now()));
        leagueList.add(new League(1, "Fantasy Football League", Boolean.FALSE, 10, LocalDate.now()));

        when(repository.findAll()).thenReturn(leagueList);

        List<League> leagueResult = leaguesService.retrieveAllLeagues();

        assertEquals(leagueList.size(), leagueResult.size());
        assertEquals(leagueList.get(0).getId(), leagueResult.get(0).getId());
        assertEquals(leagueList.get(0).getId(), leagueResult.get(0).getId());
    }

}
