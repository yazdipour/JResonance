package io.github.yazdipour;

public class HarmonicOscillatorParameters {

    private final double amplitude;
    private final double omega0;
    private final double qFactor;

    /**
     * Constructor
     *
     * @param amplitude The amplitude of the oscillator
     * @param omega0    The value for Omega 0 of the oscillator
     * @param qFactor   Q factor of the oscillator
     */
    public HarmonicOscillatorParameters(
            double amplitude, double omega0, double qFactor)
            throws FitFailedException {
        if (amplitude <= 0) throw new FitFailedException("Parameter out of range: Amplitude must be > 0.");
        this.amplitude = amplitude;

        if (omega0 <= 0) throw new FitFailedException("Parameter out of range: Omega0 must be > 0.");
        this.omega0 = omega0;

        if (qFactor <= 0. || qFactor >= 100.) throw new FitFailedException("Parameter out of range:  QFactor must be 0. < q < 100.");
        this.qFactor = qFactor;
    }

    public double getqFactor() {
        return qFactor;
    }

    public double getOmega0() {
        return omega0;
    }

    public double getAmplitude() {
        return amplitude;
    }
}
