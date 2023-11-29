package com.eventification.eventification.models.userEvent;

import com.eventification.eventification.models.event.Event;
import com.eventification.eventification.models.user.User;
import jakarta.persistence.*;

@Entity
public class UserEvent {

    @EmbeddedId
    UserEventFK id;

    @ManyToOne
    @MapsId("user")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("event")
    @JoinColumn(name = "event_id")
    Event event;

    public UserEvent(UserEventFK id, User user, Event event) {
        this.id = id;
        this.user = user;
        this.event = event;
    }

    public UserEventFK getId() {
        return id;
    }

    public void setId(UserEventFK id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
