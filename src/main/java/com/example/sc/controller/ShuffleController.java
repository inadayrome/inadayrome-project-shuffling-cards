package com.example.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sc.service.ShuffleService;

@RestController
@RequestMapping("/shuffle")
public class ShuffleController {
    @Autowired
    private ShuffleService shuffleService;

    @PostMapping("/faro")
    public int[][] createFaroShuffleDistribution(
            @RequestParam(name="count", required=true) int simulationCount) {
        return shuffleService.createFaroShuffleDistribution(simulationCount);
    }

    @PostMapping("/fisher-yates")
    public int[][] createFisherYatesShuffleDistribution(
            @RequestParam(name="count", required=true) int simulationCount) {
        return shuffleService.createFisherYatesShuffleDistribution(simulationCount);
    }

    @PostMapping("/overhand")
    public int[][] createOverhandYatesShuffleDistribution(
            @RequestParam(name="count", required=true) int simulationCount,
            @RequestParam(name="max_chunk_size", required=false, defaultValue="5") int maxChunkSize) {
        return shuffleService.createOverhandShuffleDistribution(simulationCount, maxChunkSize);
    }

    @PostMapping("/pile")
    public int[][] createPileShuffleDistribution(
            @RequestParam(name="count", required=true) int simulationCount,
            @RequestParam(name="pile_count", required=false, defaultValue="10") int pileCount) {
        return shuffleService.createPileShuffleDistribution(simulationCount, pileCount);
    }

    @PostMapping("/riffle")
    public int[][] createRiffleShuffleDistribution(
            @RequestParam(name="count", required=true) int simulationCount) {
        return shuffleService.createRiffleShuffleDistribution(simulationCount);
    }
}
