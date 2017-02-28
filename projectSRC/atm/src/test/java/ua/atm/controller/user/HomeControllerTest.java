package ua.atm.controller.user;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.View;
import ua.atm.controller.userSecure.HomeController;
import ua.atm.repository.userRepository.PlayerRepository;
import ua.atm.service.usersService.PlayerService;

import static junit.framework.TestCase.assertEquals;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by a.lomako on 2/23/2017.
 */
public class HomeControllerTest {

    @InjectMocks
     HomeController controller;
    MockMvc mockMvc;
    @Mock
    PlayerService userService;
    @Mock
    PlayerRepository playerRepository;
    @Mock

    View mockView;


    @Before

    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        mockMvc = standaloneSetup(controller)
                        .setSingleView(mockView)
                        .build();
        MockitoAnnotations.initMocks(this);

    }

    /*
    @Test
    public void testSomething(){
        ModelAndView returnValue = homeController.getUserList();
        verify(model, times(1)).addAttribute("msg", "SUCCESS");
        assertEquals("hello", returnValue);
    }*/
/*
    @Test
    public void getNewView() throws Exception {
        List<User> expectedPeople = asList(new User());

        this.mockMvc.perform(get("/getPlayerInfo"))
                .andExpect(status().isOk())
                .andExpect(view().name("info/UserDetail"));

    }
*/


}
