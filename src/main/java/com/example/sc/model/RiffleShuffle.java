package com.example.sc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Modeling Approach:
 * Split the deck into two approximately equal halves.
 * Interleave them based on probabilistic selection
 * (each card has a chance to be selected from either half).
 */
public class RiffleShuffle extends AbstractShuffle {
    @Override
    public List<Integer> shuffle(List<Integer> deck) {
        Random rand = new Random();
        int mid = deck.size() / 2;
        List<Integer> left = new ArrayList<>(deck.subList(0, mid));
        List<Integer> right = new ArrayList<>(deck.subList(mid, deck.size()));
        List<Integer> shuffled = new ArrayList<>();

        while (!left.isEmpty() || !right.isEmpty()) {
            if (!left.isEmpty() && (right.isEmpty() || rand.nextBoolean())) {
                shuffled.add(left.remove(0));
            } else {
                shuffled.add(right.remove(0));
            }
        }
        return shuffled;
    }
}
