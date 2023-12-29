package lab5;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This is the View class, containing all GUI, and the user inputs what they will, and the program performs actions in return.
 * @author Walija Ihsan
 * @version 17.0.5
 */
public class View extends JFrame{
    JPanel panel = new JPanel();
    JButton start = new JButton("Start!");
    JButton stop = new JButton("Stop");
    JButton save = new JButton("Save");

    //

    JLabel currentTempLabel = new JLabel("Current Temperature (°C) :"),
            desiredTemperatureLabel = new JLabel("Desired Temperature (°C) :"),
            coolingRateLabel = new JLabel("Air Conditioning Rate (°C/min) :"),
            heatingRateLabel = new JLabel("Furnace Rate (°C/min) :"),
            tempRefreshRateLabel = new JLabel("Refresh Rate (seconds) :"),
            currentTempChangerState = new JLabel("Off");
    JTextField currentTemp = new JTextField(10),
            coolingRate = new JTextField(10),
            heatingRate = new JTextField(10);
    JSlider desiredTemp = new JSlider(JSlider.HORIZONTAL, 10, 60, 35),
            tempRefreshRate = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);


    //

    JLabel currentHumidityLabel = new JLabel("Current Humidity (%) :"),
            desiredHumidityLabel = new JLabel("Desired Humidity Range (%) :"),
            humidityChangeRateLabel = new JLabel("Humidity Rate (%/min) :"),
            humidityRefreshRateLabel = new JLabel("Refresh Rate (seconds) :"),
            currentHumidifierState = new JLabel("Off"),
            humidityRangeStartLabel = new JLabel("From: "), humidityRangeEndLabel = new JLabel("To: ");
    JTextField currentHumidity = new JTextField(10),
            humidityChangeRate = new JTextField(10),
            humidityRangeStart = new JTextField(5), humidityRangeEnd = new JTextField(5);
    JSlider humidityRefreshRate = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);

    //

    JLabel currentSoilMoistureLabel = new JLabel("Current Soil Moisture (%) :"),
            desiredSoilMoistureLabel = new JLabel("Desired Soil Moisture Range (%) :"),
            soilMoistureChangeRateLabel = new JLabel("Soil Moisture Change Rate (%/min) :"),
            soilRefreshRateLabel = new JLabel("Refresh Rate (seconds) :"),
            currentSprinklersState = new JLabel("Off"),
            soilMoistureRangeStartLabel = new JLabel("From: "), soilMoistureRangeEndLabel = new JLabel("To: ");

    JTextField currentSoilMoisture = new JTextField(10),
            soilMoistureChangeRate = new JTextField(10),
            soilMoistureRangeStart = new JTextField(2), soilMoistureRangeEnd = new JTextField(2);


    JSlider soilMoistureRefreshRate = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);

    //

    JLabel envTempLabel = new JLabel("Environment temperature (°C): "),
            tempEffectLabel = new JLabel("Temperature effect (°C/min): "),
            envHumidityLabel = new JLabel("Environment humidity (%): "),
            humidityEffectLabel = new JLabel("Humidity effect (%/min): "),
            envSoilMoistureLabel = new JLabel("Environment soil moisture (%): "),
            soilMoistureEffectLabel = new JLabel("Soil Moisture effect (%/min): ");

    JTextField envTemp = new JTextField(10),
            envHumidity = new JTextField(10),
            envSoilMoisture = new JTextField(10);

    JSlider tempEffect = new JSlider(0, 5, 0),
            humidityEffect = new JSlider(0, 5, 0),
            soilMoistureEffect = new JSlider(0, 5, 0);

    //

    JPanel tempPanel = new JPanel(), humidityPanel = new JPanel(),soilMoisturePanel = new JPanel(),envPanel = new JPanel(), buttonPanel = new JPanel();

    /**
     * Constructor method that creates a view class object - Will make all GUI components visible and in place
     */
    public View() {

        tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.Y_AXIS));
        tempPanel.setSize(200, 1000);

        tempPanel.add(currentTempLabel);
        tempPanel.add(currentTemp);
        tempPanel.add(desiredTemperatureLabel);
        tempPanel.add(desiredTemp);
        tempPanel.add(coolingRateLabel);
        tempPanel.add(coolingRate);
        tempPanel.add(heatingRateLabel);
        tempPanel.add(heatingRate);
        tempPanel.add(tempRefreshRateLabel);
        tempPanel.add(tempRefreshRate);
        tempPanel.add(currentTempChangerState);

        desiredTemp.setMajorTickSpacing(5);
        desiredTemp.setPaintLabels(true);
        desiredTemp.setPaintTicks(true);
        tempRefreshRate.setMinorTickSpacing(1);
        tempRefreshRate.setMajorTickSpacing(1);
        tempRefreshRate.setPaintLabels(true);
        tempRefreshRate.setPaintTicks(true);

        //

        humidityPanel.setLayout(new BoxLayout(humidityPanel, BoxLayout.Y_AXIS));
        humidityPanel.setSize(200, 1000);

        humidityPanel.add(currentHumidityLabel);
        humidityPanel.add(currentHumidity);
        humidityPanel.add(desiredHumidityLabel);
        humidityPanel.add(humidityRangeStartLabel);
        humidityPanel.add(humidityRangeStart);
        humidityPanel.add(humidityRangeEndLabel);
        humidityPanel.add(humidityRangeEnd);
        humidityPanel.add(humidityChangeRateLabel);
        humidityPanel.add(humidityChangeRate);
        humidityPanel.add(humidityRefreshRateLabel);
        humidityPanel.add(humidityRefreshRate);
        humidityPanel.add(currentHumidifierState);

        humidityRefreshRate.setMinorTickSpacing(1);
        humidityRefreshRate.setMajorTickSpacing(1);
        humidityRefreshRate.setPaintLabels(true);
        humidityRefreshRate.setPaintTicks(true);

        //

        soilMoisturePanel.setLayout(new BoxLayout(soilMoisturePanel, BoxLayout.Y_AXIS));
        soilMoisturePanel.setSize(200, 1000);

        soilMoisturePanel.add(currentSoilMoistureLabel);
        soilMoisturePanel.add(currentSoilMoisture);
        soilMoisturePanel.add(desiredSoilMoistureLabel);
        soilMoisturePanel.add(soilMoistureRangeStartLabel);
        soilMoisturePanel.add(soilMoistureRangeStart);
        soilMoisturePanel.add(soilMoistureRangeEndLabel);
        soilMoisturePanel.add(soilMoistureRangeEnd);
        soilMoisturePanel.add(soilMoistureChangeRateLabel);
        soilMoisturePanel.add(soilMoistureChangeRate);
        soilMoisturePanel.add(soilRefreshRateLabel);
        soilMoisturePanel.add(soilMoistureRefreshRate);
        soilMoisturePanel.add(currentSprinklersState);

        soilMoistureRefreshRate.setMinorTickSpacing(1);
        soilMoistureRefreshRate.setMajorTickSpacing(1);
        soilMoistureRefreshRate.setPaintLabels(true);
        soilMoistureRefreshRate.setPaintTicks(true);

        //
        envPanel.setLayout(new BoxLayout(envPanel, BoxLayout.Y_AXIS));
        envPanel.setSize(200, 1000);

        envPanel.add(envTempLabel);
        envPanel.add(envTemp);
        envPanel.add(tempEffectLabel);
        envPanel.add(tempEffect);
        envPanel.add(envHumidityLabel);
        envPanel.add(envHumidity);
        envPanel.add(humidityEffectLabel);
        envPanel.add(humidityEffect);
        envPanel.add(envSoilMoistureLabel);
        envPanel.add(envSoilMoisture);
        envPanel.add(soilMoistureEffectLabel);
        envPanel.add(soilMoistureEffect);

        tempEffect.setMinorTickSpacing(1);
        tempEffect.setMajorTickSpacing(1);
        tempEffect.setPaintLabels(true);
        tempEffect.setPaintTicks(true);

        humidityEffect.setMinorTickSpacing(1);
        humidityEffect.setMajorTickSpacing(1);
        humidityEffect.setPaintLabels(true);
        humidityEffect.setPaintTicks(true);

        soilMoistureEffect.setMinorTickSpacing(1);
        soilMoistureEffect.setMajorTickSpacing(1);
        soilMoistureEffect.setPaintLabels(true);
        soilMoistureEffect.setPaintTicks(true);

        //

        buttonPanel.add(start);
        buttonPanel.add(stop);
        buttonPanel.add(save);

        //

        this.add(tempPanel);
        this.add(humidityPanel);
        this.add(soilMoisturePanel);
        this.add(envPanel);
        this.add(buttonPanel);



        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setSize(1200, 1200);
    }

    /**
     * A get method that returns the refresh rate for temperature
     * @return the temperature refresh rate
     */
    public double getTempRefreshRate(){
        return tempRefreshRate.getValue();
    }
    /**
     * A get method that returns the desired value for temperature
     * @return the temperature desired value
     */
    public double getDesiredTemp() {
        return desiredTemp.getValue();
    }
    /**
     * A get method that returns the current live temperature
     * @return the current temperature
     */
    public synchronized double getCurrentTemp() {

        return Double.parseDouble(currentTemp.getText());
    }

    /**
     * A get method that returns the air conditioner rate for temperature
     * @return the air conditioner rate
     */
    public double getCoolingRate() {
        return Double.parseDouble(coolingRate.getText());
    }
    /**
     * A get method that returns the furnace rate for temperature
     * @return the furnace conditioner rate
     */
    public double getHeatingRate() {
        return Double.parseDouble(heatingRate.getText());
    }

    /**
     * A set method that sets the current temperature
     * @param currentTempVal current temperature value
     */
    public void setCurrentTemp(double currentTempVal) {
        currentTemp.setText(Double.toString(currentTempVal));
    }

    /**
     * A set method that sets the state of the current temperature changer (air conditioner or furnace)
     * @param state the state of the temp changer
     */
    public void setCurrentTempChangerState(String state) {
        currentTempChangerState.setText(state);
        if (state.equals("Air Conditioner On")) {
            currentTempChangerState.setForeground(Color.blue);
        } else if (state.equals("Furnace On")){
            currentTempChangerState.setForeground(Color.orange);
        } else { currentTempChangerState.setForeground(Color.red);
        }
    }

    //

    /**
     * get method that returns the refresh rate of the Humidity
     * @return the refresh rate of the Humidity
     */

    public double getHumidityRefreshRate(){
        return humidityRefreshRate.getValue();
    }

    /**
     * get method that returns the starting range of humidity
     * @return starting range of humidity
     */
    public double getHumidityRangeStart(){
        if (Double.parseDouble(humidityRangeStart.getText()) > 100) {
            return 100;
        } else if (Double.parseDouble(humidityRangeStart.getText()) < 0) {
            return 0;
        } else {
            return Double.parseDouble(humidityRangeStart.getText());

        }
    }

    /**
     * get method that returns the ending range of Humidity
     * @return the ending range of Humidity
     */
    public double getHumidityRangeEnd(){
        if (Double.parseDouble(humidityRangeEnd.getText()) > 100) {
            return 100;
        } else if (Double.parseDouble(humidityRangeEnd.getText()) < 0) {
            return 0;
        } else {
            return Double.parseDouble(humidityRangeEnd.getText());

        }
    }

    /**
     * Get method that returns the Current humidity
     * @return current humidity
     */
    public synchronized double getCurrentHumidity() {
        if (Double.parseDouble(currentHumidity.getText()) > 100) {
            return 100;
        } else if (Double.parseDouble(currentHumidity.getText()) < 0) {
            return 0;
        } else {
            return Double.parseDouble(currentHumidity.getText());

        }


    }

    /**
     * get method that returns the rate of the Humidifier
     * @return the rate of the Humidifier
     */
    public double getHumidifierRate() {
        if (Double.parseDouble(humidityChangeRate.getText()) > 100) {
            return 100;
        } else if (Double.parseDouble(humidityChangeRate.getText()) < 0) {
            return 0;
        } else {
            return Double.parseDouble(humidityChangeRate.getText());

        }

    }

    /**
     * set method that sets the current Humidity val once it is updated
     * @param currentHumidityVal current Humidity Value
     */
    public void setCurrentHumidity(double currentHumidityVal) {
        currentHumidity.setText(Double.toString(currentHumidityVal));
    }

    /**
     * method that switches the Start and End ranges in case the user inputs then in the wrong order
     */
    public void switchHumidityRangeStartAndEnd() {
        if (getHumidityRangeStart() > getHumidityRangeEnd()) {
            String startVal = humidityRangeStart.getText(),
                    endVal = humidityRangeEnd.getText();
            humidityRangeStart.setText(endVal);
            humidityRangeEnd.setText(startVal);
        }
    }

    /**
     * set method that sets the State of the humidifier being on or off
     * @param state String represents the state of the humidifier
     */
    public void setCurrentHumidityChangerState(String state) {
        currentHumidifierState.setText(state);
        if (state.equals("ON")) {
            currentHumidifierState.setForeground(Color.green);
        } else {
            currentHumidifierState.setForeground(Color.red);
        }
    }
    //

    /**
     * get method that returns the refresh rate for soil moisture
     * @return the refresh rate of the soil moisture
     */
    public double getSoilMoistureRefreshRate(){
        return soilMoistureRefreshRate.getValue();
    }

    /**
     * get method that returns the starting range for the soil moisture
     * @return starting range of the soil moisture
     */
    public double getSoilMoistureRangeStart(){
        return Double.parseDouble(soilMoistureRangeStart.getText());
    }

    /**
     * get method that returns the ending point of the soil moisture
     * @return ending range of the soil moisture
     */
    public double getSoilMoistureRangeEnd(){
        return Double.parseDouble(soilMoistureRangeEnd.getText());
    }

    /**
     * method that switching the starting and ending range in case the user puts them in the wrong order
     */
    public void switchSoilMoistureRangeStartAndEnd() {
        if (getSoilMoistureRangeStart() > getSoilMoistureRangeEnd()) {
            String startVal = soilMoistureRangeStart.getText(),
                    endVal = soilMoistureRangeEnd.getText();
            soilMoistureRangeStart.setText(endVal);
            soilMoistureRangeEnd.setText(startVal);
        }
    }

    /**
     * set method that sets the soil moisture changer state
     * @param state String representing the changer state
     */
    public void setCurrentSoilMoistureChangerState(String state) {
        currentSprinklersState.setText(state);
        if (state.equals("ON")) {
            currentSprinklersState.setForeground(Color.green);
        } else {
            currentSprinklersState.setForeground(Color.red);
        }
    }

    //

    /**
     * get method that gets the environment temperature
     * @return environment temperature
     */
    public double getEnvTemp() {
        return Double.parseDouble(envTemp.getText());
    }

    /**
     * get method that gets the environment Humidity
     * @return environment Humidity
     */
    public double getEnvHumidity() {
        return Double.parseDouble(envHumidity.getText());
    }

    /**
     * get method that gets the environmet soil moisture
     * @return environment soil moisture
     */
    public double getEnvSoilMoisture() {
        return Double.parseDouble(envSoilMoisture.getText());
    }

    /**
     * get method for the temperature effect rate
     * @return temperature effect rate
     */
    public double getTempEffect() {
        return tempEffect.getValue();
    }

    /**
     * get method for the humidity effect rate
     * @return humidity effect rate
     */
    public double getHumidityEffect() {
        return humidityEffect.getValue();
    }

    /**
     * get method for the soil moisture effect rate
     * @return soil moisture effect rate
     */
    public double getSoilMoistureEffect() {
        return soilMoistureEffect.getValue();
    }

    /**
     * get method for the current soil Moisture
     * @return current soil moisture
     */
    public synchronized double getCurrentSoilMoisture() {
        return Double.parseDouble(currentSoilMoisture.getText());
    }

    /**
     * get method for the sprinkler rate for soil moisture
     * @return
     */
    public double getSprinklersRate() {
        return Double.parseDouble(soilMoistureChangeRate.getText());
    }

    /**
     * get method for the current soil moisture
     * @param currentSoilMoistureVal current soil moisture
     */
    public void setCurrentSoilMoisture(double currentSoilMoistureVal) {
        currentSoilMoisture.setText(Double.toString(currentSoilMoistureVal));
    }

    //

    /**
     * method to add an actionlistener to the start button in the Jframe
     * @param startButtonListener the action listener, which will activate all other methods
     */
    public void addStartButtonListener(ActionListener startButtonListener){
        start.addActionListener(startButtonListener);
    }

    /**
     * method to add an actionListener to the stop button in the Jframe
     * @param stopButtonListener the actionlistener, which will stop all other threads
     */
    public void addStopButtonListener(ActionListener stopButtonListener) {
        stop.addActionListener(stopButtonListener);
    }

    /**
     * method to add a save button to the Jframe
     * @param stopButtonListener
     */
    public void addSaveButtonListener(ActionListener stopButtonListener) {
        save.addActionListener(stopButtonListener);
    }

    /**
     * method to display an error message, in case some values are missing from the user inputs
     * @param errorMessage the error message to be displayed in the JFrame
     */
    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog( this, errorMessage);
    }

    /**
     * get method that gets the total temperature change in the environment for every refresh
     * @return the total temperature change caused by the environment
     */
    public double getEnvTempChange(){
        if (getCurrentTemp() > getEnvTemp()){
            return -(getTempEffect() * getTempRefreshRate() / 60);
        } else if (getCurrentTemp() < getEnvTemp()){
            return getTempEffect() * getTempRefreshRate() / 60;
        } else {
            return 0;
        }
    }

    /**
     * get method that gets the total humidity change in the environment for every refresh
     * @return the total humidity change caused by the environment
     */
    public double getEnvHumidityChange(){
        if (getCurrentHumidity() > getEnvHumidity()){
            return -(getHumidityEffect() * getHumidityRefreshRate() / 60);
        } else if (getCurrentHumidity() < getEnvHumidity()){
            return getHumidityEffect() * getHumidityRefreshRate() / 60;
        } else {
            return 0;
        }
    }

    /**
     * get method that gets the total soil moisture change in the environment for every refresh
     * @return the total soil Moisture change caused by the environment
     */
    public double getEnvSoilMoistureChange(){
        if (getCurrentSoilMoisture() > getEnvSoilMoisture()){
            return -(getSoilMoistureEffect() * getSoilMoistureRefreshRate() / 60);
        } else if (getCurrentSoilMoisture() < getEnvSoilMoisture()){
            return getSoilMoistureEffect() * getSoilMoistureRefreshRate() / 60;
        } else {
            return 0;
        }
    }


}
