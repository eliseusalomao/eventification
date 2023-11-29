package com.eventification.eventification.services;

import com.eventification.eventification.models.event.Event;
import com.eventification.eventification.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {

    @Autowired
    EventRepository repository;

    public Event create(Event event) {
        return repository.save(event);
    }
}
