package ua.atm.controller.atmControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.atm.domain.atm.AtmLocation;
import ua.atm.domain.atm.ResponseObject;
import ua.atm.service.atmService.AtmService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by a.lomako on 2/22/2017.
 */
@RestController
public class AtmController {

    @Autowired
    private AtmService atmService;

    /**
     * Gets all ATM locations from remote api and returns well formed JSON.
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/locations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ResponseObject getATMLocations() throws Exception {
        ResponseObject<AtmLocation> responseObject = new ResponseObject<>();
        responseObject.setList(atmService.getAtmLocations());
        return responseObject;

    }

    /**
     *  Gets   ATM locations by city from remote api and returns well formed JSON.
     * @param city
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/locations/{city}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ResponseObject getATMLocationsByCity(@PathVariable("city") String city) throws Exception {
        ResponseObject<AtmLocation> responseObject = new ResponseObject<>();
        responseObject.setList(atmService.getAtmLocationsByCity(city));
        return responseObject;

    }

    /**
     * Gets selected ATM locations by city from remote api and puts it on map.
     * @param city
     * @param model
     * @return model and view
     * @throws Exception
     */
    @RequestMapping(value = "/getatmsonmap/{city}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ModelAndView getATMLocationsByCityAndViewInMap(@PathVariable("city") String city, ModelMap model) throws Exception {
        model.addAttribute("city", city);
        ResponseObject<AtmLocation> responseObject = new ResponseObject<>();
        responseObject.setList(atmService.getAtmLocationsByCity(city));
        List addresses = responseObject.getList();
        addresses.get(0);
        System.out.println(addresses.toString());
        model.addAttribute("addresses", addresses);
        return new ModelAndView("atm/getAtmsOnMap", model);

    }

    /**
     * Gets  ATM locations from remote api and puts it model.
     * @return  model and view
     * @throws Exception
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getDefault() throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("atmLocations", atmService.getAtmLocations());
        return new ModelAndView("atm/viewAtms", model);
    }
}
