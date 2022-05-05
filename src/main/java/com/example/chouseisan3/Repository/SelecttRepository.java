//package com.example.chouseisan3.Repository;
//
//import com.example.chouseisan3.Model.Selectt;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//public interface SelecttRepository extends JpaRepository<Selectt, Long> {
//    @Query("select count(tick)from Selectt where tick>0")
//    Iterable<Selectt> numberOfTick();
//
//    @Query("select count(questionMark)from Selectt where questionMark>0")
//    Iterable<Selectt> numberOfQuestionMark();
//
//    @Query("select count(refuse)from Selectt where refuse>0")
//    Iterable<Selectt> numberOfRefuse();
//}
