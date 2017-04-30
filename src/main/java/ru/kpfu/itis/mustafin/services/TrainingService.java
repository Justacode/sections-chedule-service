package ru.kpfu.itis.mustafin.services;

import ru.kpfu.itis.mustafin.models.Training;

import java.util.List;

public interface TrainingService {

    Training addTraining(Training training);

    List<Training> getAll();

    Training getById(Long id);

    List<Training> getByTeacher(Long teacherId);

    Training getByTeacherAndDayAndTime(Long teacherId, int day, String time);

    List<Training> getByTeacherSorted(Long teacherId);

    void delete(Long id);
}
