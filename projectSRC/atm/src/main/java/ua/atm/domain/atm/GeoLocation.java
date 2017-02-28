package ua.atm.domain.atm;

/**
 * Created by a.lomako on 2/22/2017.
 * Represents ATM geographic location on the map.
 */

public class GeoLocation {

    /**
     *  Represents a Latitude of ATM location
     */
    private String lat;

    /**
     * Represents a Longitude of ATM location
     */
    private String lng;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }


    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
