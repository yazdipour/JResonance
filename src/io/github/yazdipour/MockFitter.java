package io.github.yazdipour;

public final class MockFitter implements Fitter {
    @Override
    public HarmonicOscillatorParameters fitToData(HarmonicOscillatorModel model, Data data) throws FitFailedException {
        double amplitude = 1.0e-9;
        double omega0 = 1000.0;
        double qFactor = 10.0;
        return new HarmonicOscillatorParameters(amplitude, omega0, qFactor);
    }
}