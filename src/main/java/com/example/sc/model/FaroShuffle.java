package com.example.sc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Modeling Approach:
 * Split deck into two equal halves.
 * Perfectly interleave them, one card from each half.
 */
public class FaroShuffle extends  AbstractShuffle {
    @Override
    public List<Integer> shuffle(List<Integer> deck) {
        int mid = deck.size() / 2;
        List<Integer> left = new ArrayList<>(deck.subList(0, mid));
        List<Integer> right = new ArrayList<>(deck.subList(mid, deck.size()));
        List<Integer> shuffled = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            shuffled.add(left.get(i));
            shuffled.add(right.get(i));
        }
        return shuffled;
    }
}
