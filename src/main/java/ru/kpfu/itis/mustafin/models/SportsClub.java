package ru.kpfu.itis.mustafin.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sports_clubs")
public class SportsClub {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sports_clubs_id_sequence")
    @SequenceGenerator(name = "sports_clubs_id_sequence", sequenceName = "sports_clubs_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "sportsClub")
    private List<Teacher> teachers = new ArrayList<Teacher>();

    public SportsClub(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
