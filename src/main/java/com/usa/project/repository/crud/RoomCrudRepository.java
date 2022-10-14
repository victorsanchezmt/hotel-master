package com.usa.project.repository.crud;

import com.usa.project.model.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomCrudRepository extends CrudRepository<Room,Integer> {

    @Query("SELECT c.stars, COUNT(c.stars) from Room AS c group by c.stars order by COUNT(c.stars) DESC")
    public List<Object[]> countTotalRoomByStars();

}
