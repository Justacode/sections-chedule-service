package ru.kpfu.itis.mustafin.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.mustafin.models.Teacher;
import ru.kpfu.itis.mustafin.repositories.TeacherRepository;
import ru.kpfu.itis.mustafin.services.TeacherService;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService{

    private TeacherRepository repository;

    public TeacherServiceImpl(TeacherRepository teacherRepository){
        this.repository = teacherRepository;
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return repository.saveAndFlush(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return repository.findAll();
    }

    @Override
    public Teacher getById(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Teacher> getBySportsClubAndSection(long sportsClubId, long sectionId) {
        return repository.findBySportsClubIdAndSectionId(sportsClubId, sectionId);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
