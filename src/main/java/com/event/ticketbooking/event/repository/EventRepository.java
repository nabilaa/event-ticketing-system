package com.event.ticketbooking.event.repository;

import com.event.ticketbooking.event.entity.Event;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e " +
        "WHERE (:name IS NULL OR LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
        "AND (:categoryId IS NULL OR e.category.id = :categoryId) " +
        "AND (:startFrom IS NULL OR e.startAt >= :startFrom) " +
        "AND (:startTo IS NULL OR e.startAt <= :startTo) " +
        "ORDER BY e.startAt ASC")
    List<Event> search(
            @Param("name") String name,
            @Param("categoryId") Long categoryId,
            @Param("startFrom") LocalDateTime startFrom,
            @Param("startTo") LocalDateTime startTo
    );
}