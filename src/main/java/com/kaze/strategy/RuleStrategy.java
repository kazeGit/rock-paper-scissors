package com.kaze.strategy;

import com.kaze.models.Gesture;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class RuleStrategy
{
    // Here we store only win conditions pairs, left wins right
    public static List<Pair<Gesture, Gesture>> WIN_PAIRS = new ArrayList<Pair<Gesture, Gesture>>()
    {{
        add(new ImmutablePair<>(Gesture.PAPER, Gesture.ROCK));
        add(new ImmutablePair<>(Gesture.ROCK, Gesture.SCISSOR));
        add(new ImmutablePair<>(Gesture.SCISSOR, Gesture.PAPER));
    }};

    public static boolean isDraw(Gesture humanGesture, Gesture ai) {
        return humanGesture.equals(ai);
    }

    public static boolean isHumanWin(Gesture humanGesture, Gesture ai) {
        return WIN_PAIRS.contains(new ImmutablePair<>(humanGesture, ai));
    }
}
