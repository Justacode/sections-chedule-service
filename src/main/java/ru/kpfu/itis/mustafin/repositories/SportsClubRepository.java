package ru.kpfu.itis.mustafin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.mustafin.models.SportsClub;

@Repository
public interface SportsClubRepository extends JpaRepository<SportsClub, Long> {
}
