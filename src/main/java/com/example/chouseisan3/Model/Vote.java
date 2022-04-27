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
    private int tick;
    private int questionMark;

    private int refuse;

    public Vote() {
    }

    public Vote(Long id, Event event, int tick, int questionMark, int refuse) {
        this.id = id;
        this.event = event;
        this.tick = tick;
        this.questionMark = questionMark;
        this.refuse = refuse;
    }

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

    public int getTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

    public int getQuestionMark() {
        return questionMark;
    }

    public void setQuestionMark(int questionMark) {
        this.questionMark = questionMark;
    }

    public int getRefuse() {
        return refuse;
    }

    public void setRefuse(int refuse) {
        this.refuse = refuse;
    }
}
