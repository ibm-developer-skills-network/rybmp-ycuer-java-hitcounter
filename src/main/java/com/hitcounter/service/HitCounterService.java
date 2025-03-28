package com.hitcounter.service;

import org.springframework.stereotype.Service;

import com.hitcounter.model.HitCount;

/**
 * Service that manages the hit counter
 */
@Service
public class HitCounterService {
    // Using a static variable to mimic the global variable from the Flask app
    private static Integer hits = 0;
    
    /**
     * Gets the current hit count
     * 
     * @return The HitCount object with the current count
     */
    public HitCount getHits() {
        return new HitCount(hits);
    }
    
    /**
     * Increments the hit counter by 1
     * 
     * @return The HitCount object with the updated count
     */
    public HitCount incrementHits() {
        hits += 1;
        return new HitCount(hits);
    }
    
    /**
     * Resets the hit counter to a specific value
     * This is primarily used for testing
     * 
     * @param value The value to reset the counter to
     */
    public void resetHits(Integer value) {
        hits = value;
    }
}
