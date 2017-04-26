package ru.kpfu.itis.mustafin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.mustafin.models.Training;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    List<Training> findByTeacher_Id(long teacherId);

    List<Training> findByTeacher_IdOrderByDayAsc(long teacherId);
}
