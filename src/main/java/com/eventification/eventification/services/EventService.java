package com.eventification.eventification.services;

import com.eventification.eventification.exceptions.DescriptionRequired;
import com.eventification.eventification.models.event.Event;
import com.eventification.eventification.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EventService {

    @Autowired
    EventRepository repository;

    public Event create(Event event) throws DescriptionRequired {
        if (event.getDescription().isBlank()) {
            throw new DescriptionRequired();
        }
        return repository.save(event);
    }
}
