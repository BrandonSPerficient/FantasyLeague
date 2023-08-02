package com.brandon.fantasy.league.repository;

import com.brandon.fantasy.league.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LeagueRepository extends JpaRepository<League, Integer> {

}
