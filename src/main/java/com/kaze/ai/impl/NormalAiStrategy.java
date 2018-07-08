package com.kaze.ai.impl;

import com.kaze.Game;
import com.kaze.ai.AiStrategy;
import com.kaze.models.Gesture;

import java.security.SecureRandom;

/**
 * Normal random
 */
public class NormalAiStrategy implements AiStrategy {
    @Override
    public Gesture getGesture(Gesture humanGesture) {
            return Game.GESTURES.get(new SecureRandom().nextInt(3));
    }
}