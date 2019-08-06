package org.geminisolutions.MovieTicketReservation.model;

import org.springframework.stereotype.Component;

@Component
public class Theatre {
    private String type;
    private String name;
    private int reserved_seats;
    private int capacity;
    private int no_of_rows;
    private int no_of_screens;
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReserved_seats() {
        return reserved_seats;
    }

    public void setReserved_seats(int reserved_seats) {
        this.reserved_seats = reserved_seats;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNo_of_rows() {
        return no_of_rows;
    }

    public void setNo_of_rows(int no_of_rows) {
        this.no_of_rows = no_of_rows;
    }

    public int getNo_of_screens() {
        return no_of_screens;
    }

    public void setNo_of_screens(int no_of_screens) {
        this.no_of_screens = no_of_screens;
    }

}
