// Walija Ihsan, UCID: 30172565
// Main class, containing the runnable main args class, and main control buttons
package lab5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;
import java.io.IOException;

/**
 * Main class, containing runnable main args class, which will run the entire program, as well as start and stop buttons
 * @author Walija Ihsan
 * @version 17.0.5
 */
public class Main {

    View view = new View();
    Model model = new Model();
    ControllerTemp tempController;
    ControllerSoilMoisture soilController;
    ControllerHumidity humidityController;

    static Thread temp, soil, humidity;

    /***
     * construction method that adds the actionListeners to the buttons that only appear in this class
     */
    public Main() {

        view.addStartButtonListener(new startButtonListener());
        view.addStopButtonListener(new stopButtonListener());
        view.addSaveButtonListener(new saveButtonListener());
    }

    /**
     * Main method that creates a new Main object, which creates the Jframe
     * @param args command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        Main main = new Main();
    }

    /**
     * an inner class that implements actionlistener to 'start' the greenhouse simulation
     */
    class startButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            try {
                tempController = new ControllerTemp(view, model);
                soilController = new ControllerSoilMoisture(view, model);
                humidityController = new ControllerHumidity(view, model);

                temp = new Thread(tempController);
                soil = new Thread(soilController);
                humidity = new Thread(humidityController);

                temp.start();
                humidity.start();
                soil.start();
            } catch (NumberFormatException e) {
                view.displayErrorMessage("Error: some values are missing");
            }

        }
    }

    /**
     * a static inner class that stops all threads when the user presses the stop button
     */
    static class stopButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            Main.stopAllThreads();
        }
    }

    /**
     * a static inner class that saves user settings to a file when they click the save button
     */
    class saveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {

            try{

                BufferedWriter writer = new BufferedWriter(new FileWriter("greenHouseSim.txt", true));
                writer.write("Greenhouse simulation info: ");
                writer.write("\n Current temp: " + view.getCurrentTemp());
                writer.write("\n Desired temp: " + view.getDesiredTemp());
                writer.write("\n Air conditioner rate: " + view.getCoolingRate());
                writer.write("\n Furnace rate: " + view.getHeatingRate());
                writer.write("\n Temp refresh rate: " + view.getTempRefreshRate());
                writer.write("\n Current humidity: " + view.getCurrentHumidity());
                writer.write("\n Desired humidity start point: " + view.getHumidityRangeStart());
                writer.write("\n Desired humidity end point: " + view.getHumidityRangeEnd());
                writer.write("\n Humidifier rate : " + view.getHumidifierRate());
                writer.write("\n Humidity refresh rate: " + view.getHumidityRefreshRate());
                writer.write("\n Current soil moisture: " + view.getCurrentSoilMoisture());
                writer.write("\n Desired soil moisture start point: " + view.getSoilMoistureRangeStart());
                writer.write("\n Desired soil moisture end point: " + view.getSoilMoistureRangeEnd());
                writer.write("\n Sprinklers rate : " + view.getSprinklersRate());
                writer.write("\n Soil moisture refresh rate: " + view.getSoilMoistureRefreshRate());
                writer.write("\n");
                writer.close();

            } catch (IOException e){
                view.displayErrorMessage("IO error");
            }
        }
    }

    /**
     * a static method that stops all threads from running
     */
    public static void stopAllThreads(){
        temp.stop();
        humidity.stop();
        soil.stop();

    }


}