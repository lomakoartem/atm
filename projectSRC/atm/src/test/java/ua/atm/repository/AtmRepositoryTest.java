package ua.atm.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ua.atm.repository.atmRepository.AtmRepository;
import ua.atm.domain.atm.AtmLocation;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by a.lomako on 2/24/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:applicationContext.xml",
        "classpath*:repositoryContext.xml",
        "classpath*:mailContext.xml",
       })
/*
@ContextConfiguration(locations = {"classpath:repositoryContext.xml", "classpath:applicationContext.xml"})*/
/*@ContextConfiguration(locations = {"classpath:applicationContext.xml"})*/
@WebAppConfiguration
public class AtmRepositoryTest {

    @Autowired
        AtmRepository atmRepository;
           @Test
            public void shouldFetchDatafromRemoteApi() throws Exception {
            List<AtmLocation> dataFromInG = atmRepository.getDataList();
            assertNotNull(dataFromInG);
            assertEquals(dataFromInG.size(), 1574);
        }

    }
