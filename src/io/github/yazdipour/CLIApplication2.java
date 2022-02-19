package io.github.yazdipour;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CLIApplication2 {
    /**
     * Q4. Create a second command line application that fits the model parameters from a given
     * data file and outputs the corresponding model parameters. There is no need to write
     * a real fitter class; for testing, you can use the mock implementation given below.
     *
     * @param args data file path
     */
    public static void main(String[] args) {
        // TODO this task was not really clear to me.
        if (args.length != 1) {
            System.out.println("Usage: java CLIApplication2 <data-filename>");
            System.exit(1);
        }
        String dataFilePath = args[0];
        Data data = new Data();
        try {
            Files.readString(Path.of(dataFilePath)).lines().forEach(line -> {
                if (!line.startsWith("#")) {
                    String[] parts = line.split("\\s+");
                    double freq = Double.parseDouble(parts.length == 2 ? parts[0] : parts[1]);
                    double power = Double.parseDouble(parts.length == 2 ? parts[1] : parts[2]);
                    data.add(freq, power);
                }
            });
        } catch (IOException e) {
            System.err.println("Error reading data file: " + e.getMessage());
        }
        try {
            HarmonicOscillatorModel mockedModel = new HarmonicOscillatorModel(null);
            HarmonicOscillatorParameters fittedToDate = new MockFitter().fitToData(mockedModel, data);
            System.out.println("Model parameters:");
            System.out.println("  Amplitude: " + fittedToDate.getAmplitude());
            System.out.println("  Omega0: " + fittedToDate.getOmega0());
            System.out.println("  QFactor: " + fittedToDate.getqFactor());
        } catch (Exception | FitFailedException e) {
            e.printStackTrace();
        }
    }
}
