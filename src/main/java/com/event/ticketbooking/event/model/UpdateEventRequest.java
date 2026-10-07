package com.event.ticketbooking.event.model;

public class UpdateEventRequest extends CreateEventRequest {
    public UpdateEventRequest() {
    }

    public UpdateEventRequest(Long categoryId, Long venueId, String name, String description,
                             java.time.LocalDateTime startAt, java.time.LocalDateTime endAt) {
        super(categoryId, venueId, name, description, startAt, endAt);
    }
}
