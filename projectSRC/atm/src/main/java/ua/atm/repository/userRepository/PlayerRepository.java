package ua.atm.repository.userRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.atm.domain.users.User;

/**
 * Created by a.lomako on 1/30/2017.
 */
@Repository

public interface PlayerRepository extends CrudRepository<User, Long> {

    /**
     * Get user from database by user login.
     * @param user_login
     * @return user
     */
    @Query(nativeQuery = true, value = "SELECT  u.user_id FROM Users u WHERE u.user_login = :user_login")
    Long getUserByLogin(@Param("user_login") String user_login);

    /**
     * Get user from database by user email.
     * @param user_email
     * @return
     */
    @Query(nativeQuery = true, value = "SELECT  u.user_id FROM Users u WHERE u.user_email = :user_email")
    Long getUserByEmail(@Param("user_email") String user_email);
}
