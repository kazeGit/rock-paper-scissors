package com.kaze.models;

public enum Move
{
    ROCK("r"),
    PAPER("p"),
    SCISSOR("s");

    private String value;

    Move(String value)
    {
        this.value = value;
    }
}
