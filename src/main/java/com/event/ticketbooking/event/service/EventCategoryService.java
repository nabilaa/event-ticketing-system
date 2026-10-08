package com.event.ticketbooking.event.service;

import com.event.ticketbooking.event.entity.EventCategory;
import com.event.ticketbooking.event.repository.EventCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventCategoryService {
    private final EventCategoryRepository eventCategoryRepository;

    public EventCategoryService(EventCategoryRepository eventCategoryRepository) {
        this.eventCategoryRepository = eventCategoryRepository;
    }

    public EventCategory save(EventCategory eventCategory) {
        return eventCategoryRepository.save(eventCategory);
    }

    public List<EventCategory> findAll() {
        return eventCategoryRepository.findAll();
    }

    public Optional<EventCategory> findById(Long id) {
        return eventCategoryRepository.findById(id);
    }

    public void deleteById(Long id) {
        eventCategoryRepository.deleteById(id);
    }
}