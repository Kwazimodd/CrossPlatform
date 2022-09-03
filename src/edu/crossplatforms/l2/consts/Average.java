package edu.crossplatforms.l2.consts;

public enum Average {
    AVERAGE_PASSENGER_WEIGHT(86),
    AVERAGE_PASSENGER_VOLUME(62);

    private final double value;

    Average(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
