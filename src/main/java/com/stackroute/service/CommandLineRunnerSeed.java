package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerSeed implements CommandLineRunner {

    private TrackRepository trackRepository;

    @Autowired
    public CommandLineRunnerSeed(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Track track =new Track(1,"Radioactive","by Imagine Dragons");
        trackRepository.save(track);

    }
}
