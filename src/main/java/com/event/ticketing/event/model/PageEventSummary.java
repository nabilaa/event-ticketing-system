package com.event.ticketing.model;

import java.util.List;

public class PageEventSummary {
    private List<EventSummary> content;
    private Integer page;
    private Integer size;
    private Long totalElements;
    private Integer totalPages;

    public PageEventSummary() {
    }

    public PageEventSummary(List<EventSummary> content, Integer page, Integer size, Long totalElements, Integer totalPages) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public List<EventSummary> getContent() {
        return content;
    }

    public void setContent(List<EventSummary> content) {
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
