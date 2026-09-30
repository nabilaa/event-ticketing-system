package com.event.ticketing.event.repository;

import com.event.ticketing.event.entity.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventCategoryRepository extends JpaRepository<EventCategory, UUID> {
}