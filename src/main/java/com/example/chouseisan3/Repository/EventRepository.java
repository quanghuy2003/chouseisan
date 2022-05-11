package com.example.chouseisan3.Repository;

import com.example.chouseisan3.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event,Long> {
//    @Query("select time from  Event ")
//    Iterable<Event> time();
}
