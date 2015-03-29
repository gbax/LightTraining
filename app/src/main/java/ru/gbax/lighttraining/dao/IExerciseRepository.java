package ru.gbax.lighttraining.dao;

import java.util.List;

import ru.gbax.lighttraining.model.Exercise;

/**
 * Created by Баянов on 05.02.2015.
 */
public interface IExerciseRepository {

    public void addExercise(Exercise exercise);
    public Exercise getExercise(int id);
    public List<Exercise> getAllExercises();
    public int getExercisesCount();
    public int updateExercise(Exercise exercise);
    public void deleteExercise(Exercise exercise);
    public void deleteAllExercises();

}
