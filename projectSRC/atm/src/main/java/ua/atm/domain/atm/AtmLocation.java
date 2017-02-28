package ua.atm.domain.atm;

/**
 * Created by a.lomako on 2/22/2017.
 * Represents  location of ATMs in Dutch city .
 */

public class AtmLocation {
    /**
     * address of ATM
     */
    private Address address;
    /**
     * distance to ATM
     */
    private Integer distance;

    /**
     * type of ATM
     */
    private String type;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AtmLocation{" +
                "address=" + address +
                ", distance=" + distance +
                ", type='" + type + '\'' +
                '}';
    }
}

