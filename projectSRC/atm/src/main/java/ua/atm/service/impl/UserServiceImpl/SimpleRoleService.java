package ua.atm.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.atm.domain.users.Role;
import ua.atm.repository.userRepository.RoleRepository;
import ua.atm.service.usersService.RoleService;

/**
 * Created by a.lomako on 2/1/2017.
 */
@Service
public class SimpleRoleService implements RoleService {

    RoleRepository roleRepository;

    @Autowired
    public SimpleRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Get role from database.
     * @param id
     * @return role
     */
    @Override
    public Role getRole(Long id) {
        return roleRepository.findOne(id);
    }
}
