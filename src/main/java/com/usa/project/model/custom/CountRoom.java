package com.usa.project.model.custom;

import com.usa.project.model.Room;

public class CountRoom {
    private Long total;
    private Room skate;

    public CountRoom(Long total, Room room) {
        this.total = total;
        this.skate = room;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Room getCar() {
        return skate;
    }

    public void setCar(Room room) {
        this.skate = room;
    }
}
