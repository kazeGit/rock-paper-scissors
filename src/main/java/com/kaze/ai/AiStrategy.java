package com.kaze.ai;

import com.kaze.models.Gesture;
import com.kaze.models.Round;

public interface AiStrategy {
    public Gesture getGesture(Gesture humanGesture, Round round);
}
