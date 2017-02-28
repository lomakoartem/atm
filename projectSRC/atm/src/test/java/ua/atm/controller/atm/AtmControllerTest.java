package ua.atm.controller.atm;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import ua.atm.controller.atmControllers.AtmController;
import ua.atm.domain.atm.Address;
import ua.atm.domain.atm.AtmLocation;
import ua.atm.domain.atm.ResponseObject;
import ua.atm.repository.atmRepository.AtmRepository;
import ua.atm.service.atmService.AtmService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by a.lomako on 2/23/2017.
 */
public class AtmControllerTest {

    @InjectMocks

    AtmController atmController;
/*
    @Mock
    private MockMvc mockMvc;*/

    @Mock
    AtmRepository atmRepository;

    @Mock
    AtmService atmService;

    @Mock
    Model model;
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
  /*  @Test
    public void testGetAllATMLocationsfromING() throws Exception {


        when(atmService.getAtmLocationsfromINGByCity(Mockito.anyString())).thenReturn(atmLocationList);
        ResponseObject locationsfromINGByCity = atmController.getDefault("ANY_CITY");
        assertEquals(locationsfromINGByCity.getList().size(), 2);
    }*/
    @Test
    public void testGetATMLocationsfromING() throws Exception {
        when(atmRepository.getDataList()).thenReturn(atmLocationList);
        ResponseObject atmLocationsfromING = atmController.getATMLocations();
        assertEquals(atmLocationsfromING.getList().size(), 0);
    }
    @Test
    public void testGetATMLocationsfromINGByCity() throws Exception {
        when(atmService.getAtmLocationsByCity(Mockito.anyString())).thenReturn(atmLocationList);
        ResponseObject locationsfromINGByCity = atmController.getATMLocationsByCity("ANY_CITY");
        assertEquals(locationsfromINGByCity.getList().size(), 2);
    }

}

