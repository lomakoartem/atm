package ua.atm.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.atm.domain.users.User;
import ua.atm.infrastructure.passwordGenerateAndHash.PasswordHash;
import ua.atm.repository.userRepository.PlayerRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by a.lomako on 2/1/2017.
 */

@Service
@Transactional(readOnly = true)
public class CustomPlayerDetailsService implements UserDetailsService {
    @Autowired
    private PlayerRepository playerRepository;

    /**
     *
     * @param roles
     * @return authorities
     */
    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return authorities;
    }

    /**
     * Gets user by username
     * @param login
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        try {

            User domainUser = playerRepository.findOne(playerRepository.getUserByLogin(login));
            boolean enabled = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;
            PasswordHash passwordHash;
            return new org.springframework.security.core.userdetails.User(
                    domainUser.getUser_login(),
                    domainUser.getUser_password(),
                    enabled,
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked,
                    getAuthorities(domainUser.getRole().getId())
            );
        } catch (Exception e) {
            throw new UsernameNotFoundException("Error in retrieving user");
        }
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Long role) {

        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));

        return authList;
    }

    /**
     * Gets List of available roles
     * @param role
     * @return list of roles
     */
    public List<String> getRoles(Long role) {

        List<String> roles = new ArrayList<>();

        if (role.intValue() == 1) {
            roles.add("ROLE_PLAYER");
            roles.add("ROLE_ADMIN");
        } else if (role.intValue() == 2) {
            roles.add("ROLE_PLAYER");
        }
        return roles;
    }

}


