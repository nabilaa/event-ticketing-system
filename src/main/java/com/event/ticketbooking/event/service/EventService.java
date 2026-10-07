package com.event.ticketbooking.event.service;

import com.event.ticketbooking.event.entity.Event;
import com.event.ticketbooking.event.model.EventStatus;
import com.event.ticketbooking.event.model.EventSummary;
import com.event.ticketbooking.event.model.PageEventSummary;
import com.event.ticketbooking.event.repository.EventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final int MAX_PAGE_SIZE = 100;

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

    public PageEventSummary search(LocalDate date, Long venueId, String city, Long categoryId, Integer page, Integer size) {
        int pageNumber = page == null || page < 0 ? 0 : page;
        int pageSize = size == null || size < 1 ? DEFAULT_PAGE_SIZE : Math.min(size, MAX_PAGE_SIZE);

        LocalDateTime from;
        LocalDateTime to = null;
        if (date != null) {
            from = date.atStartOfDay();
            to = date.plusDays(1).atStartOfDay();
        } else {
            from = LocalDateTime.now();
        }

        String cityFilter = city == null || city.isBlank() ? null : city.trim();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "startAt"));
        Page<Event> events = eventRepository.search(
                from,
                to,
                venueId,
                cityFilter,
                categoryId,
                List.of(EventStatus.PUBLISHED, EventStatus.SOLD_OUT),
                pageable);

        List<EventSummary> content = events.getContent().stream()
                .map(this::toSummary)
                .toList();

        return new PageEventSummary(content, events.getNumber(), events.getSize(), events.getTotalElements(),
                events.getTotalPages());
    }

    private EventSummary toSummary(Event event) {
        return new EventSummary(
                event.getId(),
                event.getName(),
                event.getCategory().getName(),
                event.getVenue().getName(),
                event.getVenue().getCity(),
                event.getStartAt(),
                null,
                event.getStatus()
        );
    }
}