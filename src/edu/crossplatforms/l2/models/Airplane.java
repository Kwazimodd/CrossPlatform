package edu.crossplatforms.l2.models;

public abstract class Airplane {
    private final String modelName;
    private final double maxLoadKG;
    private final double maxFlyHours;
    private final double averageSpeedKMpH;
    private final AirplaneParams airplaneParams;

    public Airplane(String modelName, double maxLoadKG, double maxFlyHours,
                    double averageSpeedKMpH, AirplaneParams airplaneParams) {
        this.modelName = modelName;
        this.maxLoadKG = maxLoadKG;
        this.maxFlyHours = maxFlyHours;
        this.airplaneParams = airplaneParams;
        this.averageSpeedKMpH = averageSpeedKMpH;
    }

    public Airplane(String modelName, double maxLoadKG,
                    double maxFlyHours, double averageSpeed) {
        this.modelName = modelName;
        this.maxLoadKG = maxLoadKG;
        this.maxFlyHours = maxFlyHours;
        this.airplaneParams = new AirplaneParams();
        this.averageSpeedKMpH = averageSpeed;
    }

    public boolean isActiveToUse(double flyHours, int passengerCount) {
        if (passengerCount > getPassengerCount()) {
            return false;
        }
        if (airplaneParams.getFlyHours() + flyHours <= maxFlyHours) {
            airplaneParams.addFlyHours(flyHours);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isActiveToUse() {
        return airplaneParams.getFlyHours() <= maxFlyHours;
    }

    public String getModelName() {
        return modelName;
    }

    public double getMaxLoadKG() {
        return maxLoadKG;
    }

    public abstract int getPassengerCount();

    public boolean tryPerformFlight(double KM, int passengerCount) {
        double flyHours = KM / averageSpeedKMpH;
        return isActiveToUse(flyHours, passengerCount);
    }
}
