package ua.atm.domain.users;

import javax.persistence.*;

/**
 * Created by a.lomako on 1/30/2017.
 * Represents a user entity in database
 */
@Entity
@Table(name = "users")
public class User {
    /**
     * user id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    /**
     * user name
     */
    @Column(name = "user_first_name")
    private String user_first_name;

    /**
     * user login
     */
    @Column(name = "user_login")
    private String user_login;

    /**
     * user password
     */
    @Column(name = "user_password")
    private String user_password;

    /**
     * user email
     */
    @Column(name = "user_email")
    private String email;

    /**
     * user role
     */
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;

    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (user_first_name != null ? !user_first_name.equals(user.user_first_name) : user.user_first_name != null)
            return false;
        if (user_login != null ? !user_login.equals(user.user_login) : user.user_login != null) return false;
        if (user_password != null ? !user_password.equals(user.user_password) : user.user_password != null)
            return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return role != null ? role.equals(user.role) : user.role == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user_first_name != null ? user_first_name.hashCode() : 0);
        result = 31 * result + (user_login != null ? user_login.hashCode() : 0);
        result = 31 * result + (user_password != null ? user_password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_first_name='" + user_first_name + '\'' +
                ", user_login='" + user_login + '\'' +
                ", user_password='" + user_password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
    /* public String getUser_first_name() {
        return player_first_name;
    }

    public void setUser_first_name(String player_first_name) {
        this.player_first_name = player_first_name;
    }

    public String getPlayer_login() {
        return player_login;
    }

    public void setPlayer_login(String player_login) {
        this.player_login = player_login;
    }

    public String getPlayer_password() {
        return player_password;
    }

    public void setPlayer_password(String player_password) {
        this.player_password = player_password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

*/


 /*   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

                if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (player_login != null ? !player_login.equals(user.player_login) : user.player_login != null)
            return false;
        if (player_password != null ? !player_password.equals(user.player_password) : user.player_password != null)
            return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (player_login != null ? player_login.hashCode() : 0);
        result = 31 * result + (player_password != null ? player_password.hashCode() : 0);

        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", player_first_name='" + player_first_name + '\'' +
                ", player_login='" + player_login + '\'' +
                ", player_password='" + player_password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }*/
}
