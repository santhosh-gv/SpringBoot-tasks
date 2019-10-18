package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.FileAlreadyExistsException;

@Component
public class CommandLineRunnerSeed implements CommandLineRunner {

    private TrackService trackService;

    @Autowired
    public CommandLineRunnerSeed(TrackService trackService) {
        this.trackService = trackService;
    }

    @Override
    public void run(String... args) throws Exception {
        Track track =new Track(43,"Radioactive","by Imagine Dragons");
        try {
            trackService.saveTrack(track);
        } catch (TrackAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
}
