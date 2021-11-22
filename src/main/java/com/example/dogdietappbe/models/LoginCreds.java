package com.example.dogdietappbe.models;

public class LoginCreds {


        private String username;
        private String password;

        /**
         * Instantiates a new Login creds.
         */
        public LoginCreds()
        {
        }

        /**
         * Gets username.
         *
         * @return the username
         */
        public String getUsername()
        {
            return username;
        }

        /**
         * Sets username.
         *
         * @param username the username
         */
        public void setUsername(String username)
        {
            this.username = username;
        }

        /**
         * Gets password.
         *
         * @return the password
         */
        public String getPassword()
        {
            return password;
        }

        /**
         * Sets password.
         *
         * @param password the password
         */
        public void setPassword(String password)
        {
            this.password = password;
        }
    }
