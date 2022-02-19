package io.github.yazdipour;

import java.io.IOException;

public class CLIApplication {

    /**
     * Q3. Create a command line application that receives the parameters for a given resonance
     * model on the command line and calls the method from step 2 to generate an output file.
     * @param args input from user: amplitude omega0 qfactor filename
     */
    public static void main(String[] args) {
        if (args.length < 4) {
            System.err.println("Err, Please enter: amplitude omega0 qfactor filename");
            System.exit(1);
        }
        double amplitude = 0;
        double omega0 = 0;
        double qFactor = 0;
        try {
            amplitude = Double.parseDouble(args[0]);
            omega0 = Double.parseDouble(args[1]);
            qFactor = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("Err, Please enter: amplitude omega q-factor properly");
            System.exit(1);
        }
        String filename = args[3];
        try {
            HarmonicOscillatorParameters parameters = new HarmonicOscillatorParameters(amplitude, omega0, qFactor);
            HarmonicOscillatorModel oscillator = new HarmonicOscillatorModel(parameters);
            oscillator.writeToFile(filename);
        } catch (FitFailedException e) {
            System.err.println(e.getMessage());
        } catch (IOException ex) {
            System.err.println("Err, Could not write to file");
        }
    }
}
