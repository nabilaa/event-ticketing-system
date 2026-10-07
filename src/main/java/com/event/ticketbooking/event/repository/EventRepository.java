package com.event.ticketbooking.event.repository;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.event.ticketbooking.event.entity.Event;
import com.event.ticketbooking.event.model.EventStatus;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query(
            value = """
                    SELECT e FROM Event e
                    JOIN FETCH e.venue v
                    JOIN FETCH e.category c
                    WHERE e.status IN :statuses
                      AND (:from IS NULL OR e.startAt >= :from)
                      AND (:to IS NULL OR e.startAt < :to)
                      AND (:venueId IS NULL OR v.id = :venueId)
                      AND (:city IS NULL OR LOWER(v.city) = LOWER(:city))
                      AND (:categoryId IS NULL OR c.id = :categoryId)
                    """,
            countQuery = """
                    SELECT COUNT(e) FROM Event e
                    JOIN e.venue v
                    JOIN e.category c
                    WHERE e.status IN :statuses
                      AND (:from IS NULL OR e.startAt >= :from)
                      AND (:to IS NULL OR e.startAt < :to)
                      AND (:venueId IS NULL OR v.id = :venueId)
                      AND (:city IS NULL OR LOWER(v.city) = LOWER(:city))
                      AND (:categoryId IS NULL OR c.id = :categoryId)
                    """
    )
    Page<Event> search(
            @Param("from") LocalDateTime from,
            @Param("to") LocalDateTime to,
            @Param("venueId") Long venueId,
            @Param("city") String city,
            @Param("categoryId") Long categoryId,
            @Param("statuses") Collection<EventStatus> statuses,
            Pageable pageable);
}
