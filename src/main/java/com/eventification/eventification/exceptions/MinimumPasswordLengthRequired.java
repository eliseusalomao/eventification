package com.eventification.eventification.exceptions;

public class MinimumPasswordLengthRequired extends Exception {
    public MinimumPasswordLengthRequired() {
        super("Minimum length of 7 characters needed in password");
    }
}
