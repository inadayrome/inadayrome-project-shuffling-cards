package com.example.sc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Modeling Approach:
 * Take random-sized packets from the top and drop them into a new list.
 * The randomness comes from varying packet sizes.
 */
public class OverhandShuffle extends AbstractShuffle {
    private final int maxChunkSize;

    public OverhandShuffle(int maxChunkSize) {
        this.maxChunkSize = maxChunkSize;
    }

    @Override
    public List<Integer> shuffle(List<Integer> deck) {
        Random rand = new Random();
        List<Integer> shuffled = new ArrayList<>();

        while (!deck.isEmpty()) {
            int chunkSize = rand.nextInt(this.maxChunkSize) + 1; // Random chunk of up to maxChunkSize cards
            chunkSize = Math.min(chunkSize, deck.size());
            List<Integer> chunk = deck.subList(0, chunkSize);
            shuffled.addAll(0, chunk); // Insert at the beginning
            deck = deck.subList(chunkSize, deck.size());
        }
        return shuffled;
    }
}