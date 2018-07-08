package com.kaze.handlers.impl;

import com.kaze.Game;
import com.kaze.handlers.Handler;
import com.kaze.models.Difficulty;
import org.apache.commons.lang3.EnumUtils;

import static com.kaze.Game.DIFFUCULTIES;

public class DifficultyHandler implements Handler {

    public void perform() {
        Game.tellToUser(
            new StringBuilder()
            .append("Please change game difficulty: ")
            .append(DIFFUCULTIES)
            .append(" by default it is ")
            .append(Game.getGameDifficulty()).toString());

        changeDifficulty();
    }

    private void changeDifficulty() {
        final String message = Game.interact().toUpperCase();

        if (EnumUtils.isValidEnum(Difficulty.class, message)) {
            Game.setGameDifficulty(Difficulty.valueOf(message));
        } else {
            Game.tellToUser("Sorry, try again");
            changeDifficulty();
        }
    }
}
