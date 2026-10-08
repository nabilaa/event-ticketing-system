package com.event.ticketbooking.event.model;

import java.time.LocalDateTime;
import java.util.List;

import com.event.ticketbooking.event.entity.EventCategory;

public class EventDto {
    private Long id;
    private String organizerId;
    private EventCategory category;
    private VenueDto venue;
    private String name;
    private String description;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private EventStatus status;
    private List<EventImage> images;
    private List<TicketType> ticketTypes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public EventDto() {
    }

    public EventDto(Long id, String organizerId, EventCategory category, VenueDto venue, String name,
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(String organizerId) {
        this.organizerId = organizerId;
    }

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public VenueDto getVenue() {
        return venue;
    }

    public void setVenue(VenueDto venue) {
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
