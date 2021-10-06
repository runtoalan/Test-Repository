package com.forensic.api.model;

/**
 * Location DTO (Data Transfer Object) Class
 * This class literally contains the String values of direction, agentName & phone
 * And its corresponding getters and setters.
 * Also have the return of toString.
 * @author mamallan.chidambaram
 */
public class LocationDto {
    private String direction;
    private String agentName;
    private String phone;

    /**
     * LocationDto constructor
     * @param direction
     * @param agentName
     * @param phone
     */
    public LocationDto(String direction, String agentName, String phone) {
        this.direction = direction;
        this.agentName = agentName;
        this.phone = phone;
    }

    /**
     * Get method for Direction
     * @return String
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Set method for Direction
     * @param direction
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Get method for AgentName
     * @return String
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * Set method for AgentName
     * @param agentName
     */
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    /**
     * Get method for phone
     * @return String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set method for phone
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *ToString method returns LocationDto object
     * with direction, agentName and phone
     * @return String
     */
    @Override
    public String toString() {
        return "LocationDto{" +
                "direction='" + direction + '\'' +
                ", agentName='" + agentName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
