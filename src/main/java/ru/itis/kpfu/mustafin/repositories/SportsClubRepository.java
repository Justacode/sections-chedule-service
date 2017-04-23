package ru.itis.kpfu.mustafin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.kpfu.mustafin.models.SportsClub;

public interface SportsClubRepository extends JpaRepository<SportsClub, Long> {
}
