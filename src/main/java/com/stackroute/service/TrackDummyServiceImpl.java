package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Primary
public class TrackDummyServiceImpl implements TrackService {

    TrackRepository trackRepository;

    @Autowired
    public  TrackDummyServiceImpl(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getTrackId()))
        {
            throw new TrackAlreadyExistsException("Dummy Track already exists");
        }
        Track savedTrack = trackRepository.save(track);
        if(savedTrack==null)
        {
            throw new TrackAlreadyExistsException("Dummy Track already exists");
        }
        return savedTrack;
    }

    @Override
    public List<Track> displaySavedTrack() {
        return trackRepository.findAll();
    }

    @Override
    public Track updateComments(int id,Track track) {
        track.setTrackId(id);
        return track;
    }

    @Override
    public void removeTrack(int trackId) throws TrackNotFoundException {
        if(!trackRepository.existsById(trackId))
        {
            throw new TrackNotFoundException("Dummy Track not found");
        }
        trackRepository.deleteById(trackId);
    }

    @Override
    public Track trackByName(String trackName) throws TrackNotFoundException {
        if(trackRepository.findByTitle(trackName)==null)
        {
            throw new TrackNotFoundException("Dummy Track not found");
        }
        return trackRepository.findByTitle(trackName);

    }
}

