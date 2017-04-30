package ru.kpfu.itis.mustafin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.mustafin.models.Teacher;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    List<Teacher> findBySportsClubIdAndSectionId(Long sportsClubId, Long     sectionId);
    Teacher getByFullName(String name);
}
