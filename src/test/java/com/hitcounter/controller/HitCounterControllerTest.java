package com.hitcounter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hitcounter.model.HitCount;
import com.hitcounter.service.HitCounterService;

/**
 * Test Cases for HitCounter Service
 */
@SpringBootTest
@AutoConfigureMockMvc
public class HitCounterControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private HitCounterService hitCounterService;
    
    @BeforeEach
    public void setup() {
        // Reset counter before each test
        hitCounterService.resetHits(0);
    }
    
    /**
     * Verifies that the home page (Swagger UI) redirects correctly
     */
    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().is3xxRedirection());
    }
    
    /**
     * Tests getting the current hit count
     */
    @Test
    public void testGetHitCount() throws Exception {
        // Counter should be reset to 0 by the setup method
        
        MvcResult result = mockMvc.perform(get("/hits")
                                  .contentType(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isOk())
                                 .andReturn();
        
        HitCount hitCount = objectMapper.readValue(
            result.getResponse().getContentAsString(), 
            HitCount.class
        );
        
        assertEquals(0, hitCount.getCounter());
    }
    
    /**
     * Tests incrementing the hit count
     */
    @Test
    public void testIncrementHitCount() throws Exception {
        // Counter should be reset to 0 by the setup method
        
        MvcResult result = mockMvc.perform(put("/hits")
                                  .contentType(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isOk())
                                 .andReturn();
        
        HitCount hitCount = objectMapper.readValue(
            result.getResponse().getContentAsString(), 
            HitCount.class
        );
        
        assertEquals(1, hitCount.getCounter());
    }
}
