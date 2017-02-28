package ua.atm.service.atm;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.atm.domain.atm.Address;
import ua.atm.domain.atm.AtmLocation;
import ua.atm.repository.atmRepository.AtmRepository;
import ua.atm.service.impl.ATMServiceImpl.AtmServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by a.lomako on 2/24/2017.
 */
public class AtmServiceTest {
    @InjectMocks

    AtmServiceImpl atmService;

    @Mock

    AtmRepository atmRepository;

    private List<AtmLocation> atmLocationList;
    @Before

    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        atmLocationList = new ArrayList<>();
        AtmLocation atmLocation = new AtmLocation();
        Address address = new Address();
        address.setCity("GELDROP");
        address.setHousenumber("1");
        atmLocation.setAddress(address);
       AtmLocation atmLocation1 = new AtmLocation();
        Address address1 = new Address();
        address1.setHousenumber("2");
        address1.setCity("ROTTERDAM");
        atmLocation1.setAddress(address1);
        atmLocationList.add(atmLocation);
        atmLocationList.add(atmLocation1);
    }

    @Test
   public void testGetAtmLocationsfromING() throws Exception {
        when(atmRepository.getDataList()).thenReturn(atmLocationList);
        List<AtmLocation> atmLocations = atmService.getAtmLocations();
        assertEquals(atmLocations.size(), 2);
   }
    @Test
    public void testGetAtmLocationsfromINGByCity() throws Exception {
        when(atmRepository.getDataList()).thenReturn(atmLocationList);
        List<AtmLocation> atmLocationsfromINGByCity = atmService.getAtmLocationsByCity("GELDROP");
        assertEquals(atmLocationsfromINGByCity.size(), 1);

    }

}