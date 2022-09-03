package edu.crossplatforms.l2.models;

public class AirplaneParams {
    private double flyHours;

    AirplaneParams() {
        this.flyHours = 0;
    }

    AirplaneParams(double flyHours) {
        this.flyHours = flyHours;
    }

    public double getFlyHours() {
        return flyHours;
    }

    public void setFlyHours(double flyHours) {
        this.flyHours = flyHours;
    }

    public void addFlyHours(double hoursToAdd) {
        this.flyHours += hoursToAdd;
    }
}
