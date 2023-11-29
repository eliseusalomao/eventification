package com.eventification.eventification.exceptions;

public class TitleLengthIsntEnough extends Exception {
    public TitleLengthIsntEnough() {
        super("Title length must be at lest 7 characters.");
    }
}
