package com.example.sc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sc.model.AbstractShuffle;
import com.example.sc.model.FaroShuffle;
import com.example.sc.model.FisherYatesShuffle;
import com.example.sc.model.OverhandShuffle;
import com.example.sc.model.PileShiuffle;
import com.example.sc.model.RiffleShuffle;

@Service
public class ShuffleService {
    private static final int DECK_SIZE = 52;

    private static List<Integer> generateDeck(final int deckSize) {
        List<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= deckSize; i++) {
            deck.add(i);
        }
        return deck;
    }

    // Measures randomness: How far 'forward' did each card move
    // from its original position?
    private static int[] getPositionChanges(List<Integer> shuffledDeck) {
        final int deckSize = shuffledDeck.size();
        int[] positionChanges = new int[deckSize];
        for (int i = 0; i < deckSize; i++) {
            final int originalPosition = shuffledDeck.get(i) - 1;
            int displacement = originalPosition - i;
            if (displacement < 0) {
                displacement += deckSize;
            }
            positionChanges[i] = displacement;
        }
        return positionChanges;
    }

    private static int[] getPositionChangeDistribution(List<Integer> shuffledDeck) {
        var positionChanges = getPositionChanges(shuffledDeck);
        int[] distribution = new int[shuffledDeck.size()];
        for (int c : positionChanges) {
            distribution[c]++;
        }
        return distribution;
    }

    private static int[][] getRepeatedPositionChangeDistribution(AbstractShuffle shuffle, int simulationCount) {
        List<Integer> deck = generateDeck(DECK_SIZE);
        List<Integer> shuffledDeck = deck;
        int[][] res = new int[simulationCount][DECK_SIZE];
        for (int i = 0; i < simulationCount; i++) {
            shuffledDeck = shuffle.shuffle(shuffledDeck);
            res[i] = getPositionChangeDistribution(shuffledDeck);
        }

        return res;
    }

    public int[][] createFaroShuffleDistribution(int simulationCount) {
        var shuffle = new FaroShuffle();
        return getRepeatedPositionChangeDistribution(shuffle, simulationCount);
    }

    public int[][] createFisherYatesShuffleDistribution(int simulationCount) {
        var shuffle = new FisherYatesShuffle();
        return getRepeatedPositionChangeDistribution(shuffle, simulationCount);
    }

    public int[][] createOverhandShuffleDistribution(int simulationCount, int maxChunkSize) {
        var shuffle = new OverhandShuffle(maxChunkSize);
        return getRepeatedPositionChangeDistribution(shuffle, simulationCount);
    }

    public int[][] createPileShuffleDistribution(int simulationCount, int pileCount) {
        var shuffle = new PileShiuffle(pileCount);
        return getRepeatedPositionChangeDistribution(shuffle, simulationCount);
    }

    public int[][] createRiffleShuffleDistribution(int simulationCount) {
        var shuffle = new RiffleShuffle();
        return getRepeatedPositionChangeDistribution(shuffle, simulationCount);
    }
}
