package com.event.ticketing.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Event {
    private UUID id;
    private UUID organizerId;
    private EventCategory category;
    private Venue venue;
    private String name;
    private String description;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private EventStatus status;
    private List<EventImage> images;
    private List<TicketType> ticketTypes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Event() {
    }

    public Event(UUID id, UUID organizerId, EventCategory category, Venue venue, String name,
                 String description, LocalDateTime startAt, LocalDateTime endAt, EventStatus status,
                 List<EventImage> images, List<TicketType> ticketTypes, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.organizerId = organizerId;
        this.category = category;
        this.venue = venue;
        this.name = name;
        this.description = description;
        this.startAt = startAt;
        this.endAt = endAt;
        this.status = status;
        this.images = images;
        this.ticketTypes = ticketTypes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(UUID organizerId) {
        this.organizerId = organizerId;
    }

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
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

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public List<EventImage> getImages() {
        return images;
    }

    public void setImages(List<EventImage> images) {
        this.images = images;
    }

    public List<TicketType> getTicketTypes() {
        return ticketTypes;
    }

    public void setTicketTypes(List<TicketType> ticketTypes) {
        this.ticketTypes = ticketTypes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
