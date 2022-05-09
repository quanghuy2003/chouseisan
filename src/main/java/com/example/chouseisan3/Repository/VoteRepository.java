package com.example.chouseisan3.Repository;

import com.example.chouseisan3.Model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VoteRepository extends JpaRepository<Vote,Long> {
//    @Query("select count(tick)from Vote where tick>0")
//    Iterable<Vote> numberOfTick();
//
//    @Query("select count(questionMark)from Vote where questionMark>0")
//    Iterable<Vote> numberOfQuestionMark();
//
//    @Query("select count(refuse)from Vote where refuse>0")
//    Iterable<Vote> numberOfRefuse();

      @Query("select schedule from Vote ")
    Iterable<Vote> schedule();
      @Query("select status from Vote ")
    Iterable<Vote> status();
      @Query("select comment from Vote ")
    Iterable<Vote> comment();

    @Query(value = "select e, v.status from Vote v INNER JOIN Event e on v.event.id = e.id")
    Iterable<Vote> findByEventId();
}
