package com.kaze.models;

public enum Command
{
    START("interact"),
    EXIT("exit"),
    STATS("stat"),
    ERROR("error");

    private String value;
    Command(String value)
    {
        this.value = value;
    }
}
