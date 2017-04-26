package ru.kpfu.itis.mustafin.util;

import ru.kpfu.itis.mustafin.models.Training;

import java.util.*;

public class TrainingScheduleConstructor {

    public static Map<String, List<String>> construct(List<Training> trainings) {
        Map<String, List<String>> result = new HashMap<>(5);

        for (Training training : trainings) {
            String time = training.getTime();

            if (!result.containsKey(time)) {
                String[] events = new String[6];
                Arrays.fill(events, "-");
                result.put(time, new ArrayList<>(Arrays.asList(events)));
            }

            List<String> trainingsByTime = result.get(time);
            int dayIndex = training.getDay()-1;

            trainingsByTime.set(dayIndex , "+");
            result.put(time, trainingsByTime);
        }

        return result;
    }
}
