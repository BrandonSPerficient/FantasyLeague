package com.brandon.fantasy.service;

import com.brandon.fantasy.league.entity.League;
import com.brandon.fantasy.league.repository.LeagueRepository;
import com.brandon.fantasy.league.service.CreateLeagueServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CreateServiceImplTest {

    @Mock
    private LeagueRepository leagueRepository;

    @InjectMocks
    private CreateLeagueServiceImpl createLeagueServiceImpl;


    @Test
    void save_validLeague_ReturnsSavedLeague() {
        League league = new League();

        when(leagueRepository.save(league)).thenReturn(league);

        League savedLeague = createLeagueServiceImpl.save(league);

        verify(leagueRepository).save(league);
        assertEquals(league, savedLeague);
    }
}
