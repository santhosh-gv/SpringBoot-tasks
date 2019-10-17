package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TrackService {

    // save track
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    //display track
    public List<Track> displaySavedTrack() throws TrackNotFoundException;

    //update comments
    public Track updateComments(int id,Track track) throws TrackNotFoundException;

    //remove  track
    public Optional<Track> removeTrack(int trackId) throws TrackNotFoundException;

    //search trackByName
    public Track trackByName(String trackName) throws TrackNotFoundException;


}
