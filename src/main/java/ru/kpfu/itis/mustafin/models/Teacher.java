package ru.kpfu.itis.mustafin.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teachers_id_sequence")
    @SequenceGenerator(name = "teachers_id_sequence", sequenceName = "teachers_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "age")
    private int age;

    @Column(name = "work_experience")
    private int workExperience;

    @Column(name = "regalia")
    private String regalia;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "sports_club_id", nullable = false)
    private SportsClub sportsClub;

    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "teacher")
    private List<Training> trainings = new ArrayList<Training>();

    public Teacher() {

    }

    public Teacher(String fullName, int age, int workExperience, String regalia, String phoneNumber, SportsClub sportsClub, Section section) {
        this.fullName = fullName;
        this.age = age;
        this.workExperience = workExperience;
        this.regalia = regalia;
        this.phoneNumber = phoneNumber;
        this.sportsClub = sportsClub;
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegalia() {
        return regalia;
    }

    public void setRegalia(String regalia) {
        this.regalia = regalia;
    }

    public SportsClub getSportsClub() {
        return sportsClub;
    }

    public void setSportsClub(SportsClub sportsClub) {
        this.sportsClub = sportsClub;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
