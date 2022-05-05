package com.example.chouseisan3.Controller;

import com.example.chouseisan3.Model.Vote;
import com.example.chouseisan3.Service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vote")
public class VoteController {
    @Autowired
    VoteService voteService;
    @CrossOrigin
    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Vote>> findAll() {
        List<Vote> votes = (List<Vote>) voteService.findAll();
        if (votes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Vote> findById(@PathVariable Long id) {
        return new ResponseEntity<>(voteService.findById(id).get(), HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<Vote> add(@RequestBody Vote vote) {
        voteService.save(vote);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Vote> delete(@PathVariable Long id) {
        Optional<Vote> vote = voteService.findById(id);
        voteService.remove(id);
        return new ResponseEntity<>(vote.get(), HttpStatus.NO_CONTENT);
    }
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Vote> update(@PathVariable Long id, @RequestBody Vote vote) {
        Optional<Vote> vote1 = voteService.findById(id);
        vote.setId(vote1.get().getId());
        voteService.save(vote);
        return new ResponseEntity<>(vote1.get(), HttpStatus.OK);
    }
    @CrossOrigin
    @PutMapping("/vote/{id}/tick")
    public ResponseEntity<Vote> increaseTick(@PathVariable Long id) {
        Vote vote = voteService.findById(id).get();
        int tick = vote.getTick() + 1;
        vote.setTick(tick);
        vote.setId(id);
        voteService.save(vote);
        return new ResponseEntity<>(vote, HttpStatus.OK);
    }
    @CrossOrigin
    @PutMapping("/vote/{id}/questionMark")
    public ResponseEntity<Vote> increaseQuestionMark(@PathVariable Long id) {
        Vote vote = voteService.findById(id).get();
        int questionMark = vote.getQuestionMark() + 1;
        vote.setQuestionMark(questionMark);
        vote.setId(id);
        voteService.save(vote);
        return new ResponseEntity<>(vote, HttpStatus.OK);
    }
    @CrossOrigin
    @PutMapping("/vote/{id}/refuse")
    public ResponseEntity<Vote> increaseRefuse(@PathVariable Long id) {
        Vote vote = voteService.findById(id).get();
        int refuse = vote.getRefuse() + 1;
        vote.setRefuse(refuse);
        vote.setId(id);
        voteService.save(vote);
        return new ResponseEntity<>(vote, HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/findAllTick")
    public ResponseEntity<Iterable<Vote>> getTick() {
        List<Vote> votes = (List<Vote>) voteService.numberOfTick();
        if (votes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/findAllQuestionMark")
    public ResponseEntity<Iterable<Vote>> getQuestionMark() {
        List<Vote> votes = (List<Vote>) voteService.numberOfQuestionMark();
        if (votes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/findAllRefuse")
    public ResponseEntity<Iterable<Vote>> getRefuse() {
        List<Vote> votes = (List<Vote>) voteService. numberOfRefuse();
        if (votes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }

}
