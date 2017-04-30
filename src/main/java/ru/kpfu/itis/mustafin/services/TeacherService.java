package ru.kpfu.itis.mustafin.services;

import ru.kpfu.itis.mustafin.models.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher addTeacher(Teacher teacher);

    List<Teacher> getAll();

    Teacher getById(Long id);

    Teacher getByName(String name);

    List<Teacher> getBySportsClubAndSection(Long sportsClubId, Long sectionId);

    void delete(Long id);
}
