package com.midterm.midterm.Food;

public class Food {
    private int orderNum;
    private String foodName;
    private double calories;
    private double fat;
    private double carbs;
    
    public Food() {
    }

    public Food(int orderNum, String foodName, double calories, double fat, double carbs) {
        this.orderNum = orderNum;
        this.foodName = foodName;
        this.calories = calories;
        this.fat = fat;
        this.carbs = carbs;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    @Override
    public String toString() {
        return "Food [carbs=" + carbs + ", calories=" + calories + ", fat=" + fat + ", foodName=" + foodName + "]";
    }


    
}
