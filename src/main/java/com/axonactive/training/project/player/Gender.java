package com.axonactive.training.project.player;

public enum Gender {
    UNKNOWN(-1),
    FEMALE(0),
    MALE(1);

    private int value;

    Gender(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}