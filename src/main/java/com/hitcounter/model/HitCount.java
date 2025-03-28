package com.hitcounter.model;

/**
 * The HitCount model representing the counter value
 */
public class HitCount {
    private Integer counter;

    public HitCount() {
        this(0);
    }

    public HitCount(Integer counter) {
        this.counter = counter;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }
}
