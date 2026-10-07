package com.event.ticketbooking.common.response;

public class ApiResponse<T> {
    private T data;
    private Object metadata;
    private Object errors;

    public ApiResponse() {

    }

    public ApiResponse(T data, Object metadata, Object errors) {

        this.data = data;
        this.metadata = metadata;
        this.errors = errors;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
       this.metadata = metadata;
    }
    
    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }
}
