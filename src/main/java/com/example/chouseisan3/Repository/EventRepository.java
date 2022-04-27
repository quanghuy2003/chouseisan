package com.example.chouseisan3.Repository;

import com.example.chouseisan3.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
