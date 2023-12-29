package lab5;

/**
 * controller class for the humidity - It implements runnable, and is a thread class. It will be the mediator for all the interaction between the view, model, and all values relating to humidity
 */
public class ControllerHumidity implements Runnable {
    private View view;
    private Model model;

    /**
     * constructor method that will create an abject belonging to the ControllerHumidity class
     * @param viewVal a view class object, which is a key variable for ControllerHumidity objects
     * @param modelVal a model class object, which is a key variable for ControllerHumidity objects
     */
    public ControllerHumidity(View viewVal, Model modelVal) {
        super();
        view = viewVal;
        model = modelVal;
    }
    /**
     * run method, which is called on through XXX.start(), in order to begin running this thread, which will continue to run arbitrarily
     */
    public void run() {

        try {
            model.setCurrentHumidity(view.getCurrentHumidity());
            view.switchHumidityRangeStartAndEnd();
            for (;;) {
                view.setCurrentHumidity(model.getCurrentHumidity());
                if (view.getHumidityRangeStart() > view.getCurrentHumidity()) {
                    model.updateCurrentHumidity(((view.getHumidifierRate() * view.getHumidityRefreshRate())/60) + view.getEnvHumidityChange());
                    view.setCurrentHumidityChangerState("ON");
                } else {
                    model.updateCurrentHumidity(view.getEnvHumidityChange());
                    view.setCurrentHumidityChangerState("OFF");
                }
                Thread.sleep((int) view.getHumidityRefreshRate() * 1000);


            }
        }  catch (NumberFormatException | InterruptedException e) {
            if (e instanceof InterruptedException) {
                return;
            } else {
                view.displayErrorMessage("Error: some Humidity values are missing");
                Main.stopAllThreads();
                return;
            }


        }

    }
}