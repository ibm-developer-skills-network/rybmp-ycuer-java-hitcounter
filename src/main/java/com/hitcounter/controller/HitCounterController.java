package com.hitcounter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hitcounter.model.HitCount;
import com.hitcounter.service.HitCounterService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controller for the Hit Counter service
 */
@RestController
@RequestMapping("/hits")
@Tag(name = "hits", description = "HitCounter Service")
public class HitCounterController {
    
    @Autowired
    private HitCounterService hitCounterService;
    
    /**
     * Returns the current hit count
     * 
     * @return The HitCount object with the current count
     */
    @GetMapping
    @Operation(
        summary = "Get the current hit count",
        description = "Returns the current hit count"
    )
    public ResponseEntity<HitCount> getHits() {
        return new ResponseEntity<>(hitCounterService.getHits(), HttpStatus.OK);
    }
    
    /**
     * Increments the hit counter by 1
     * 
     * @return The HitCount object with the updated count
     */
    @PutMapping
    @Operation(
        summary = "Increment hits",
        description = "Increments the counter by 1"
    )
    @ApiResponse(responseCode = "200", description = "Counter incremented successfully")
    public ResponseEntity<HitCount> incrementHits() {
        return new ResponseEntity<>(hitCounterService.incrementHits(), HttpStatus.OK);
    }
}
