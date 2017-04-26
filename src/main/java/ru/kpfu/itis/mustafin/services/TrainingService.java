package ru.kpfu.itis.mustafin.services;

import ru.kpfu.itis.mustafin.models.Training;

import java.util.List;

public interface TrainingService {

    Training addTraining(Training training);

    List<Training> getAll();

    Training getById(long id);

    List<Training> getByTeacher(long teacherId);

    List<Training> getByTeacherSorted(long teacherId);

    void delete(long id);
}
