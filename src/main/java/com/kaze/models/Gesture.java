package com.kaze.models;

public enum Gesture {
    ROCK("r"),
    PAPER("p"),
    SCISSOR("s");

    private String value;

    Gesture(String value)
    {
        this.value = value;
    }


    public static Gesture fromShortcut(String text) {
        for (Gesture gesture : Gesture.values()) {
            if (gesture.value.equalsIgnoreCase(text)) {
                return gesture;
            }
        }
        return null;
    }

}
