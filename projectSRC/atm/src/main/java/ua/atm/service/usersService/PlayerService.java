package ua.atm.service.usersService;

import ua.atm.domain.users.User;

/**
 * Created by a.lomako on 1/30/2017.
 */

public interface PlayerService {

    /**
     * Get user by id from database.
     * @param id
     * @return user
     */
    User findUserById(Long id);

    /**
     * Get user by login from database.
     * @param player_login
     * @return user
     */
    Long getUserByLogin(String player_login);

    /**
     * Add user to db.
     * @param user
     * @return added user
     */
    User addUser(User user);

    /**
     * Find all users in db.
     * @return all users in db
     */
    Iterable<User> findAll();

    /**
     * Generates new password for user and send it by mail.
     * @param id
     * @return boolean value of result
     */
    boolean generatePasswordAndSendByMail(Long id);

    /**
     * Generates new password for user and save it in database.
     * @param id
     * @return password
     */
    char[] generatePasswordAndSaveInDatabase(Long id);

    /**
     * Sends given password to user by mail
     * @param id
     * @param password
     * @return boolean value of result
     */
    boolean sendPasswordByMail(Long id, char[] password);

    /**
     * Get user by email from database.
     * @param email
     * @return user
     */
    User getUserByEmail(String email);

    /**
     * Updates user in db.
     * @param user
     * @return updated user
     */
    User updateUser(User user);

    /**
     * Deletes user from database/
     * @param id
     */
    void deleteUser(Long id);
}
