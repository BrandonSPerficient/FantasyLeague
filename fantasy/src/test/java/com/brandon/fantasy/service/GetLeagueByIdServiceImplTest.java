package com.brandon.fantasy.service;

import com.brandon.fantasy.league.entity.League;
import com.brandon.fantasy.league.exception.LeagueExceptionHandler;
import com.brandon.fantasy.league.repository.LeagueRepository;
import com.brandon.fantasy.league.service.GetLeagueByIdServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetLeagueByIdServiceImplTest {

    @Mock
    private LeagueRepository repository;

    @InjectMocks
    private GetLeagueByIdServiceImpl service;

    @Test
    void Get_ValidLeague_ReturnLeagueById() {
        int id = 1;
        League league = new League();
        league.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(league));

        League result = service.findById(id);

        verify(repository).findById(id);
        assertEquals(league, result);
    }

    @Test
    void findById_NonExistingId_ThrowsException() {

        int id = 2;

        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(LeagueExceptionHandler.class, () -> service.findById(id));

        verify(repository).findById(id);
    }

}
