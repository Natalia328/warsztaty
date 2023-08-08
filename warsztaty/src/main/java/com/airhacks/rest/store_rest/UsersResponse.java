package com.airhacks.rest.store_rest;

import com.airhacks.rest.LecturerDTO;

import java.util.Collection;

public class UsersResponse {

    private Collection<UserDTO> users;

    public Collection<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserDTO> users) {
        this.users = users;
    }
}
