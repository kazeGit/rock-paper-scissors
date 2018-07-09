package com.kaze.ai.impl;


import com.kaze.Game;
import com.kaze.ai.AiStrategy;
import com.kaze.models.Gesture;
import com.kaze.models.Round;
import com.kaze.strategy.RuleStrategy;

import java.security.SecureRandom;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Markov's chains used here, depth is 2
 */
public class HardAiStrategy implements AiStrategy {

    private Map<String, Transition> predictionMap = new HashMap<>();
    private Gesture lastGesture;
    private Integer chainDepth = 2;

    @Override
    public Gesture getGesture(Gesture humanGesture, Round round) {

        Gesture gesture;
        if (lastGesture == null) { // simple initialize check
            initPredictionsMap();
            gesture = Game.GESTURES.get(new SecureRandom().nextInt(3));
        } else {
            String key = lastGesture.toString() + round.getNumber();
            final Transition transition = predictionMap.get(key);

            // find best gesture
            gesture = transition.getStatisticMap()
                    .entrySet().stream()
                    .sorted(Comparator.comparingInt(Map.Entry::getValue)).findFirst().map(Map.Entry::getKey).get();
        }
        // have no ask-mechanism, will update predictionMap here
        lastGesture = humanGesture;
        String key = lastGesture.toString() + round.getNumber();
        updatePredictionsMap(key, humanGesture, gesture);
        return gesture;
    }

    private void initPredictionsMap() {
        for(int i = chainDepth; i>0; i--) {
            for (Gesture gesture : Gesture.values()) {
                predictionMap.put(gesture.toString()+i, new Transition());
            }
        }
    }

    private void updatePredictionsMap(String key, Gesture humanGesture, Gesture aiGesture) {
        final Transition transition = predictionMap.get(key);
        transition.getStatisticMap().merge(humanGesture, calculateResult(humanGesture, aiGesture), Integer::sum);
    }

    // could be just 1 for win and 0 otherwise, but why not to add draw value too
    private Integer calculateResult(Gesture humanGesture, Gesture aiGesture) {
        if ( RuleStrategy.isHumanWin(humanGesture, aiGesture) )
            return -1;
        else if ( RuleStrategy.isDraw(humanGesture, aiGesture))
            return 0;
        else // ai wins
            return 1;
    }

    /**
     * Store variants of transitions for round+gesture key
     */
    private class Transition {

        private HashMap<Gesture, Integer> statisticMap = new HashMap<>();

        public HashMap<Gesture, Integer> getStatisticMap() {
            return statisticMap;
        }

        public Transition() {
            for (Gesture gesture : Gesture.values()) {
                statisticMap.put(gesture, 0);
            }
        }

        @Override
        public String toString() {
            return "Transition{" + statisticMap + '}';
        }
    }
}
