package com.example.sc.service;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyList;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.stubbing.Answer;

import com.example.sc.model.FaroShuffle;

public class ShuffleServiceTest {
    private final ShuffleService shuffleService = new ShuffleService();
    private final int deckSize = 52;

    @Test
    public void test_createFaroShuffleDistribution() {
        try(MockedConstruction<FaroShuffle> mockShuffle = Mockito.mockConstruction(
                FaroShuffle.class,
                (mock, context) -> when(mock.shuffle(anyList())).thenAnswer(getShuffleAnswer()))) {
    
            int[][] res = shuffleService.createFaroShuffleDistribution(3);
            assertEquals(res.length, 3);
            // assert answer
            for (int i = 0; i < 3; i++) {
                // on 1st row, there should be 52 at idx 1,
                // 52 at idx 2 and so on
                var expectedRes = new int[deckSize];
                expectedRes[i+1] = deckSize;
                assertArrayEquals(res[i], expectedRes);
            }
            assertEquals(1, mockShuffle.constructed().size());
        }
    }

    private Answer<List<Integer>> getShuffleAnswer() {
        return (ans) -> {
            // always displace element(s) by 1 to the right
            // e.g. [1,2,3] -> [2,3,1]
            List<Integer> originalDeck = ans.getArgument(0);
            List<Integer> res = new ArrayList<>();
            res.addAll(originalDeck.subList(1, originalDeck.size()));
            res.add(originalDeck.get(0));

            return res;
        };
    }
}
