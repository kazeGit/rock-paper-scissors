package com.kaze.handlers.impl;

import com.kaze.Game;
import com.kaze.handlers.Handler;

public class ErrorHandler implements Handler {
    public void perform() {
        Game.tellToUser("Sorry I don't know such command");
    }
}
