package edu.crossplatforms.l2.models;

import static edu.crossplatforms.l2.consts.Average.AVERAGE_PASSENGER_WEIGHT;

public class PassengerAircraft extends Airplane{
    private final int maxPassengerCount;
    private final double maxBaggageCountKG;

    public PassengerAircraft(String modelName, double maxLoadKG, double maxFlyHours,
                             double averageSpeed, int maxPassengerCount,
                             double maxBaggageCountKG, AirplaneParams airplaneParams) throws IllegalArgumentException {
        super(modelName, maxLoadKG, maxFlyHours, averageSpeed, airplaneParams);
        if (maxBaggageCountKG + maxPassengerCount * AVERAGE_PASSENGER_WEIGHT.getValue() < maxLoadKG) {
            throw new IllegalArgumentException("This props exceed max plain load");
        }
        this.maxPassengerCount = maxPassengerCount;
        this.maxBaggageCountKG = maxBaggageCountKG;
    }

    public PassengerAircraft(String modelName, double maxLoadKG, double maxFlyHours,
                             double averageSpeed, int maxPassengerCount,
                             double maxBaggageCountKG) throws IllegalArgumentException {
        super(modelName, maxLoadKG, maxFlyHours, averageSpeed);
        if (maxBaggageCountKG + maxPassengerCount * AVERAGE_PASSENGER_WEIGHT.getValue() < maxLoadKG) {
            throw new IllegalArgumentException("This props exceed max plain load");
        }
        this.maxPassengerCount = maxPassengerCount;
        this.maxBaggageCountKG = maxBaggageCountKG;
    }

    public int getMaxPassengerCount() {
        return maxPassengerCount;
    }

    public double getMaxBaggageCountKG() {
        return maxBaggageCountKG;
    }

    @Override
    public int getPassengerCount() {
        return getMaxPassengerCount();
    }
}
