package com.stackroute.seeds;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.repository.TrackRepository;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerSeed implements CommandLineRunner {

    @Autowired
    TrackRepository trackRepository;

    @Override
    public void run(String... args) throws Exception {
        Track track =new Track(1,"Radioactive","by Imagine Dragons");
        trackRepository.save(track);

    }
}
