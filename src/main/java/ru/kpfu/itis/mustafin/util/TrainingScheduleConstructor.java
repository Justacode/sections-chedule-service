package ru.kpfu.itis.mustafin.util;

import ru.kpfu.itis.mustafin.models.Training;

import java.util.*;

public class TrainingScheduleConstructor {

    public static Map<String, List<Long>> construct(List<Training> trainings) {
        Map<String, List<Long>> result = new HashMap<>(5);

        for (Training training : trainings) {
            String time = training.getTime();

            if (!result.containsKey(time)) {
                Long[] events = new Long[6];
                Arrays.fill(events, (long) 0);
                result.put(time, new ArrayList<>(Arrays.asList(events)));
            }

            List<Long> trainingsByTime = result.get(time);
            int dayIndex = training.getDay() - 1;
            Long trainingId = training.getId();

            trainingsByTime.set(dayIndex, trainingId);
            result.put(time, trainingsByTime);
        }

        return result;
    }
}
