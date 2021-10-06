package com.forensic.api.controller;

import com.forensic.api.service.ForensicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller class for Forensic
 * @author mamallan.chidambaram
 */
@RestController
@RequestMapping("/api")
public class ForensicController{

    private Logger logger = LoggerFactory.getLogger(ForensicController.class);

    @Autowired
    ForensicService forensicService;

    /**
     * getDirections method which will return the directions along with Latitude and Longitude
     * @param emailId
     * @return
     */
    @GetMapping("{emailId}/directions")
    public ResponseEntity<?> getDirections(@PathVariable (required = true) String emailId){
        logger.info("ForensicController::getDirections()");
        ResponseEntity<?> directionDetails = forensicService.getDirections(emailId);

        return new ResponseEntity<>(directionDetails, HttpStatus.OK);
    }

    /**
     * getSearchParties method which will return the search parties
     * @param emailId
     * @param x coordinate
     * @param y coordinate
     * @return
     */
    @GetMapping("{emailId}/location/{x}/{y}")
    public ResponseEntity<?> getSearchParties(@PathVariable (required = true) String emailId, @PathVariable String x,
                                              @PathVariable String y){
        logger.info("ForensicController::getSearchParties()");
        ResponseEntity<?> searchDetails = forensicService.getSearchParties(emailId);

        return new ResponseEntity<>(searchDetails, HttpStatus.OK);
    }
}
