package com.event.ticketing.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreateEventRequest {
    @NotNull
    private UUID categoryId;

    @NotNull
    private UUID venueId;

    @NotBlank
    @Size(max = 255)
    private String name;

    private String description;

    @NotNull
    private LocalDateTime startAt;

    @NotNull
    private LocalDateTime endAt;

    public CreateEventRequest() {
    }

    public CreateEventRequest(UUID categoryId, UUID venueId, String name, String description,
                             LocalDateTime startAt, LocalDateTime endAt) {
        this.categoryId = categoryId;
        this.venueId = venueId;
        this.name = name;
        this.description = description;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public UUID getVenueId() {
        return venueId;
    }

    public void setVenueId(UUID venueId) {
        this.venueId = venueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
    }
}
