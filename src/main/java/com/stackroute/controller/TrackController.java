package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1")
public class TrackController {

    @Autowired
//    @Qualifier("trackDummyServiceImpl")
    private TrackService trackService;

    ResponseEntity responseEntity;
//    public TrackController(TrackService trackService){
//        this.trackService=trackService;
//    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException{
        trackService.saveTrack(track);
        responseEntity = new ResponseEntity("Successfully created", HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("track")
    public ResponseEntity<?> displaySavedTrack() throws TrackNotFoundException {
        responseEntity= new ResponseEntity(trackService.displaySavedTrack(),HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/track/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeTrack(@PathVariable Integer id) throws TrackNotFoundException {
            trackService.removeTrack(id);
            responseEntity= new ResponseEntity("Successfully removed",HttpStatus.OK);
            return responseEntity;
    }

    @RequestMapping(value = "/track/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateComments(@RequestBody Track track, @PathVariable int id) throws TrackNotFoundException {
            responseEntity= new ResponseEntity("Successfully updated",HttpStatus.OK);
        return responseEntity;

    }

//    @GetMapping("/track/{trackName}")
//    public ResponseEntity<?> trackByName(@PathVariable String trackName) throws TrackNotFoundException {
//
//        return new ResponseEntity(trackService.trackByName(trackName),HttpStatus.OK);
//
//    }
}
