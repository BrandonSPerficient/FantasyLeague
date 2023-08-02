package com.brandon.fantasy.service;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Optional;

import com.brandon.fantasy.league.entity.League;
import com.brandon.fantasy.league.exception.LeagueExceptionHandler;
import com.brandon.fantasy.league.repository.LeagueRepository;
import com.brandon.fantasy.league.service.UpdateLeagueServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UpdateLeagueServiceImplTest {

    @Mock
    private LeagueRepository repository;

    @InjectMocks
    private UpdateLeagueServiceImpl updateLeagueService;

    private League existingLeague;
    private League updatedLeague;

    @BeforeEach
    void setUp() {
        // Create sample data for testing
        existingLeague = new League(1, "Fantasy Football League", Boolean.TRUE, 10, LocalDate.parse("2023-08-01"));
        updatedLeague = new League(1, "Updated Fantasy Football League", Boolean.FALSE, 12, LocalDate.parse("2023-08-02"));

        // Mock the behavior of repository.findById(id)
        when(repository.findById(existingLeague.getId())).thenReturn(Optional.of(existingLeague));
    }

    @Test
    void updateLeague_ExistingLeague_ReturnsUpdatedLeague() {
        // Call the service method
        League result = updateLeagueService.updateLeague(existingLeague.getId(), updatedLeague);

        // Verify that repository.findById(id) is called once
        verify(repository).findById(existingLeague.getId());

        // Verify that repository.save() is called once with the updatedLeague
        verify(repository).save(updatedLeague);

        // Verify that the returned League object is the same as the updatedLeague
        Assertions.assertEquals(updatedLeague, result);
    }

}
