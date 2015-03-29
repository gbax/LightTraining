package ru.gbax.lighttraining.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ru.gbax.lighttraining.model.Exercise;

public class ExerciseRepository implements IExerciseRepository {

    private DBHelper dbHelper;

    public ExerciseRepository(Context context) {
        dbHelper = new DBHelper(context);
    }

    public static final String TABLE_NAME = "exercise";
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String CHOOSE_WEIGHT = "choose_weight";
    public static final String MAX_WEIGHT = "max_weight";
    public static final String MIN_WEIGHT = "min_weight";
    public static final String STEP_WEIGHT = "step_weight";
    public static final String MAX_REPS = "max_repeats";
    public static final String MIN_REPS = "min_repeats";
    public static final String ORDER = "ordering";


    @Override
    public void addExercise(Exercise exercise) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, exercise.getName());
        values.put(CHOOSE_WEIGHT, exercise.getChooseWeight());
        values.put(MAX_WEIGHT, exercise.getMaxWeight());
        values.put(MIN_WEIGHT, exercise.getMinWeight());
        values.put(STEP_WEIGHT, exercise.getStepWeight());
        values.put(MAX_REPS, exercise.getMaxRepeats());
        values.put(MIN_REPS, exercise.getMinRepeats());
        values.put(ORDER, exercise.getOrder());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public Exercise getExercise(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                new String[]{
                        KEY_ID,
                        KEY_NAME,
                        CHOOSE_WEIGHT,
                        MAX_WEIGHT,
                        MIN_WEIGHT,
                        STEP_WEIGHT,
                        MAX_REPS,
                        MIN_REPS,
                        ORDER
                },
                KEY_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Exercise exercise = null;
        if (cursor != null) {
            exercise = new Exercise(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    Boolean.parseBoolean(cursor.getString(2)),
                    Integer.parseInt(cursor.getString(0)),
                    Integer.parseInt(cursor.getString(0)),
                    Integer.parseInt(cursor.getString(0)),
                    Integer.parseInt(cursor.getString(0)),
                    Integer.parseInt(cursor.getString(0)),
                    Integer.parseInt(cursor.getString(0))
            );
        }
        return exercise;
    }

    @Override
    public List<Exercise> getAllExercises() {
        List<Exercise> exerciseList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME + " ORDER BY " + ORDER + " ASC";

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Exercise exercise = new Exercise();
                exercise.setId(Integer.parseInt(cursor.getString(0)));
                exercise.setName(cursor.getString(1));

                exerciseList.add(exercise);
            } while (cursor.moveToNext());
        }

        return exerciseList;
    }

    @Override
    public int getExercisesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    @Override
    public int updateExercise(Exercise exercise) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, exercise.getName());
        values.put(CHOOSE_WEIGHT, exercise.getChooseWeight());
        values.put(MAX_WEIGHT, exercise.getMaxWeight());
        values.put(MIN_WEIGHT, exercise.getMinWeight());
        values.put(STEP_WEIGHT, exercise.getStepWeight());
        values.put(MAX_REPS, exercise.getMaxRepeats());
        values.put(MIN_REPS, exercise.getMinRepeats());
        values.put(ORDER, exercise.getOrder());

        return db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{String.valueOf(exercise.getId())});
    }

    @Override
    public void deleteExercise(Exercise exercise) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TABLE_NAME,
                KEY_ID + " = ?",
                new String[]{String.valueOf(exercise.getId())}
        );
        db.close();
    }

    @Override
    public void deleteAllExercises() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }
}
