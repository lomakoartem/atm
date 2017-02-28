package ua.atm.repository.atmRepository;

import ua.atm.domain.atm.AtmLocation;

import java.util.List;

/**
 * Created by a.lomako on 2/22/2017.
 */
public interface AtmRepository {
    /**
     * Get json from remote API and add it in List of ATM locations
     * @return List of locations
     * @throws Exception
     */
    List<AtmLocation> getDataList() throws Exception;
}
