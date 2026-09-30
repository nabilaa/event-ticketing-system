package com.event.ticketing.event.service;

import com.event.ticketing.event.entity.Event;
import com.event.ticketing.event.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Optional<Event> findById(UUID id) {
        return eventRepository.findById(id);
    }

    public void deleteById(UUID id) {
        eventRepository.deleteById(id);
    }
}