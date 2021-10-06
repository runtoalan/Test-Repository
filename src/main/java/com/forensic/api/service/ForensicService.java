package com.forensic.api.service;

import com.forensic.api.model.DirectionDto;
import com.forensic.api.model.LocationDto;
import com.forensic.api.utility.RequestThrottleFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Service class for Forensic
 * @author mamallan.chidambaram
 */
@Service
public class ForensicService {
    private Logger logger = LoggerFactory
            .getLogger(RequestThrottleFilter.class);

    /**
     * Get Directions method which will return ResponseEntity List (DirectionDto)
     * @param emailId
     * @return ResponseEntity
     */
    public ResponseEntity<?> getDirections(String emailId) {
        logger.info("ForensicService::getDirections()");

        List<DirectionDto> directionDtoList = new ArrayList<DirectionDto>();
        DirectionDto directionDto1 = new DirectionDto("North","50.44","-0.138");
        DirectionDto directionDto2 = new DirectionDto("South","50.41","-0.128");
        DirectionDto directionDto3 = new DirectionDto("West","50.33","-0.126");
        DirectionDto directionDto4 = new DirectionDto("East","50.22","-0.147");

        directionDtoList.add(directionDto1);
        directionDtoList.add(directionDto2);
        directionDtoList.add(directionDto3);
        directionDtoList.add(directionDto4);

        return new ResponseEntity<>(directionDtoList, HttpStatus.OK);
    }

    /**
     *Get Directions method which will return ResponseEntity List (LocationDto)
     * @param emailId
     * @return ResponseEntity
     */
    public ResponseEntity<?> getSearchParties(String emailId) {
        logger.info("ForensicService::getSearchParties()");

        List<LocationDto> locationDtoList = new ArrayList<LocationDto>();
        LocationDto locationDto1 = new LocationDto("North","People finder","2299883399");
        LocationDto locationDto2 = new LocationDto("South","Resource binder","7653987633");
        LocationDto locationDto3 = new LocationDto("West","Enrich","92754938648");
        LocationDto locationDto4 = new LocationDto("East","Orlando","9865783874");

        locationDtoList.add(locationDto1);
        locationDtoList.add(locationDto2);
        locationDtoList.add(locationDto3);
        locationDtoList.add(locationDto4);

        return new ResponseEntity<>(locationDtoList, HttpStatus.OK);
    }
}
