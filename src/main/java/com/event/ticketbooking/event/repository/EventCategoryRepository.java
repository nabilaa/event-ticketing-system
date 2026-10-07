package com.event.ticketbooking.event.repository;

import com.event.ticketbooking.event.entity.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventCategoryRepository extends JpaRepository<EventCategory, Long> {
}