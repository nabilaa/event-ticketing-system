package com.event.ticketing.event.service;

import com.event.ticketing.event.entity.EventCategory;
import com.event.ticketing.event.repository.EventCategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Optional<EventCategory> findById(UUID id) {
        return eventCategoryRepository.findById(id);
    }

    public void deleteById(UUID id) {
        eventCategoryRepository.deleteById(id);
    }
}