package ua.atm.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.atm.domain.users.Role;
import ua.atm.domain.users.User;
import ua.atm.repository.userRepository.PlayerRepository;
import ua.atm.repository.userRepository.RoleRepository;
import javax.sql.DataSource;
import static org.junit.Assert.assertNotNull;

/**
 * Created by a.lomako on 2/24/2017.
 */@ContextConfiguration(locations = {"classpath:repositoryH2Context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;


    @Autowired
    RoleRepository roleRepository;

    @Autowired
    DataSource dataSource;


    @Before

    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Role role = new Role();
        role.setId(1L);
        role.setName("Admin");
        System.out.println(role);
        User user = new User();
        user.setId(1L);
        user.setUser_first_name("aaaa");
        user.setUser_login("asdasd");
        user.setEmail("sadasd@asdfas.dasda");
        user.setUser_password("asdasda");
        user.setRole(role);
        playerRepository.save(user);
    }

    @Test
    public void testGetUserByEmail() {
        assertNotNull( playerRepository.getUserByEmail("sadasd@asdfas.dasda"));
    }
    @Test
    public void testGetUserByLogin() {
        assertNotNull( playerRepository.getUserByLogin("asdasd"));
    }

}