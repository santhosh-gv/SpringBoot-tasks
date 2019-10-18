package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;

    @Autowired
    public  TrackServiceImpl(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getTrackId()))
        {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track savedTrack = trackRepository.save(track);
        if(savedTrack==null)
        {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        return savedTrack;
    }

    @Override
    public List<Track> displaySavedTrack() throws TrackNotFoundException {
        if(trackRepository.findAll()==null)
        {
            throw new TrackNotFoundException();
        }
        return trackRepository.findAll();
    }

    @Override
    public Track updateComments(int id,Track track)  throws TrackNotFoundException {
        if(!trackRepository.existsById(id))
        {
            throw new TrackNotFoundException("Track not found");
        }
        track.setTrackId(id);
        return track;
    }

    @Override
    public Optional<Track> removeTrack(int trackId) throws TrackNotFoundException {
        if(!trackRepository.existsById(trackId))
        {
            throw new TrackNotFoundException("Track not found");
        }
        Optional<Track> track = trackRepository.findById(trackId);
        trackRepository.deleteById(trackId);
        return track;
    }

    @Override
    public Track trackByName(String trackName) throws TrackNotFoundException {
        if(trackRepository.findByTrackName(trackName)==null)
        {
            throw new TrackNotFoundException("Track not found");
        }
        return trackRepository.findByTrackName(trackName);

    }

}
