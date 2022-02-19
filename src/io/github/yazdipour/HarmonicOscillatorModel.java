package io.github.yazdipour;

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
}
