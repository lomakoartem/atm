package ua.atm.domain.users;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by a.lomako on 2/1/2017.
 * Represents a user role .
 */
@Entity
@Table(name = "role")
public class Role {
    /**
     *  role id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * role name
     */
    private String name;

    /**
     * Relation table user - role
     */
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")}
    )
    private Set<User> userRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<User> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<User> userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return name;
    }
}