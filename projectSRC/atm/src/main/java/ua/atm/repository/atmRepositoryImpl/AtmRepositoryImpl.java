package ua.atm.repository.atmRepositoryImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ua.atm.domain.atm.AtmLocation;
import ua.atm.repository.atmRepository.AtmRepository;
import org.apache.camel.builder.RouteBuilder;
import java.util.Arrays;
import java.util.List;

/**
 * Created by a.lomako on 2/22/2017.
 */
@Repository
public class AtmRepositoryImpl extends RouteBuilder
        implements AtmRepository   {
    /**
     * Logger
     */
    private Logger atmRepositoryLogger = LoggerFactory.getLogger(AtmRepositoryImpl.class);

    @Autowired
    private RestTemplate restTemplate;
    /**
     * Get json from remote API and add it in List of ATM locations
     * @return List of locations
     * @throws Exception
     */
    public List<AtmLocation> getDataList() throws Exception {
        String response = restTemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);

        atmRepositoryLogger.debug("Unnecessary data in JSON:" + "\n\n" + response.substring(0, 5) + "\n\n");
        String toBeParsed = response.substring(6, response.length());

        atmRepositoryLogger.debug("response:" + "\n\n" + toBeParsed + "\n\n");

        ObjectMapper objectMapper = new ObjectMapper();

        AtmLocation[] ingAtmLocations = objectMapper.readValue(toBeParsed, AtmLocation[].class);

        atmRepositoryLogger.debug("parsed response:" + "\n\n" + ingAtmLocations.toString() + "\n\n");

        return Arrays.asList(ingAtmLocations);

    }

    @Override
    public void configure() throws Exception {
        from("file://target/test?noop=true").beanRef("myProcessor", "process");
    }
}

