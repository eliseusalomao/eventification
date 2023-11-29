package com.eventification.eventification.models.userEvent;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserEventFK implements Serializable {

    @Column(name = "user_id")
    Integer user;

    @Column(name = "event_id")
    Integer event;

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getEvent() {
        return event;
    }

    public void setEvent(Integer event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEvent userEvent = (UserEvent) o;

        return Objects.equals(user, userEvent.user);
    }

    @Override
    public int hashCode() {
        return user != null ? user.hashCode() : 0;
    }
}
