package com.event.ticketbooking.event.model;

import java.time.LocalDateTime;

public class TicketType {
    private Long id;
    private Long eventId;
    private String name;
    private String description;
    private Double price;
    private Integer quota;
    private Integer soldQuantity;
    private Integer availableQuantity;
    private LocalDateTime salesStartAt;
    private LocalDateTime salesEndAt;

    public TicketType() {
    }

    public TicketType(Long id, Long eventId, String name, String description, Double price, Integer quota,
                     Integer soldQuantity, Integer availableQuantity, LocalDateTime salesStartAt,
                     LocalDateTime salesEndAt) {
        this.id = id;
        this.eventId = eventId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quota = quota;
        this.soldQuantity = soldQuantity;
        this.availableQuantity = availableQuantity;
        this.salesStartAt = salesStartAt;
        this.salesEndAt = salesEndAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public Integer getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Integer soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public LocalDateTime getSalesStartAt() {
        return salesStartAt;
    }

    public void setSalesStartAt(LocalDateTime salesStartAt) {
        this.salesStartAt = salesStartAt;
    }

    public LocalDateTime getSalesEndAt() {
        return salesEndAt;
    }

    public void setSalesEndAt(LocalDateTime salesEndAt) {
        this.salesEndAt = salesEndAt;
    }
}
