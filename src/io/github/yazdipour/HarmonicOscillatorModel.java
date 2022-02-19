package io.github.yazdipour;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class HarmonicOscillatorModel implements ResonanceModel {
    public HarmonicOscillatorParameters parameters;

    public HarmonicOscillatorModel(HarmonicOscillatorParameters parameters) {
        this.parameters = parameters;
    }

    /**
     * Task1. Implement a class HarmonicOscillatorModel (deriving from the ResonanceModel interface below)
     * representing the resonance model for a single harmonic oscillator. Note
     * that the mathematical formulation uses ω, while ResonanceModel works with frequency f.
     */
    @Override
    public double evaluateSpectralPowerAt(double frequency, HarmonicOscillatorParameters parameters) {
        double omega = 2 * Math.PI * frequency;
        double omegaSqr = Math.pow(omega, 2);
        double omega0Sqr = Math.pow(parameters.getOmega0(), 2);
        double denominator = Math.pow(omegaSqr - omega0Sqr, 2) + (omega0Sqr * omegaSqr) / parameters.getqFactor();
        if (denominator == 0.)
            throw new IllegalArgumentException("Dividing by zero.");
        return Math.pow(parameters.getAmplitude(), 2) / denominator;
    }


    /**
     * Q2. Provide a method to write data from a HarmonicOscillatorModel instance to a file.
     * Output should be in column format, e.g.
     * # Frequency Spectral_Power
     * 100.0 1.23e-12
     * 200.0 1.81e-10
     * 300.0 6.14e-10
     * [...]
     * 10000.0 7.11e-17
     * <p>
     * Calculate harmonic oscillator and write to file
     *
     * @param fileName      output filename
     * @param startFreq     starting frequency
     * @param stopFreq      stopping frequency
     * @param stepFreq      step frequency
     */
    public void writeToFile(String fileName, double startFreq, double stopFreq, double stepFreq) throws IOException {
        PrintWriter writer = new PrintWriter(fileName, StandardCharsets.UTF_8);
        writer.println("# Frequency\tSpectral_Power");
        for (double freq = startFreq; freq <= stopFreq; freq += stepFreq) {
            double spectralPower = evaluateSpectralPowerAt(startFreq, parameters);
            writer.printf("%7.1f\t\t%1.2e\n", freq, spectralPower);
        }
        writer.close();
        System.out.printf("Output file: %s\n", fileName);
    }
}
