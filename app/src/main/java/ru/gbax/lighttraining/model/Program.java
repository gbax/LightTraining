package ru.gbax.lighttraining.model;

/**
 * Created by Баянов on 17.01.2015.
 */
public class Program {

    private Integer id;
    private String name;
    private String desription;

    public Program() {
    }

    public Program(String name,String desription ) {
        this.name = name;
        this.desription = desription;
    }

    public Program(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }
}
