package ru.kpfu.itis.mustafin.services;

import ru.kpfu.itis.mustafin.models.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher addTeacher(Teacher teacher);

    List<Teacher> getAll();

    Teacher getById(long id);

    List<Teacher> getBySportsClubAndSection(long sportsClubId, long sectionId);

    void delete(long id);
}
