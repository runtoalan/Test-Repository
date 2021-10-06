package com.forensic.api.model;

import org.springframework.stereotype.Component;


/**
 * Direction DTO (Data Transfer Object) Class
 * This class literally contains the String values of direction, latitude & longitude
 * And its corresponding getters and setters.
 * Also have the return of toString.
 * @author mamallan.chidambaram
 */
@Component
public class DirectionDto {
    private String direction;
    private String latitude;
    private String longitude;

    /**
     * DirectionDto Constructor
     */
    public DirectionDto(){

    }

    /**
     * DirectionDto Constructor
     */
    public DirectionDto(String direction, String latitude, String longitude) {
        this.direction = direction;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Get method for Direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Set method for Direction
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Get method for latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Set method for latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * Get method for longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Set method for longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     *ToString method returns DirectionDto object
     * with direction, latitude and longitude
     * @return String
     */
    @Override
    public String toString() {
        return "DirectionDto{" +
                "direction='" + direction + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
