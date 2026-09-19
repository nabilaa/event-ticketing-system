package com.event.ticketing.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EventImageRequest {
    @NotBlank
    private String imageUrl;

    @NotNull
    private EventImageType imageType;

    private Integer displayOrder = 0;

    public EventImageRequest() {
    }

    public EventImageRequest(String imageUrl, EventImageType imageType, Integer displayOrder) {
        this.imageUrl = imageUrl;
        this.imageType = imageType;
        this.displayOrder = displayOrder;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
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
