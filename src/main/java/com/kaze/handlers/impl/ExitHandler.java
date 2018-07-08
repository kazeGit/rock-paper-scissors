package com.kaze.handlers.impl;

import com.kaze.Game;
import com.kaze.handlers.Handler;

public class ExitHandler implements Handler {
    public void perform() {
        Game.tellToUser("Bye-Bye");
        System.exit(0);
    }
}
