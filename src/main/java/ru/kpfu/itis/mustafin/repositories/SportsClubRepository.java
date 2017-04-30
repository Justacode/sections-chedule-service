package ru.kpfu.itis.mustafin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.mustafin.models.SportsClub;

import java.util.List;

@Repository
public interface SportsClubRepository extends JpaRepository<SportsClub, Long> {
    List<SportsClub> findByCity_Id(Long city_id);

    SportsClub getByName(String name);
}
