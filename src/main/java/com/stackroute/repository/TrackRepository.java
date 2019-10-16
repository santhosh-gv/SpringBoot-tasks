package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {

    @Query(value = "SELECT u FROM Track u WHERE u.trackName = ?1 ")
    Track findByTitle(@Param("trackName") String trackName);
}

