package com.example.sc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Modeling Approach:
 * Deal the deck into N piles.
 * Collect piles in a specific order.
 */
public class PileShiuffle extends  AbstractShuffle {
    private final int pileCount;

    public PileShiuffle(int pileCount) {
        this.pileCount = pileCount;
    }

    @Override
    public List<Integer> shuffle(List<Integer> deck) {
        List<List<Integer>> piles = new ArrayList<>();
        for (int i = 0; i < pileCount; i++) piles.add(new ArrayList<>());

        for (int i = 0; i < deck.size(); i++) {
            piles.get(i % pileCount).add(deck.get(i)); // Distribute cards into piles
        }

        List<Integer> shuffled = new ArrayList<>();
        for (List<Integer> pile : piles) {
            shuffled.addAll(pile); // Collect in order
        }
        return shuffled;
    }
}
