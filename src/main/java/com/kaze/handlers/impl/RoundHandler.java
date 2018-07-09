package com.kaze.handlers.impl;

import com.kaze.Game;
import com.kaze.ai.AiStrategy;
import com.kaze.handlers.Handler;
import com.kaze.models.Gesture;
import com.kaze.models.Round;
import com.kaze.strategy.RuleStrategy;

public class RoundHandler implements Handler {

    public void perform() {
        Game.tellToUser("Make your move");

        round(new Round(1));
    }

    // TODO stats
    private void round(Round round) {
        Game.tellToUser("Round " + round.getNumber());
        final String message = Game.interact().toUpperCase();
        final Gesture gesture = Gesture.fromShortcut(message);

        if (gesture != null) {
            final AiStrategy currentAiStrategy = Game.getCurrentAiStrategy();
            final Gesture aiGesture = currentAiStrategy.getGesture(gesture, round);

            Game.tellToUser(String.format("Your gesture is %s, AI gesture is %s", gesture, aiGesture));

            if (RuleStrategy.isDraw(gesture, aiGesture)) {
                Game.tellToUser("Draw");
                round.nextRound();
                round(round);
            } else if (RuleStrategy.isHumanWin(gesture, aiGesture))
                Game.tellToUser("You win");
            else
                Game.tellToUser("You lose");
        } else {
            Game.tellToUser("Sorry, try again");
            round(round);
        }
    }
}
