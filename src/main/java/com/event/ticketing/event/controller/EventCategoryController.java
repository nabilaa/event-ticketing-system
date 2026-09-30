package com.event.ticketing.event.controller;

import com.event.ticketing.event.entity.EventCategory;
import com.event.ticketing.event.service.EventCategoryService;
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
@RequestMapping("/api/event-categories")
public class EventCategoryController {
    private final EventCategoryService eventCategoryService;

    public EventCategoryController(EventCategoryService eventCategoryService) {
        this.eventCategoryService = eventCategoryService;
    }

    @GetMapping
    public List<EventCategory> findAll() {
        return eventCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public EventCategory findById(@PathVariable UUID id) {
        return eventCategoryService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event category not found"));
    }

    @PostMapping
    public ResponseEntity<EventCategory> create(@RequestBody EventCategory eventCategory) {
        EventCategory savedCategory = eventCategoryService.save(eventCategory);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}").buildAndExpand(savedCategory.getId()).toUri())
                .body(savedCategory);
    }

    @PutMapping("/{id}")
    public EventCategory update(@PathVariable UUID id, @RequestBody EventCategory eventCategory) {
        if (eventCategoryService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event category not found");
        }
        eventCategory.setId(id);
        return eventCategoryService.save(eventCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (eventCategoryService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event category not found");
        }
        eventCategoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}