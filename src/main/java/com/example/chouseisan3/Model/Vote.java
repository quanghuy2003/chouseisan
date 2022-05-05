package com.example.chouseisan3.Model;

import javax.persistence.*;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "eventId")
    private Event event;

//    @ManyToOne
//    @JoinColumn(name = "selecttId")
//    private Selectt selectt;

    private String Schedule;
    private String Selection;
    private String comment;

    public Vote() {
    }

    public Vote(Long id, Event event, String schedule, String selection, String comment) {
        this.id = id;
        this.event = event;
        Schedule = schedule;
        Selection = selection;
        this.comment = comment;
    }

//    public Vote(Long id, Event event, Selectt selectt, String schedule, String selection, String comment) {
//        this.id = id;
//        this.event = event;
//        this.selectt = selectt;
//        Schedule = schedule;
//        Selection = selection;
//        this.comment = comment;
//    }
//
//    public Selectt getSelectt() {
//        return selectt;
//    }
//
//    public void setSelectt(Selectt selectt) {
//        this.selectt = selectt;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getSchedule() {
        return Schedule;
    }

    public void setSchedule(String schedule) {
        Schedule = schedule;
    }

    public String getSelection() {
        return Selection;
    }

    public void setSelection(String selection) {
        Selection = selection;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
