package ua.atm.service.usersService;

import ua.atm.domain.users.Role;

/**
 * Created by a.lomako on 2/1/2017.
 */
public interface RoleService {
    /**
     * Get role from database.
     * @param id
     * @return role
     */
    Role getRole(Long id);
}
