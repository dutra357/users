package com.api.users.DataTransfer;

import com.api.users.Entities.UserEntity;
import com.api.users.Enuns.Role;

public class UserDto {

    private Long id;
    private String email;
    private String name;
    private Role role;

    public UserDto(){}
    public UserDto(UserEntity user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.role = user.getRole();
    }
    public UserDto(Long id, String email, String name, Role role) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
