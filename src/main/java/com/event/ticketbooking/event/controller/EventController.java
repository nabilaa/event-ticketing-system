package com.event.ticketbooking.event.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.event.ticketbooking.common.response.ApiResponse;
import com.event.ticketbooking.event.entity.Event;
import com.event.ticketbooking.event.model.PageEventSummary;
import com.event.ticketbooking.event.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private static final Logger log = LoggerFactory.getLogger(EventController.class);

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> findAll() {
        log.info("Fetching all events");
        return eventService.findAll();
    }

    @GetMapping("/search")
    public ApiResponse<PageEventSummary> search(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(required = false) Long venueId,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        log.info("Searching events date={} venueId={} city={} categoryId={} page={} size={}",
                date, venueId, city, categoryId, page, size);
        PageEventSummary result = eventService.search(date, venueId, city, categoryId, page, size);
        return new ApiResponse<>(result, null, null);
    }

    @GetMapping("/{id}")
    public ApiResponse<Event> findById(@PathVariable Long id) {
        Event event = eventService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        return new ApiResponse<Event>(event, null,  null   );
    }

    @PostMapping
    public ApiResponse<Event> create(@RequestBody Event event) {
        Event savedEvent = eventService.save(event);
        return new ApiResponse<>(savedEvent, null, null);
    }

    @PutMapping("/{id}")
    public ApiResponse<Event> update(@PathVariable Long id, @RequestBody Event event) {
        if (eventService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
        event.setId(id);
        Event updatedEvent = eventService.save(event);
        return new ApiResponse<>(
                updatedEvent,
                null,
                null
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (eventService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
        eventService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}