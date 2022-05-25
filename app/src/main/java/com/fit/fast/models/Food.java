package com.fit.fast.models;

public class Food {

    private String name;
    private String quantity;
    private String calories;
    private String protein;
    private String carb;
    private String fats;
    private String fibers;
    private boolean selected = false;
    private String selectedQuantity;


    public Food(String name, String quantity, String calories, String protein, String carb, String fats, String fibers) {
        this.name = name;
        this.quantity = quantity;
        this.calories = calories;
        this.protein = protein;
        this.carb = carb;
        this.fats = fats;
        this.fibers = fibers;
    }


    public Food() {
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", calories='" + calories + '\'' +
                ", protein='" + protein + '\'' +
                ", carb='" + carb + '\'' +
                ", fats='" + fats + '\'' +
                ", fibers='" + fibers + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getCarb() {
        return carb;
    }

    public void setCarb(String carb) {
        this.carb = carb;
    }

    public String getFats() {
        return fats;
    }

    public void setFats(String fats) {
        this.fats = fats;
    }

    public String getFibers() {
        return fibers;
    }

    public void setFibers(String fibers) {
        this.fibers = fibers;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public double getSelectedQuantity() {
        return Double.parseDouble(selectedQuantity.trim());
    }

    public void setSelectedQuantity(String selectedQuantity) {
        this.selectedQuantity = selectedQuantity;
    }

    public double getRealQuantity() {
        return getSelectedQuantity() / Double.parseDouble(quantity.trim());
    }
}
