package edu.crossplatforms.l2.models;

import static edu.crossplatforms.l2.consts.Average.AVERAGE_PASSENGER_VOLUME;

public class CargoAircraft extends Airplane{
    private final double maxVolume;

    public CargoAircraft(String modelName, double maxLoadKG, double maxFlyHours,
                         double averageSpeedKMpH, double maxVolume, AirplaneParams airplaneParams) {
        super(modelName, maxLoadKG, maxFlyHours, averageSpeedKMpH, airplaneParams);
        this.maxVolume = maxVolume;
    }

    public CargoAircraft(String modelName, double maxLoadKG,
                         double maxFlyHours, double averageSpeedKMpH, double maxVolume) {
        super(modelName, maxLoadKG, maxFlyHours, averageSpeedKMpH);
        this.maxVolume = maxVolume;

    }

    @Override
    public int getPassengerCount() {
        return (int) (maxVolume * AVERAGE_PASSENGER_VOLUME.getValue() * 0.9);
    }
}
