package com.usa.project.repository;

import com.usa.project.model.Room;
import com.usa.project.repository.crud.RoomCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoomRepository {
    @Autowired
    private RoomCrudRepository roomCrudRepository;

    public List<Room> getAll(){
        return (List<Room>) roomCrudRepository.findAll();
    }

    public Optional<Room> getSkate(int id){
        return roomCrudRepository.findById(id);
    }

    public Room save(Room room){
        return roomCrudRepository.save(room);
    }
    public void delete(Room room){
        roomCrudRepository.delete(room);
    }

    public List<Object[]> getTopByYear(){
        return roomCrudRepository.countTotalRoomByStars();
    }

}
