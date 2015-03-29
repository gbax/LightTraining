package ru.gbax.lighttraining.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ru.gbax.lighttraining.model.Program;

/**
 * Created by Баянов on 19.01.2015.
 */
public class ProgramRepository implements IProgramRepository {

    private DBHelper dbHelper;

    public ProgramRepository(Context context) {
        dbHelper = new DBHelper(context);
    }

    public static final String TABLE_NAME = "program";
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String DESCRIPTION = "description";

    @Override
    public void addProgram(Program program) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, program.getName());
        values.put(DESCRIPTION, program.getDesription());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public Program getProgram(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{ProgramRepository.KEY_ID,
                        KEY_NAME}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Program program = null;
        if (cursor != null) {
            program = new Program(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
        }

        return program;
    }

    @Override
    public List<Program> getAllPrograms() {
        List<Program> programList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Program program = new Program();
                program.setId(Integer.parseInt(cursor.getString(0)));
                program.setName(cursor.getString(1));

                programList.add(program);
            } while (cursor.moveToNext());
        }

        return programList;
    }

    @Override
    public int getProgramsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    @Override
    public int updateProgram(Program program) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, program.getName());

        return db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{String.valueOf(program.getId())});
    }

    @Override
    public void deleteProgram(Program program) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TABLE_NAME,
                KEY_ID + " = ?",
                new String[]{String.valueOf(program.getId())}
        );
        db.close();
    }

    @Override
    public void deleteAllPrograms() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }

}
