package com.usa.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "room")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String hotel;
    private Integer stars;
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("rooms")
    private Category category;


    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "room")
    @JsonIgnoreProperties({"room","client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "room")
    @JsonIgnoreProperties({"room","messages"})
    public List<Reservation> reservations;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
