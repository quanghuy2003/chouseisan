package com.example.chouseisan3.Service;

import com.example.chouseisan3.Model.Vote;
import com.example.chouseisan3.Repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class VoteService implements IVoteService{

    @Autowired
    private VoteRepository voteRepository;
    @Override
    public void save(Vote vote) {
        voteRepository.save(vote);
    }

    @Override
    public Iterable<Vote> findAll() {
        return voteRepository.findAll();
    }

    @Override
    public Optional<Vote> findById(Long id) {
        return voteRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        voteRepository.deleteById(id);
    }

    @Override
    public Iterable<Vote> schedule() {
        return voteRepository.schedule();
    }

    @Override
    public Iterable<Vote> status() {
        return voteRepository.status();
    }

    @Override
    public Iterable<Vote> comment() {
        return voteRepository.comment();
    }

    @Override
    public Iterable<Vote> findByEventId() {
        return  voteRepository.findByEventId();
    }
//
//    @Override
//    public Iterable<Vote> numberOfTick() {
//        return voteRepository.numberOfTick();
//    }
//
//    @Override
//    public Iterable<Vote> numberOfQuestionMark() {
//        return voteRepository.numberOfQuestionMark();
//    }
//
//    @Override
//    public Iterable<Vote> numberOfRefuse() {
//        return voteRepository.numberOfRefuse();
//    }
}
