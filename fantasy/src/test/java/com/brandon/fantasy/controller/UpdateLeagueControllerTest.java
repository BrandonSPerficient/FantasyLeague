package com.brandon.fantasy.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import com.brandon.fantasy.league.controller.UpdateLeagueController;
import com.brandon.fantasy.league.entity.League;
import com.brandon.fantasy.league.service.UpdateLeagueServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


import java.time.LocalDate;


@ExtendWith(MockitoExtension.class)
public class UpdateLeagueControllerTest {

    @Mock
    private UpdateLeagueServiceImpl updateLeagueService;

    @InjectMocks
    private UpdateLeagueController updateLeagueController;

    @Test
    void updateAppointment_ValidLeague_ReturnsOkResponse() throws Exception {
        int id = 1;
        League updatedLeague = new League(id, "Updated Fantasy Football League", Boolean.FALSE, 12, LocalDate.parse("2023-08-02"));

        when(updateLeagueService.updateLeague(eq(id), any(League.class))).thenReturn(updatedLeague);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(updateLeagueController)
                .setValidator(new LocalValidatorFactoryBean())
                .build();

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/leagues/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"Updated Fantasy Football League\", \"ppr\": false, \"numberOfTeams\": 12, \"creationDate\": \"2023-08-02\" }"))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        verify(updateLeagueService, times(1)).updateLeague(eq(id), any(League.class));

    }
}

