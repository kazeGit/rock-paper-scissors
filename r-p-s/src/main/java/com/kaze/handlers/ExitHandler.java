package com.kaze.handlers;

import com.kaze.Game;

public class ExitHandler implements Handler {

    public void perform() {
        Game.tellToUser("Bye-Bye");
        System.exit(0);
    }
}
