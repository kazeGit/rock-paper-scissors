package com.kaze.ai.impl;


import com.kaze.ai.AiStrategy;
import com.kaze.models.Gesture;
import com.kaze.strategy.RuleStrategy;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Markov's chains should used here, but short in time
 */
public class HardAiStrategy implements AiStrategy {
    @Override
    public Gesture getGesture(Gesture humanGesture) {
        final Pair<Gesture, Gesture> gesturePair = RuleStrategy.WIN_PAIRS.stream()
                // we know it is there, get is safe
                .filter(pair -> pair.getRight().equals(humanGesture)).findFirst().get();
        return gesturePair.getLeft();
    }
}
