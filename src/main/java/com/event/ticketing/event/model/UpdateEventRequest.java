package com.event.ticketing.model;

public class UpdateEventRequest extends CreateEventRequest {
    public UpdateEventRequest() {
    }

    public UpdateEventRequest(java.util.UUID categoryId, java.util.UUID venueId, String name, String slug,
                             String description, java.time.LocalDateTime startAt, java.time.LocalDateTime endAt) {
        super(categoryId, venueId, name, slug, description, startAt, endAt);
    }
}
