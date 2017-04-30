package ru.kpfu.itis.mustafin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.mustafin.models.Training;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    List<Training> findByTeacher_Id(Long teacherId);

    List<Training> findByTeacher_IdOrderByDayAsc(Long teacherId);

    Training findByTeacher_IdAndDayAndTime(Long teacherId, int day, String time);
}
