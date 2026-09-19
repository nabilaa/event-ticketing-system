package com.event.ticketing.model;

import java.util.List;

public class PageVenue {
    private List<Venue> content;
    private Integer page;
    private Integer size;
    private Long totalElements;
    private Integer totalPages;

    public PageVenue() {
    }

    public PageVenue(List<Venue> content, Integer page, Integer size, Long totalElements, Integer totalPages) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public List<Venue> getContent() {
        return content;
    }

    public void setContent(List<Venue> content) {
        this.content = content;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
