package com.example.chouseisan3.Repository;

import com.example.chouseisan3.Model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VoteRepository extends JpaRepository<Vote,Long> {
      @Query("select schedule from Vote ")
    Iterable<Vote> schedule();
      @Query("select status from Vote ")
    Iterable<Vote> status();
      @Query("select comment from Vote ")
    Iterable<Vote> comment();

    @Query(value = "select e, v.status from Vote v INNER JOIN Event e on v.event.id = e.id")
    Iterable<Vote> findByEventId();
}
