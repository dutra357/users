package com.api.users.Enuns;


public enum Role {
    ADMIN("admin"),
    PEDAGOGICO("pedagogico"),
    RECRUITER("recruiter"),
    PROFESSOR("professor"),
    ALUNO("aluno");


    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}