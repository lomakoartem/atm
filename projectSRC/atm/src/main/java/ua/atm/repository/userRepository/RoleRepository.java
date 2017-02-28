package ua.atm.repository.userRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.atm.domain.users.Role;

/**
 * Created by a.lomako on 2/1/2017.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
