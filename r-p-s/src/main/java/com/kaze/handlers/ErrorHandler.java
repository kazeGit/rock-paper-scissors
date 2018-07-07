package com.kaze.handlers;

import com.kaze.Game;

public class ErrorHandler implements Handler {
    public void perform() {
        Game.tellToUser("Sorry I don't know such command \n");
    }
}
