package com.example.menuManagement.restEndpoints;

public class Meal {
    private String typeOfMeal;
    private float costOfMeal;

    public Meal(String typeOfMeal, float costOfMeal) {
        this.typeOfMeal = typeOfMeal;
        this.costOfMeal = costOfMeal;
    }

    public String getTypeOfMeal() {
        return typeOfMeal;
    }

    public void setTypeOfMeal(String typeOfMeal) {
        this.typeOfMeal = typeOfMeal;
    }

    public float getCostOfMeal() {
        return costOfMeal;
    }

    public void setCostOfMeal(float costOfMeal) {
        this.costOfMeal = costOfMeal;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "typeOfMeal='" + typeOfMeal + '\'' +
                ", costOfMeal=" + costOfMeal +
                '}';
    }
}
