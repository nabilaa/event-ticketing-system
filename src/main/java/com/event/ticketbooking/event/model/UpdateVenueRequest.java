package com.event.ticketbooking.event.model;

public class UpdateVenueRequest extends CreateVenueRequest {
    public UpdateVenueRequest() {
    }

    public UpdateVenueRequest(String name, String address, String city, String province, String country,
                             Double latitude, Double longitude) {
        super(name, address, city, province, country, latitude, longitude);
    }
}
