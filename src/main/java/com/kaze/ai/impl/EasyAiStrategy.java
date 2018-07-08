package com.kaze.ai.impl;

import com.kaze.ai.AiStrategy;
import com.kaze.models.Gesture;
import com.kaze.strategy.RuleStrategy;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Human win strategy
 */
public class EasyAiStrategy implements AiStrategy {
    @Override
    public Gesture getGesture(Gesture humanGesture) {
        final Pair<Gesture, Gesture> gesturePair = RuleStrategy.WIN_PAIRS.stream()
                // we know it is there, get is safe
            .filter(pair -> pair.getLeft().equals(humanGesture)).findFirst().get();
        return gesturePair.getRight();
    }
}
