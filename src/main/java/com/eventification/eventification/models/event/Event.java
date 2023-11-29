package com.eventification.eventification.models.event;

import com.eventification.eventification.models.userEvent.UserEvent;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "event")
    List<UserEvent> users = new ArrayList<>();

    public Event() {}

    public Event(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
