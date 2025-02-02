package com.example.sc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Modeling Approach:
 * Swap each card with a randomly chosen position.
 * Ensures uniform distribution across all possible orderings.
 */
public class FisherYatesShuffle extends AbstractShuffle {
    @Override
    public List<Integer> shuffle(List<Integer> deck) {
        List<Integer> res = new ArrayList<>();
        res.addAll(deck);
        Random rand = new Random();
        for (int i = res.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1); // Random index from 0 to i
            Collections.swap(res, i, j);
        }
        return res;
    }
}
