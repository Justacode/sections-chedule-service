package ru.kpfu.itis.mustafin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.mustafin.models.Section;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
    Section getByName(String name);
//    @Query("select s from Section s, Teacher t where ")
//    List<Section> findSectionsByClub(@Param("sportsclubid") long sportsClubId);

}
