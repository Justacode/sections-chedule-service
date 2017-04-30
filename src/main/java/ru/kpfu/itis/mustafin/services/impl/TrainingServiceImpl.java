package ru.kpfu.itis.mustafin.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.mustafin.models.Training;
import ru.kpfu.itis.mustafin.repositories.TrainingRepository;
import ru.kpfu.itis.mustafin.services.TrainingService;

import java.util.List;

@Service
@Transactional
public class TrainingServiceImpl implements TrainingService {

    private TrainingRepository repository;

    @Autowired
    TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.repository = trainingRepository;
    }

    @Override
    public Training addTraining(Training training) {
        return repository.saveAndFlush(training);
    }

    @Override
    public List<Training> getAll() {
        return repository.findAll();
    }

    @Override
    public Training getById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Training> getByTeacher(Long teacherId) {
        return repository.findByTeacher_Id(teacherId);
    }

    @Override
    public List<Training> getByTeacherSorted(Long teacherId) {
        return repository.findByTeacher_IdOrderByDayAsc(teacherId);
    }

    @Override
    public Training getByTeacherAndDayAndTime(Long teacherId, int day, String time) {
        return repository.findByTeacher_IdAndDayAndTime(teacherId, day, time);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
