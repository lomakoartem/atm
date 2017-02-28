package ua.atm.service.atmService;

import ua.atm.domain.atm.AtmLocation;

import java.util.List;

/**
 * Created by a.lomako on 2/22/2017.
 */
public interface AtmService {
    /**
     * Get List of all location from remote api
     * @return list of all location parsed from JSON
     * @throws Exception
     */
    List<AtmLocation> getAtmLocations() throws Exception;

    /**
     * Get List of all location from remote api by city
     * @param city
     * @return concrete location by city
     * @throws Exception
     */
    List<AtmLocation> getAtmLocationsByCity(String city) throws Exception;
}
