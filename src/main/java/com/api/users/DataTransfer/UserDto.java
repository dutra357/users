package com.api.users.DataTransfer;

import com.api.users.Entities.Address;
import com.api.users.Entities.UserEntity;
import com.api.users.Enuns.Role;

import java.util.List;
import java.util.UUID;

public class UserDto {

    private UUID id;
    private String email;
    private String name;
    private List<Address> addresses;
    private Role role;

    public UserDto(){}
    public UserDto(UserEntity user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.role = user.getRole();
        this.addresses = user.getAddresses();
    }
    public UserDto(UUID id, String email, String name, Role role) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
