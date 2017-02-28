package ua.atm.service.user;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.atm.domain.users.Role;
import ua.atm.domain.users.User;
import ua.atm.repository.userRepository.PlayerRepository;
import ua.atm.service.usersService.PlayerService;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by a.lomako on 2/23/2017.
 *//*@ContextConfiguration(locations = {
        "classpath*:applicationContext.xml",
        "classpath*:repositoryH2Context.xml",
        "classpath*:mailContext.xml"
       })
@RunWith(SpringJUnit4ClassRunner.class)*/
public class UserServiceTest {


    @Mock
    PlayerService playerService;

@Mock
PlayerRepository playerRepository;
/*
    User findUserById(Long id);

    Long getUserByLogin(String player_login);

    User addUser(User user);

    Iterable<User> findAll();

    boolean generatePasswordAndSendByMail(Long id);

    char[] generatePasswordAndSaveInDatabase(Long id);

    boolean sendPasswordByMail(Long id, char[] password);

    User getUserByEmail(String email);

    User updateUser(User user);

    void deleteUser(Long id);
*/
@Before
public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    Role role = new Role();
    role.setId(1L);
    role.setName("Admin");
    System.out.println(role);
    User user = new User();
    user.setId(1L);
    user.setUser_first_name("Artem");
    user.setUser_login("artem");
    user.setEmail("artem@artem.artem");
    user.setUser_password("artem");
    user.setRole(role);
    playerRepository.save(user);
  }

   /* @Test
    public void TestFindUserById() {
        User user = playerService.findUserById(1L);
        assertEquals(user
                .getUser_first_name(),"Artem");
    }
*/
   /* @Test
    public void updateUser() {
        playerRepository.findOne("A")
        assertThat(playerService.addUser());
    }

    @Test
    public void testfindUserById() {
        assertThat(playerRepository.findOne((long) 1), nullValue());
    }*/
}


