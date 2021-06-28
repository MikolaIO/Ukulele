package com.mproductions.views;

import com.github.psambit9791.jdsp.io.Wav;
import com.github.psambit9791.jdsp.misc.Plotting;
import com.github.psambit9791.jdsp.misc.UtilMethods;
import com.github.psambit9791.wavfile.WavFileException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Hashtable;

public class AnalyzerLogic {

    @FXML
    private Button btnC;
    @FXML
    private Button btnG;

    private String pathC = "src/main/resources/com/mproductions/views/sound/C.wav";
    private String pathG = "src/main/resources/com/mproductions/views/sound/G.wav";

    private double[] signal;

    public void InitAnalyzer()
    {
        btnC.setOnMouseClicked((MouseEvent event) -> {
            try {
                GetInput(pathC);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (WavFileException e) {
                e.printStackTrace();
            }
            CreatePlot();
        });
        btnG.setOnMouseClicked((MouseEvent event) -> {
            try {
                GetInput(pathG);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (WavFileException e) {
                e.printStackTrace();
            }
            CreatePlot();
        });
    }

    private void GetInput(String path) throws IOException, WavFileException {
        Wav objRead1 = new Wav();
        objRead1.readWav(path);
        Hashtable<String, Long> propsOut = objRead1.getProperties();
        double[][] signal2d = objRead1.getData("int");
        signal = new double[signal2d.length];
        for (int i = 0; i < signal2d.length; i++)
            signal[i]=signal2d[i][0];
    }

    private void CreatePlot()
    {
        Plotting fig = new Plotting(600, 500, "Sample Figure", "Time", "Signal");
        fig.initialisePlot();
        fig.addSignal("One channel", signal, true);
        fig.plot();
    }

    /*try (
                PrintStream output = new PrintStream("output.txt")) {
            for (int i = 0; i < signal2d.length; i++) {
                String s= "";
                for (int j = 0; j < signal2d[i].length; j++) {
                    s+=signal2d[i][j] + " ";
                }
                output.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
}
