package com.kaze.ai;

import com.kaze.models.Gesture;

public interface AiStrategy {
    public Gesture getGesture(Gesture humanGesture);
}
