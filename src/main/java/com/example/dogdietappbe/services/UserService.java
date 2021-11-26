package com.example.dogdietappbe.services;

import com.example.dogdietappbe.models.User;

import java.util.List;
public interface UserService
{
    /**
     * Returns a list of all the Users
     *
     * @return List of Users. If no users, empty list.
     */
    User save(User user) throws Exception;

    /**
     * Update user.
     *
     * @param user the user
     * @return the user
     */
    /**
     * Delete all users.
     */
    void deleteAllUsers();

    /**
     * Find user by id user.
     *
     * @param userid the userid
     * @return the user
     */
    User findUserById(long userid);

    /**
     * Find all users list.
     *
     * @return the list
     */
    List<User> findAllUsers();

    /**
     * Find users by username like list.
     *
     * @param username the username
     * @return the list
     */
    List<User> findUsersByUsernameLike(String username);


    /**
     * Updates the provided fields in the user record referenced by the primary key.
     * <p>
     * Regarding Role and Useremail items, this process only allows adding those. Deleting and editing those lists
     * is done through a separate endpoint.
     *
     * @param user just the user fields to be updated.
     * @param id   The primary key (long) of the user to update
     * @return the complete user object that got updated
     */

    User findUserByUsername(String username);
    /**
     * Deletes all record and their associated records from the database
     */

}