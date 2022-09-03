package edu.crossplatforms.l2;

import edu.crossplatforms.l2.models.Airplane;
import edu.crossplatforms.l2.utils.LoggerUtil;

import java.util.List;

public class AircompanyManager {
    private static AircompanyManager instance;
    private final List<Airplane> airplanesList;

    private AircompanyManager(List<Airplane> airplanesList) {
        this.airplanesList = airplanesList;
    }

    public static AircompanyManager getInstance(List<Airplane> airplanesList) {
        if (instance == null) {
            instance = new AircompanyManager(airplanesList);
        }
        return instance;
    }

    public void performFlight(double KM, int passengerCount) {
        for (Airplane airplane : airplanesList) {
            if (airplane.tryPerformFlight(KM, passengerCount)) {
                LoggerUtil.log(String.format("Fly performed with airplane %s", airplane.getModelName()));
            };
        }
    }

    private int calculateCompanyMaxPassengerCount() {
        int maxPassengerCount = 0;
        for (Airplane airplane : airplanesList) {
            LoggerUtil.log(String.format("Checking if airplane %s can be used in future for counting", airplane.getModelName()));
            if (airplane.isActiveToUse()) {
                maxPassengerCount += airplane.getPassengerCount();
                LoggerUtil.log(String.format("Airplane %s can be used in future, adding to stats", airplane.getModelName()));
            }
            else {
                LoggerUtil.log(String.format("Airplane %s can't be used in future", airplane.getModelName()));
            }
        }
        return maxPassengerCount;
    }

    private double calculateCompanyMaxLoad() {
        double maxLoad = 0;
        for (Airplane airplane : airplanesList) {
            LoggerUtil.log(String.format("Checking if airplane %s can be used in future for counting", airplane.getModelName()));
            if (airplane.isActiveToUse()) {
                maxLoad += airplane.getMaxLoadKG();
                LoggerUtil.log(String.format("Airplane %s can be used in future, adding to stats", airplane.getModelName()));
            }
            else {
                LoggerUtil.log(String.format("Airplane %s can't be used in future", airplane.getModelName()));
            }
        }
        return maxLoad;
    }
}
