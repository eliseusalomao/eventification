package com.eventification.eventification.services;

import com.eventification.eventification.exceptions.TitleLengthIsntEnough;
import com.eventification.eventification.repositories.EventRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eventification.eventification.exceptions.DescriptionRequired;
import com.eventification.eventification.models.event.Event;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventServiceTest {
	@Autowired
	private EventService service;

    @Autowired
    private EventRepository repository;

	
    @Test
    void createSuccess() throws DescriptionRequired, TitleLengthIsntEnough  {
        Event event = new Event(1, "This title should be acceptable", "description");
        Event eventFromService = service.create(event);

        assertEquals(eventFromService.getTitle(), "This title should be acceptable");
    }

    @Test
    void createFailedBecauseDescriptionWasBlank() throws DescriptionRequired {
        Event event = new Event(2, "Title", "");

        Assertions.assertThrows(DescriptionRequired.class,
                () ->  service.create(event));
    }

    @Test
    void mustFindEventByItsId() {
        Event event = new Event(5, "Must be accepted", "Valid Description");
        Optional<Event> eventFromRepository = service.findEventByItsId(event.getId());

        eventFromRepository.ifPresent(value -> assertEquals(value.getId(), 5));
    }

    @Test
    void createFailedBecauseTitleLengthWasntEnough() throws TitleLengthIsntEnough {
        Event event = new Event(4, "Error", "Valid Description");

        Assertions.assertThrows(TitleLengthIsntEnough.class,
                () -> service.create(event));
    }
}

