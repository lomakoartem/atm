package ua.atm.controller.dto.domain.atmDTO;

/**
 * Created by a.lomako on 2/27/2017.
 */
public class AtmDTO {
    public static class AtmLocations{
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

        @Override
        public String  toString() {
            return "AtmLocations{" +
                    "street='" + street + '\'' +
                    ", housenumber='" + housenumber + '\'' +
                    ", postalcode='" + postalcode + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }
    /**
     * type of ATM
     */
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AtmDTO{" +
                "type='" + type + '\'' +
                '}';
    }
}
