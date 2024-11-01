package com.example.menuManagement.beanCreation.configure;

import java.time.LocalTime;
import java.util.Locale;

public class Recipe {
    private String typeOfDish;
    private int spoonsPerDish;
    private static float price;
    private LocalTime tm = LocalTime.now();

    public Recipe(String typeOfDish, int spoonsPerDish) {
        System.out.println("Recipe instance created " + tm);
        this.typeOfDish = typeOfDish;
        this.spoonsPerDish = spoonsPerDish;
    }

    public String getTypeOfDish() {
        return typeOfDish;
    }

    public void setTypeOfDish(String typeOfDish) {
        this.typeOfDish = typeOfDish;
    }

    public int getSpoonsPerDish() {
        return spoonsPerDish;
    }

    public void setSpoonsPerDish(int spoonsPerDish) {
        this.spoonsPerDish = spoonsPerDish;
    }

    public static float getPrice() {
        return price;
    }

    public static void setPrice(float price) {
        Recipe.price = price;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "typeOfDish='" + typeOfDish + '\'' +
                ", spoonsPerDish=" + spoonsPerDish +
                '}';
    }
}
