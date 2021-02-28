package org.codingevents.codingevents.models;


import jdk.jfr.EventType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Event {
    private int id;
    private static int nextId = 1;
    @NotBlank(message="Name is required!")
    @Size(min=3, max=50, message= "Name must be between 3 to 50 characters")
    private String name;
    @Size(max= 50, message = "Description too long!")
    private String  description;
    @NotBlank
    @Email(message = "Invalid email, Try again")
    private String  contactEmail;

    private EventTypes type;

    public Event(){
        this.id = nextId;
        nextId ++;
    }
    public Event(String name, String description, String contactEmail, EventTypes  type) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.type = type;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getId() {
        return id;
    }

    public EventTypes getType() {
        return type;
    }

    public void setType(EventTypes type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return getId() == event.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
