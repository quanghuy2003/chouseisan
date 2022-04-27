package com.example.chouseisan3.Repository;

import com.example.chouseisan3.Model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote,Long> {
}
