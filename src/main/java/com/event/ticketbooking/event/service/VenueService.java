package com.event.ticketbooking.event.service;

import com.event.ticketbooking.event.entity.Venue;
import com.event.ticketbooking.event.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {
    private final VenueRepository venueRepository;

    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public Venue save(Venue venue) {
        return venueRepository.save(venue);
    }

    public List<Venue> findAll() {
        return venueRepository.findAll();
    }

    public Optional<Venue> findById(Long id) {
        return venueRepository.findById(id);
    }

    public void deleteById(Long id) {
        venueRepository.deleteById(id);
    }
}