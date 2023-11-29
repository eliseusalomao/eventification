package com.eventification.eventification.controllers.event;

import com.eventification.eventification.models.event.Event;
import com.eventification.eventification.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService service;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Event event) {
       Event newEvent = new Event(event.getId(), event.getTitle(), event.getDescription());

       try {
           Event createdEvent = service.create(newEvent);
           return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
       } catch (Exception err) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
       }
    }
}
