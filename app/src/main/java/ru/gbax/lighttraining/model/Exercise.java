package ru.gbax.lighttraining.model;

/**
 * Created by Баянов on 04.02.2015.
 */
public class Exercise {

    private Integer id;
    private String name;
    private Boolean chooseWeight = false;
    private Integer minWeight;
    private Integer maxWeight;
    private Integer stepWeight;
    private Integer minRepeats;
    private Integer maxRepeats;
    private Integer order;

    public Exercise() {
    }

    public Exercise(String name) {
        this.name = name;
    }

    public Exercise(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Exercise(Integer id,
                    String name,
                    Boolean chooseWeight,
                    Integer minWeight,
                    Integer maxWeight,
                    Integer stepWeight,
                    Integer minRepeats,
                    Integer maxRepeats,
                    Integer order) {
        this.id = id;
        this.name = name;
        this.chooseWeight = chooseWeight;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.stepWeight = stepWeight;
        this.minRepeats = minRepeats;
        this.maxRepeats = maxRepeats;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getChooseWeight() {
        return chooseWeight;
    }

    public void setChooseWeight(Boolean chooseWeight) {
        this.chooseWeight = chooseWeight;
    }

    public Integer getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(Integer minWeight) {
        this.minWeight = minWeight;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Integer getStepWeight() {
        return stepWeight;
    }

    public void setStepWeight(Integer stepWeight) {
        this.stepWeight = stepWeight;
    }

    public Integer getMinRepeats() {
        return minRepeats;
    }

    public void setMinRepeats(Integer minRepeats) {
        this.minRepeats = minRepeats;
    }

    public Integer getMaxRepeats() {
        return maxRepeats;
    }

    public void setMaxRepeats(Integer maxRepeats) {
        this.maxRepeats = maxRepeats;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }


}
