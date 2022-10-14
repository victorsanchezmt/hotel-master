package com.usa.project.service;
import com.usa.project.model.Room;
import com.usa.project.model.custom.StarsAmount;
import com.usa.project.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAll(){
        return roomRepository.getAll();
    }

    public Optional<Room> getRoom(int id) {
        return roomRepository.getSkate(id);
    }

    public Room save(Room room){
        if(room.getId()==null){
            return roomRepository.save(room);
        }else{
            Optional<Room> e= roomRepository.getSkate(room.getId());
            if(e.isEmpty()){
                return roomRepository.save(room);
            }else{
                return room;
            }
        }
    }

    public Room update(Room room){
        if(room.getId()!=null){
            Optional<Room> e= roomRepository.getSkate(room.getId());
            if(!e.isEmpty()){
                if(room.getName()!=null){
                    e.get().setName(room.getName());
                }
                if(room.getHotel()!=null){
                    e.get().setHotel(room.getHotel());
                }
                if(room.getStars()!=null){
                    e.get().setStars(room.getStars());
                }
                if(room.getDescription()!=null){
                    e.get().setDescription(room.getDescription());
                }
                if(room.getCategory()!=null){
                    e.get().setCategory(room.getCategory());
                }
                roomRepository.save(e.get());
                return e.get();
            }else{
                return room;
            }
        }else{
            return room;
        }
    }


    public boolean delete(int id) {
        Boolean aBoolean = getRoom(id).map(costume -> {
            roomRepository.delete(costume);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<StarsAmount> getTopRoomByStars(){
        List<Object[]> report= roomRepository.getTopByYear();
        List<StarsAmount>res=new ArrayList<>();
        for(int i=0;i<report.size();i++){
            res.add(new StarsAmount((int)report.get(i)[0],(int) report.get(i)[1]));
        }
        return res;
    }
}

