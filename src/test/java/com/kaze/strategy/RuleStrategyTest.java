package com.kaze.strategy;

import com.kaze.models.Gesture;
import org.junit.Test;

import static org.junit.Assert.*;

public class RuleStrategyTest {

    @Test
    public void isDraw() throws Exception
    {
        assertTrue(RuleStrategy.isDraw(Gesture.PAPER, Gesture.PAPER));
        assertTrue(RuleStrategy.isDraw(Gesture.ROCK, Gesture.ROCK));
        assertTrue(RuleStrategy.isDraw(Gesture.SCISSOR, Gesture.SCISSOR));
    }

    @Test
    public void isHumanWin() throws Exception
    {
        assertFalse(RuleStrategy.isHumanWin(Gesture.PAPER, Gesture.PAPER));
        assertFalse(RuleStrategy.isHumanWin(Gesture.ROCK, Gesture.ROCK));
        assertFalse(RuleStrategy.isHumanWin(Gesture.SCISSOR, Gesture.SCISSOR));

        assertFalse(RuleStrategy.isHumanWin(Gesture.SCISSOR, Gesture.ROCK));
        assertTrue(RuleStrategy.isHumanWin(Gesture.ROCK, Gesture.SCISSOR));
        assertTrue(RuleStrategy.isHumanWin(Gesture.SCISSOR, Gesture.PAPER));
        assertFalse(RuleStrategy.isHumanWin(Gesture.PAPER, Gesture.SCISSOR));
        assertFalse(RuleStrategy.isHumanWin(Gesture.ROCK, Gesture.PAPER));
        assertTrue(RuleStrategy.isHumanWin(Gesture.PAPER, Gesture.ROCK));
    }

}