package ru.itis.kpfu.mustafin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.kpfu.mustafin.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
