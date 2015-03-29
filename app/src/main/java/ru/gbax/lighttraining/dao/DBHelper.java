package ru.gbax.lighttraining.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Баянов on 05.02.2015.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "LightTraining";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createProgramTable =
                "CREATE TABLE " + ProgramRepository.TABLE_NAME + "("
                        + ProgramRepository.KEY_ID + " INTEGER PRIMARY KEY,"
                        + ProgramRepository.KEY_NAME + " TEXT, "
                        + ProgramRepository.DESCRIPTION + " TEXT "
                        +")";
        db.execSQL(createProgramTable);
        String createExerciseTable =
                "CREATE TABLE " + ExerciseRepository.TABLE_NAME + "("
                        + ExerciseRepository.KEY_ID + " INTEGER PRIMARY KEY,"
                        + ExerciseRepository.KEY_NAME + " TEXT, "
                        + ExerciseRepository.CHOOSE_WEIGHT + " INTEGER, "
                        + ExerciseRepository.MAX_WEIGHT + " INTEGER, "
                        + ExerciseRepository.MIN_WEIGHT + " INTEGER, "
                        + ExerciseRepository.STEP_WEIGHT + " INTEGER, "
                        + ExerciseRepository.MAX_REPS + " INTEGER, "
                        + ExerciseRepository.MIN_REPS + " INTEGER, "
                        + ExerciseRepository.ORDER + " INTEGER "
                        +")";
        db.execSQL(createExerciseTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ProgramRepository.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ExerciseRepository.TABLE_NAME);

        onCreate(db);
    }

}
