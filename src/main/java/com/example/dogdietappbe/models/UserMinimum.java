package com.example.dogdietappbe.models;

public class UserMinimum {
    private String username;

    private String email;

    /**
     * The user's password (String)
     */
    private String password;

    public UserMinimum() {
    }



    /**
     * Getter for the username
     *
     * @return the username (String) associated with this user
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Setter for the username
     *
     * @param username the new username (String) associated with this user
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * Getter for the password of this user
     *
     * @return the password (String) for this user
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Setter for the password of this user. This object is a temporary model used to create a new user.
     * The password must remain in clear text until saved into the database.
     *
     * @param password the new password (String in clear texts) for this user
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}




