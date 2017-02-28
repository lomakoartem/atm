package ua.atm.domain.atm;

/**
 * Created by a.lomako on 2/22/2017.
 * Represents a address of ATMs located in Dutch city.
 *
 */

public class Address {

    /**
     * Street where ATM located, obtained from json
     */
    private String street;

    /**
     * Housenumber of ATM obtained from json
     */
    private String housenumber;

    /**
     * Postalcode of ATM location obtained from json
     */
    private String postalcode;

    /**
     * City obtained from json
     */
    private String city;

    /**
     * geolocation obtained from json
     */
    private GeoLocation geoLocation;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }
}
