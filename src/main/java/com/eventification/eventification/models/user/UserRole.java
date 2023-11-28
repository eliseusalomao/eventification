package com.eventification.eventification.models.user;

public enum UserRole {

    MC("MC"),
    PARTICIPANT("PARTICIPANT");

    private final String role;

    UserRole(final String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }
}
