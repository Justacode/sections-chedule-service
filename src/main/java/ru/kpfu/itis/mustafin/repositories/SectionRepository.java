package ru.kpfu.itis.mustafin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.mustafin.models.Section;
import ru.kpfu.itis.mustafin.models.SportsClub;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

    Section getByName(String name);

    @Query(value = "select * from sections s where exists(select * from teachers where s.id = section_id and sports_club_id = ?1);", nativeQuery = true)
    List<Section> findSectionsByClub(long id);
}
