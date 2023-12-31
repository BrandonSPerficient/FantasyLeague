package com.brandon.fantasy.league.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "League")
public class League {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Boolean ppr;
    @Size(min = 8, max = 12)
    private Integer numberOfTeams;
    private LocalDate creationDate;


}
