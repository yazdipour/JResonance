package io.github.yazdipour;

import java.util.Map;

public class Data {
    private final Map<Double, Double> frequencyMapToPower = new java.util.HashMap<>();

    public Map<Double, Double> getFrequencyMapToPower() {
        return frequencyMapToPower;
    }

    public void add(double freq, double power) {
        frequencyMapToPower.put(freq, power);
    }
}
