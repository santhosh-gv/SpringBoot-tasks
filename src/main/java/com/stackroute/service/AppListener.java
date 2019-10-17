package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.nio.file.FileAlreadyExistsException;

@Component
public class AppListener implements ApplicationListener<ContextRefreshedEvent> {


    private TrackRepository trackRepository;

    @Autowired
    public AppListener(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Track track = new Track(0, "Not Afraid", "by Eminem");
        trackRepository.save(track);

    }
}
