package ru.innopolis.etupitsyn.dao;

import java.io.Serializable;

/**
 * Created by evgeniytupitsyn on 22.11.2016.
 */
public class User implements Serializable {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private long cityId;
    private int rate;
    private long roleId;
    private boolean lock;

    public User(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.cityId = builder.cityId;
        this.rate = builder.rate;
        this.roleId = builder.roleId;
        this.lock = builder.lock;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public long getCityId() {
        return cityId;
    }

    public int getRate() {
        return rate;
    }

    public long getRoleId() {
        return roleId;
    }

    public boolean isLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cityId=" + cityId +
                ", rate=" + rate +
                ", roleId=" + roleId +
                ", lock=" + lock +
                '}';
    }

    public static class Builder {
        private long id;
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private long cityId;
        private int rate;
        private long roleId;
        private boolean lock;

        public Builder() {

        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }
    }

}
