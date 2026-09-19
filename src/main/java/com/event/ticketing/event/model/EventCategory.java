package com.event.ticketing.model;

import java.util.UUID;

public class EventCategory {
    private String name;

    public EventCategory() {
    }

    public EventCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
