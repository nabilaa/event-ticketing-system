package com.event.ticketing.event.service;

import com.event.ticketing.event.entity.Venue;
import com.event.ticketing.event.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Optional<Venue> findById(UUID id) {
        return venueRepository.findById(id);
    }

    public void deleteById(UUID id) {
        venueRepository.deleteById(id);
    }
}