package com.example.sc.controller;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.sc.service.ShuffleService;

@WebMvcTest(ShuffleController.class)
public class ShuffleControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ShuffleService shuffleService;

    @Test
    public void test_faro() throws Exception {
        when(shuffleService.createFaroShuffleDistribution(1))
                .thenReturn(getMockedResponse());
        this.mockMvc.perform(post("/shuffle/faro?count=1").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().json("[[1,2,3]]"));
    }

    @Test
    public void test_fisheryates() throws Exception {
        when(shuffleService.createFisherYatesShuffleDistribution(1))
                .thenReturn(getMockedResponse());
        this.mockMvc.perform(post("/shuffle/fisher-yates?count=1").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().json("[[1,2,3]]"));
    }

    @Test
    public void test_overhand_withDefault_maxChunkSize() throws Exception {
        when(shuffleService.createOverhandShuffleDistribution(1, 5))
                .thenReturn(getMockedResponse());
        this.mockMvc.perform(post("/shuffle/overhand?count=1").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().json("[[1,2,3]]"));
    }

    @Test
    public void test_overhand_custom_maxChunkSize() throws Exception {
        when(shuffleService.createOverhandShuffleDistribution(1, 10))
                .thenReturn(getMockedResponse());
        this.mockMvc.perform(post("/shuffle/overhand?count=1&max_chunk_size=10").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().json("[[1,2,3]]"));
    }

    @Test
    public void test_pile_default_pileCount() throws Exception {
        when(shuffleService.createPileShuffleDistribution(1, 10))
                .thenReturn(getMockedResponse());
        this.mockMvc.perform(post("/shuffle/pile?count=1").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().json("[[1,2,3]]"));
    }

    @Test
    public void test_pile_custom_pileCount() throws Exception {
        when(shuffleService.createPileShuffleDistribution(1, 20))
                .thenReturn(getMockedResponse());
        this.mockMvc.perform(post("/shuffle/pile?count=1&pile_count=20").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().json("[[1,2,3]]"));
    }
    @Test
    public void test_riffle() throws Exception {
        when(shuffleService.createRiffleShuffleDistribution(1))
                .thenReturn(getMockedResponse());
        this.mockMvc.perform(post("/shuffle/riffle?count=1").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().json("[[1,2,3]]"));
    }

    private int[][] getMockedResponse() {
        int[][] res = new int[1][3];
        res[0] = new int[]{1, 2, 3};
        return res;
    }
}
