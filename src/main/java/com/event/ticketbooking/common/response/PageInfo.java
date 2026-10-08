package com.event.ticketbooking.common.response;

public class PageInfo {
    private Integer currentPage;

    private Integer totalPage;

    private Integer size;

    public PageInfo() {
    }

    public PageInfo(Integer currentPage, Integer totalPage, Integer size) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.size = size;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
