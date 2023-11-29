package com.eventification.eventification.services;

import com.eventification.eventification.exceptions.DescriptionRequired;
import com.eventification.eventification.exceptions.TitleLengthIsntEnough;
import com.eventification.eventification.models.event.Event;
import com.eventification.eventification.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EventService {

    @Autowired
    EventRepository repository;

    public Event create(Event event) throws DescriptionRequired, TitleLengthIsntEnough {
        if (event.getDescription().isBlank()) {
            throw new DescriptionRequired();
        }

        if (event.getTitle().length() < 7) {
            throw new TitleLengthIsntEnough();
        }

        return repository.save(event);
    }

    public Optional<Event> findEventByItsId(Integer id) {
        Optional<Event> eventFromRepository = repository.findEventById(id);

        return eventFromRepository;
    }
}
