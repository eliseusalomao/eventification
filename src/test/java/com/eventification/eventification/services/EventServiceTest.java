package com.eventification.eventification.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eventification.eventification.exceptions.DescriptionRequired;
import com.eventification.eventification.models.event.Event;
import com.eventification.eventification.repositories.EventRepository;

import static org.junit.jupiter.api.Assertions.*;




@SpringBootTest
class EventServiceTest {
	@Autowired
	private EventService service;

	
    @Test
    void createSuccess() throws com.eventification.eventification.exceptions.DescriptionRequired {
        Event event = new Event(1, "Title", "description");
        Event eventFromService = service.create(event);

        assertEquals(eventFromService.getTitle(), "Title");
    }
    @Test
    void nome_que_tu_quiser() throws DescriptionRequired {
        Event event = new Event(2, "Title", "");

        Assertions.assertThrows(DescriptionRequired.class,
                () ->  service.create(event));
    }
}

