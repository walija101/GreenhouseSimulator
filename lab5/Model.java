package lab5;

public class Model {

    public double currentTemp, currentHumidity, currentSoilMoisture;

    /**
     * set method that sets the current temperature
     * @param currentTempVal current temperature value
     */

    public void setCurrentTemp(double currentTempVal) {
        currentTemp = currentTempVal;
    }

    /**
     * method that updates the current temperature by adding to it
     * @param rateOfTempChange the value to be added to the current temperature
     */
    public void updateCurrentTemp(double rateOfTempChange) {
        currentTemp = currentTemp + rateOfTempChange;
    }

    /**
     * get method that returns the current temperature
     * @return current temperature
     */
    public double getCurrentTemp() {
        return currentTemp;
    }

    //

    /**
     * method that updates the current humidity by adding to it
     * @param rateOfHumidityChange the value that will be added to the current humidity
     */

    public void updateCurrentHumidity(double rateOfHumidityChange) {
        if (currentHumidity + rateOfHumidityChange >= 100) {
            currentHumidity = 100;
        } else if (currentHumidity + rateOfHumidityChange <= 0){
            currentHumidity = 0;
        } else {
            currentHumidity = currentHumidity + rateOfHumidityChange;
        }
    }

    /**
     * get method that will return the current Humidity
     * @return current humidity
     */
    public double getCurrentHumidity() {
        return currentHumidity;
    }

    /**
     * set method that will set the Current humidity
     * @param currentHumidityVal value for the current humidity
     */
    public void setCurrentHumidity(double currentHumidityVal) {
        currentHumidity = currentHumidityVal;
    }

    /**
     * method that will update the current soil moisture by adding to it
     * @param rateOfSoilMoistureChange value tat will be added to the current soil moisture
     */

    public void updateCurrentSoilMoisture(double rateOfSoilMoistureChange) {
        if (currentSoilMoisture + rateOfSoilMoistureChange >= 100) {
            currentSoilMoisture = 100;
        } else if (currentSoilMoisture + rateOfSoilMoistureChange <= 0){
            currentSoilMoisture = 0;
        } else {
            currentSoilMoisture = currentSoilMoisture + rateOfSoilMoistureChange;
        }
    }

    /**
     * get method that returns the current soil moisture
     * @return current soil moisture
     */
    public double getCurrentSoilMoisture() {
        return currentSoilMoisture;
    }

    /**
     * set mothod that sets the current soil moisture
     * @param currentSoilMoistureVal value of the current coil moisture
     */
    public void setCurrentSoilMoisture(double currentSoilMoistureVal) {
        currentSoilMoisture = currentSoilMoistureVal;
    }




}