package ru.gbax.lighttraining.dao;

import java.util.List;

import ru.gbax.lighttraining.model.Program;

/**
 * Created by Баянов on 19.01.2015.
 */
public interface IProgramRepository {

    public void addProgram(Program program);
    public Program getProgram(int id);
    public List<Program> getAllPrograms();
    public int getProgramsCount();
    public int updateProgram(Program program);
    public void deleteProgram(Program program);
    public void deleteAllPrograms();

}
