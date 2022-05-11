package com.example.chouseisan3.Controller;

import com.example.chouseisan3.Model.Event;
import com.example.chouseisan3.Model.Vote;
import com.example.chouseisan3.Service.EventService;
import com.example.chouseisan3.Service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/vote")
public class VoteController {
    @Autowired
    VoteService voteService;

    @Autowired
    EventService eventService;
    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Vote>> findAll() {
        List<Vote> votes = (List<Vote>) voteService.findAll();
        if (votes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }

    @GetMapping("/findSchedule")
    public ResponseEntity<Iterable<Vote>> findAllSchedule() {
        List<Vote> votes = (List<Vote>) voteService.schedule();
        if (votes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }

    @GetMapping("/findStatus")
    public ResponseEntity<Iterable<Vote>> findAllStatus() {
        List<Vote> votes = (List<Vote>) voteService.status();
        if (votes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }

    @GetMapping("/findComment")
    public ResponseEntity<Iterable<Vote>> findAllComment() {
        List<Vote> votes = (List<Vote>) voteService.comment();
        if (votes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Vote> findById(@PathVariable Long id) {
        return new ResponseEntity<>(voteService.findById(id).get(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Vote> add(@RequestBody Vote vote) {
        voteService.save(vote);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Vote> delete(@PathVariable Long id) {
        Optional<Vote> vote = voteService.findById(id);
        voteService.remove(id);
        return new ResponseEntity<>(vote.get(), HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Vote> update(@PathVariable Long id, @RequestBody Vote vote) {
        Optional<Vote> vote1 = voteService.findById(id);
        vote.setId(vote1.get().getId());
        voteService.save(vote);
        return new ResponseEntity<>(vote1.get(), HttpStatus.OK);
    }

    @GetMapping("/findEventId")
    public ResponseEntity<Iterable<Vote>> findEventId() {
        List<Vote> votes = (List<Vote>) voteService.findByEventId();
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }
}
