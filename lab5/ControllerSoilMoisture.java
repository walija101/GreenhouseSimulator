package lab5;

/**
 * controller class for the soil moisture - It implements runnable, and is a thread class. It will be the mediator for all the interaction between the view, model, and all values relating to soil moisture
 */
public class ControllerSoilMoisture implements Runnable {
    private View view;
    private Model model;

    /**
     * constructor method that will create an abject belonging to the ControllerSoilMoisture class
     * @param viewVal a view class object, which is a key variable for ControllerSoilMoisture objects
     * @param modelVal a model class object, which is a key variable for ControllerSoilMoisture objects
     */
    public ControllerSoilMoisture(View viewVal, Model modelVal) {
        super();
        view = viewVal;
        model = modelVal;
    }
    /**
     * run method, which is called on through XXX.start(), in order to begin running this thread, which will continue to run arbitrarily
     */
    public void run() {

        try {
            model.setCurrentSoilMoisture(view.getCurrentSoilMoisture());
            view.switchSoilMoistureRangeStartAndEnd();
            for (;;) {
                view.setCurrentSoilMoisture(model.getCurrentSoilMoisture());
                if (view.getSoilMoistureRangeStart() > view.getCurrentSoilMoisture()) {
                    model.updateCurrentSoilMoisture(((view.getSprinklersRate() * view.getSoilMoistureRefreshRate())/60)+view.getEnvSoilMoistureChange());
                    view.setCurrentSoilMoistureChangerState("ON");
                } else {
                    model.updateCurrentSoilMoisture(view.getEnvSoilMoistureChange());
                    view.setCurrentSoilMoistureChangerState("OFF");
                }
                Thread.sleep((int) view.getSoilMoistureRefreshRate() * 1000);

            }
        } catch ( NumberFormatException | InterruptedException e) {
            if (e instanceof InterruptedException) {
                return;
            } else {
                view.displayErrorMessage("Error: some Soil Moisture values are missing");
                Main.stopAllThreads();
                return;
            }


        }

    }
}