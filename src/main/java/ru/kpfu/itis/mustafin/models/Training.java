package ru.kpfu.itis.mustafin.models;

import javax.persistence.*;

@Entity
@Table(name = "trainings")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainings_id_sequence")
    @SequenceGenerator(name = "trainings_id_sequence", sequenceName = "trainings_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "day")
    private int day;

    @Column(name = "time")
    private String time;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    public Training() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
