package com.example.chouseisan3.Service;

import com.example.chouseisan3.Model.Event;
import com.example.chouseisan3.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EventService implements IEventService{

    @Autowired
    private EventRepository eventRepository;
    @Override
    public void save(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Iterable findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        eventRepository.deleteById(id);
    }
}
