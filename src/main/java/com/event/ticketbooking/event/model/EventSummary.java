package com.event.ticketbooking.event.model;

import java.net.URI;
import java.time.LocalDateTime;

public class EventSummary {
    private Long id;
    private String name;
    private String categoryName;
    private String venueName;
    private String city;
    private LocalDateTime startAt;
    private URI thumbnailUrl;
    private EventStatus status;

    public EventSummary() {
    }

    public EventSummary(Long id, String name, String categoryName, String venueName,
                       String city, LocalDateTime startAt, URI thumbnailUrl, EventStatus status) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.venueName = venueName;
        this.city = city;
        this.startAt = startAt;
        this.thumbnailUrl = thumbnailUrl;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }

    public URI getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(URI thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }
}
