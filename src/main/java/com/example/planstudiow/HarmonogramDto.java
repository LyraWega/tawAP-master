package com.example.planstudiow;

public class HarmonogramDto {

    private Integer id;

    private String subject;

    private Integer score;

    private String room;

    private Boolean exam;

    public HarmonogramDto() {
    }

    public HarmonogramDto(Integer id, String subject, Integer score, String room, Boolean exam) {
        this.id = id;
        this.subject = subject;
        this.score = score;
        this.room = room;
        this.exam = exam;
    }

    public Integer getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public Integer getScore() {
        return score;
    }

    public String getRoom() {
        return room;
    }

    public Boolean getExam() {
        return exam;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setExam(Boolean exam) {
        this.exam = exam;
    }
}
