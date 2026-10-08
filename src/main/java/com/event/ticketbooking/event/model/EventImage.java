package com.event.ticketbooking.event.model;

import java.net.URI;

public class EventImage {
    private Long id;
    private URI imageUrl;
    private EventImageType imageType;
    private Integer displayOrder;

    public EventImage() {
    }

    public EventImage(Long id, URI imageUrl, EventImageType imageType, Integer displayOrder) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.imageType = imageType;
        this.displayOrder = displayOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public URI getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(URI imageUrl) {
        this.imageUrl = imageUrl;
    }

    public EventImageType getImageType() {
        return imageType;
    }

    public void setImageType(EventImageType imageType) {
        this.imageType = imageType;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}
