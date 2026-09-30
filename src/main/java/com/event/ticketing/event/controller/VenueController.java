package com.event.ticketing.event.controller;

import com.event.ticketing.event.entity.Venue;
import com.event.ticketing.event.service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/venues")
public class VenueController {
    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping
    public List<Venue> findAll() {
        return venueService.findAll();
    }

    @GetMapping("/{id}")
    public Venue findById(@PathVariable UUID id) {
        return venueService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venue not found"));
    }

    @PostMapping
    public ResponseEntity<Venue> create(@RequestBody Venue venue) {
        Venue savedVenue = venueService.save(venue);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}").buildAndExpand(savedVenue.getId()).toUri())
                .body(savedVenue);
    }

    @PutMapping("/{id}")
    public Venue update(@PathVariable UUID id, @RequestBody Venue venue) {
        if (venueService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venue not found");
        }
        venue.setId(id);
        return venueService.save(venue);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (venueService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venue not found");
        }
        venueService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}