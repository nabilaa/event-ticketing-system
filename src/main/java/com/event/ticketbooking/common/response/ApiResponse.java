package com.event.ticketbooking.common.response;

public class ApiResponse<T> {
    private T data;

    private String errors;

    private PageInfo pageInfo;

    public ApiResponse() {
    }

    public ApiResponse(T data, String errors, PageInfo pageInfo) {
        this.data = data;
        this.errors = errors;
        this.pageInfo = pageInfo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {

        private T data;
        private String errors;
        private PageInfo pageInfo;

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public Builder<T> errors(String errors) {
            this.errors = errors;
            return this;
        }

        public Builder<T> pageInfo(PageInfo pageInfo) {
            this.pageInfo = pageInfo;
            return this;
        }

        public ApiResponse<T> build() {
            return new ApiResponse<>(data, errors, pageInfo);
        }
    }
}
