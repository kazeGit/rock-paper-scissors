package com.kaze.handlers.impl;

import com.kaze.Game;
import com.kaze.ai.AiStrategy;
import com.kaze.handlers.Handler;
import com.kaze.models.Gesture;
import com.kaze.strategy.RuleStrategy;

public class RoundHandler implements Handler {

    public void perform() {
        Game.tellToUser("Make your move");

        round();
    }

    private void round() {
        final String message = Game.interact().toUpperCase();
        final Gesture gesture = Gesture.fromShortcut(message);

        if (gesture != null) {
            final AiStrategy currentAiStrategy = Game.getCurrentAiStrategy();
            final Gesture aiGesture = currentAiStrategy.getGesture(gesture);

            Game.tellToUser(String.format("Your gesture is %s, AI gesture is %s", gesture, aiGesture));

            if (RuleStrategy.isDraw(gesture, aiGesture)) {  // TODO stats
                Game.tellToUser("Draw");
                return;
            }
            if (RuleStrategy.isHumanWin(gesture, aiGesture))
                Game.tellToUser("You win");
            else
                Game.tellToUser("You lose");
        } else {
            Game.tellToUser("Sorry, try again");
            round();
        }
    }
}
