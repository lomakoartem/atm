package ua.atm.service.impl.ATMServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.atm.domain.atm.AtmLocation;
import ua.atm.repository.atmRepository.AtmRepository;
import ua.atm.service.atmService.AtmService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a.lomako on 2/22/2017.
 */
@Service
public class AtmServiceImpl implements AtmService {

    /**
     * inject atm repository
     */
    @Autowired
    AtmRepository atmRepository;

    /**
     * Get List of all location from remote api
     *
     * @return list of all location parsed from JSON
     * @throws Exception
     */
    @Override
    public List<AtmLocation> getAtmLocations() throws Exception {
        return atmRepository.getDataList();
    }

    /**
     * Get List of all location from remote api by city
     *
     * @param city
     * @return concrete location by city
     * @throws Exception
     */
    @Override
    public List<AtmLocation> getAtmLocationsByCity(String city) throws Exception {
        List<AtmLocation> locations = new ArrayList<>();

        List<AtmLocation> atmLocations = getAtmLocations();

        for (AtmLocation location : atmLocations) {

            if (city.equalsIgnoreCase(location.getAddress().getCity())) {

                locations.add(location);
            }

        }
        return locations;

    }
}
