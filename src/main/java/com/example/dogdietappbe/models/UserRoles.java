package com.example.dogdietappbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "userroles")
@IdClass(UserRolesId.class)
public class UserRoles implements Serializable {


    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "roles",
            allowSetters = true)
    private User user;

    /**
     * 1/2 of the primary key (long) for userroles.
     * Also is a foreign key into the roles table
     */
    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "roleid")
    @JsonIgnoreProperties(value = "users",
            allowSetters = true)
    private Role role;

    /**
     * Default constructor used primarily by the JPA.
     */
    public UserRoles() {
    }

    /**
     * Given the params, create a new user role combination object
     *
     * @param user The user object of this relationship
     * @param role The role object of this relationship
     */
    public UserRoles(
            User user,
            Role role) {
        this.user = user;
        this.role = role;
    }

    /**
     * The getter for User
     *
     * @return the complete user object associated with user role combination
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter for user
     *
     * @param user change the user object associated with this user role combination to this one.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Getter for role
     *
     * @return the complete role object associated with this user role combination
     */
    public Role getRole() {
        return role;
    }

    /**
     * Setter for role
     *
     * @param role change role object associated with this user role combination to this one.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserRoles)) {
            return false;
        }
        UserRoles that = (UserRoles) o;
        return ((user == null) ? 0 : user.getUserid()) == ((that.user == null) ? 0 : that.user.getUserid()) &&
                ((role == null) ? 0 : role.getRoleid()) == ((that.role == null) ? 0 : that.role.getRoleid());
    }

    @Override
    public int hashCode() {
        // return Objects.hash(user.getUserid(), role.getRoleid());
        return 37;
    }
}