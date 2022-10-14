package com.usa.project.web;

import com.usa.project.model.Room;
import com.usa.project.model.custom.StarsAmount;
import com.usa.project.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Room")
public class RoomController {

    @Autowired
    private RoomService roomService;
    @GetMapping("/all")
    public List<Room> getAll(){
        return roomService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Room> getRoom(@PathVariable("id") int id) {
        return roomService.getRoom(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Room save(@RequestBody Room room) {
        return roomService.save(room);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Room update(@RequestBody Room room) {
        return roomService.update(room);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return roomService.delete(id);
    }

    //Report!
    @GetMapping("/report")
    public List<StarsAmount> getReport(){
        return roomService.getTopRoomByStars();
    }
}
