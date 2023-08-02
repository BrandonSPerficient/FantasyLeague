package com.brandon.fantasy.controller;

import com.brandon.fantasy.league.controller.GetLeaguesController;
import com.brandon.fantasy.league.entity.League;
import com.brandon.fantasy.league.service.GetLeaguesService;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class GetLeagueControllerTest {

    @InjectMocks
    private GetLeaguesController leaguesController;

    @Mock
    private GetLeaguesService leaguesService;


    @Test
    void retrieveAllLeagues_ReturnsListOfLeagues() throws Exception {
        League league1 = new League(1, "Fantasy Football League", Boolean.TRUE, 10, LocalDate.parse("2023-08-02"));
        League league2 = new League(2, "Fantasy Bowl League", Boolean.FALSE, 12, LocalDate.parse("2023-08-02"));

        List<League> leagues = new ArrayList<>();
        leagues.add(league1);
        leagues.add(league2);

        when(leaguesService.retrieveAllLeagues()).thenReturn(leagues);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(leaguesController).build();

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/leagues"))
                .andExpect(status().isOk());
    }


}
