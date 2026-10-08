package com.event.ticketbooking.event.service;

import com.event.ticketbooking.event.entity.Event;
import com.event.ticketbooking.event.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> search(
        String name,
        Long categoryId,
        LocalDateTime from,
        LocalDateTime to
    ) {
        return eventRepository.search(name, categoryId, from, to);
    }
}