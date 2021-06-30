package com.mproductions.views;

import com.github.psambit9791.jdsp.io.Wav;
import com.github.psambit9791.jdsp.misc.Plotting;
import com.github.psambit9791.jdsp.signal.peaks.FindPeak;
import com.github.psambit9791.jdsp.signal.peaks.Peak;
import com.github.psambit9791.wavfile.WavFileException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Hashtable;

public class AnalyzerLogic {

    @FXML
    private Button btnC;
    @FXML
    private Button btnG;

    private final String pathC = "src/main/resources/com/mproductions/views/sound/C.wav";
    private final String pathG = "src/main/resources/com/mproductions/views/sound/G.wav";

    private double[] signal;

    public void InitAnalyzer()
    {
        btnC.setOnMouseClicked((MouseEvent event) -> {
            try {
                GetInput(pathC);
            } catch (IOException | WavFileException e) {
                e.printStackTrace();
            }
            DetectPeaks();
            CreatePlot();
        });
        btnG.setOnMouseClicked((MouseEvent event) -> {
            try {
                GetInput(pathG);
            } catch (IOException | WavFileException e) {
                e.printStackTrace();
            }
            DetectPeaks();
            CreatePlot();
        });
    }

    private void GetInput(String path) throws IOException, WavFileException {
        Wav objRead1 = new Wav();
        objRead1.readWav(path);
        Hashtable<String, Long> propsOut = objRead1.getProperties();

        double[][] signal2d = objRead1.getData("double");
        signal = new double[signal2d.length];
        for (int i = 0; i < signal2d.length; i++)
            signal[i]=signal2d[i][0];
    }

    private void CreatePlot()
    {
        Plotting fig = new Plotting(1000, 700, "WAV Amplitude", "Time", "Signal");
        fig.initialisePlot();
        fig.addSignal("First channel", signal, true);
        fig.plot();
    }

    private void DetectPeaks()
    {
        FindPeak fp = new FindPeak(signal);
        Peak out = fp.detectPeaks();
        int[] peaks = out.getPeaks();

        try (
                PrintStream output = new PrintStream("output.txt")) {
            for (int peak : peaks)
                output.println(peak + "\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
