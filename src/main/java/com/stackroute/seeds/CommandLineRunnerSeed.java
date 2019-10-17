package com.stackroute.seeds;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerSeed implements CommandLineRunner {

    TrackService trackService;

    @Autowired
    public void AppListener(TrackService trackService)
    {
        this.trackService=trackService;
    }

    @Override
    public void run(String... args) throws Exception {
        Track track =new Track(1,"Radioactive","by Imagine Dragons");
        try {
            trackService.saveTrack(track);
        } catch (TrackAlreadyExistsException e) {
            e.printStackTrace();
        }

    }
}
