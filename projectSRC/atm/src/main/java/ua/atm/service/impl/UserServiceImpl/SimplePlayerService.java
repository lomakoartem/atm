package ua.atm.service.impl.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.atm.domain.users.User;
import ua.atm.infrastructure.passwordGenerateAndHash.PasswordGenerator;
import ua.atm.infrastructure.passwordGenerateAndHash.PasswordHash;
import ua.atm.repository.userRepository.PlayerRepository;
import ua.atm.repository.userRepository.RoleRepository;
import ua.atm.service.usersService.PlayerService;


/**
 * Created by a.lomako on 1/30/2017.
 */
@Service
public class SimplePlayerService implements PlayerService {

    private static final Logger LOG = LoggerFactory.getLogger(SimplePlayerService.class);
    @Autowired
    public RoleRepository roleRepository;
    @Autowired
    private PlayerRepository playerRepository;
    private SimpleMailMessage templateMessage;

    private MailSender mailSender;

    @Autowired
    public SimplePlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Autowired
    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }


    @Autowired
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Get user by id from database.
     *
     * @param id
     * @return user
     */
    @Override
    public User findUserById(Long id) {
        User user = playerRepository.findOne(id);

     /*   if (user == null) {
            throw new EntityNotFoundException(id);
        }*/

        return user;
    }

    /**
     * Get user by email from database.
     *
     * @param email
     * @return user
     */
    @Override
    public User getUserByEmail(String email) {
        User user;

        try {
            user = playerRepository.findOne(playerRepository.getUserByEmail(email));
        } catch (Exception e) {
            throw new UsernameNotFoundException("Error in retrieving user");
        }
        return user;
    }

    /**
     * Find all users in db.
     *
     * @return all users in db
     */
    @Override
    public Iterable<User> findAll() {
        return playerRepository.findAll();
    }

    /**
     * Get user by login from database.
     *
     * @param player_login
     * @return user
     */
    @Override
    public Long getUserByLogin(String player_login) {
        return playerRepository.getUserByLogin(player_login);
    }

    /**
     * Add user to db.
     *
     * @param user
     * @return added user
     */
    @Override
    public User addUser(User user) {

        user.setUser_password(PasswordHash.hash(user.getUser_password().toCharArray()));

        user.setRole(roleRepository.findOne((long) 2));
        System.out.println(user.toString() + "Ya v metode servisa");
        return playerRepository.save(user);
    }

    /**
     * Generates new password for user and send it by mail.
     *
     * @param id
     * @return boolean value of result
     */
    @Override
    public boolean generatePasswordAndSendByMail(Long id) {

        char[] password = PasswordGenerator.generatePswd();
        if (sendPasswordByMail(id, password)) {
            savePlayerPassword(id, PasswordHash.hash(password));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Generates new password for user and save it in database.
     *
     * @param id
     * @return password
     */
    @Override
    public char[] generatePasswordAndSaveInDatabase(Long id) {

        char[] password = PasswordGenerator.generatePswd();

        savePlayerPassword(id, PasswordHash.hash(password));

        return password;
    }

    /**
     * Sends given password to user by mail
     *
     * @param id
     * @param password
     * @return boolean value of result
     */
    @Override
    public boolean sendPasswordByMail(Long id, char[] password) {
        SimpleMailMessage msg = generateEmailMessage(id, password);
        return sendMail(msg);
    }

    private boolean sendMail(SimpleMailMessage msg) {
        try {
            this.mailSender.send(msg);
        } catch (MailException ex) {
            LOG.warn(ex.getMessage());
            return false;
        }

        return true;
    }

    private SimpleMailMessage generateEmailMessage(Long id, char[] password) {
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        User user = findUserById(id);
        msg.setTo(user.getEmail());
        msg.setText(String.format(msg.getText(), user.getEmail(), new String(password)));
        return msg;
    }

    /**
     * Deletes user from database/
     *
     * @param id
     */
    //Check write, conditions and so on :)
    @Override
    public void deleteUser(Long id) {
        playerRepository.delete(id);
    }

    /**
     * Updates user in db.
     *
     * @param user
     * @return updated user
     */
    @Override
    public User updateUser(User user) {
        user.setRole(roleRepository.findOne(user.getRole().getId()));
        return playerRepository.save(user);
    }

    private void savePlayerPassword(Long id, String password) {

        User user = findUserById(id);

        if (user != null) {
            user.setUser_password(password);
            playerRepository.save(user);
        } else
            System.out.println("No such email in db");
    }
}
