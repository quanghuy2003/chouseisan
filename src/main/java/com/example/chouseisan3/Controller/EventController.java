package com.example.chouseisan3.Controller;

import com.example.chouseisan3.Model.Event;
import com.example.chouseisan3.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Event>> findAll() {
        List<Event> events = (List<Event>) eventService.findAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
    @PostMapping("/addEvent")
    public ResponseEntity<Event> add(@RequestBody Event event) {
        eventService.save(event);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
