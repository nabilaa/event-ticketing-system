package com.event.ticketing.model;

import java.net.URI;
import java.util.UUID;

public class EventImage {
    private UUID id;
    private URI imageUrl;
    private EventImageType imageType;
    private Integer displayOrder;

    public EventImage() {
    }

    public EventImage(UUID id, URI imageUrl, EventImageType imageType, Integer displayOrder) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.imageType = imageType;
        this.displayOrder = displayOrder;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
