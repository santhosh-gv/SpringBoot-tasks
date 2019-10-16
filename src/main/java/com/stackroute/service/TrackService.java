package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    // save track
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    //display track
    public List<Track> displaySavedTrack();

    //update comments
    public Track updateComments(int id,Track track);

    //remove  track
    public void removeTrack(int trackId) throws TrackNotFoundException;

    //search trackByName
    public Track trackByName(String trackName) throws TrackNotFoundException;


}
