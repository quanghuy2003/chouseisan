package com.example.chouseisan3.Controller;

import com.example.chouseisan3.Model.Event;
import com.example.chouseisan3.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/event")
public class EventController {
    @Autowired
    EventService eventService;
    @CrossOrigin
    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Event>> findAll() {
        List<Event> events = (List<Event>) eventService.findAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity("Hello World", HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping("/addEvent")
    public ResponseEntity<Event> add(@RequestBody Event event) {
        eventService.save(event);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/seach{id}")
    public ResponseEntity<Event> findById(@PathVariable Long id) {
        eventService.findById(id).get();
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Event> delete(@PathVariable Long id) {
        Optional<Event> event = eventService.findById(id);
        eventService.remove(id);
        return new ResponseEntity<>(event.get(), HttpStatus.NO_CONTENT);
    }
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Event> update(@PathVariable Long id, @RequestBody Event event) {
        Optional<Event> eventOptional = eventService.findById(id);
        event.setId(eventOptional.get().getId());
        eventService.save(event);
        return new ResponseEntity<>(eventOptional.get(), HttpStatus.OK);
    }
}

