package com.example.chouseisan3.Service;

import com.example.chouseisan3.Model.Vote;
import org.springframework.data.jpa.repository.Query;

public interface IVoteService extends IService<Vote> {
    Iterable<Vote> schedule();
    Iterable<Vote> status();
    Iterable<Vote> comment();

    Iterable<Vote> findByEvent();

}
