package com.event.ticketbooking.event.repository;

import com.event.ticketbooking.event.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}