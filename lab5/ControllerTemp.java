package lab5;

/**
 * controller class for the temperature. It implements runnable, and is a thread class - It will be the mediator for all the interaction between the view, model, and all values relating to temperature
 */
public class ControllerTemp implements Runnable {
    private View view;
    private Model model;
    /**
     * constructor method that will create an abject belonging to the ControllerTemp class
     * @param viewVal a view class object, which is a key variable for ControllerTemp objects
     * @param modelVal a model class object, which is a key variable for ControllerTemp objects
     */
    public ControllerTemp(View viewVal, Model modelVal) {
        super();
        view = viewVal;
        model = modelVal;

    }

    /**
     * run method, which is called on through XXX.start(), in order to begin running this thread, which will continue to run arbitrarily
     */
    public void run() {

        try {
            model.setCurrentTemp(view.getCurrentTemp());
            for (;;) {
                view.setCurrentTemp(model.getCurrentTemp());
                if (view.getDesiredTemp() - 3 > view.getCurrentTemp()) {
                    model.updateCurrentTemp(((view.getHeatingRate() * view.getTempRefreshRate()) / 60) + view.getEnvTempChange());
                    view.setCurrentTempChangerState("Furnace On");
                } else if (view.getDesiredTemp() + 3 < view.getCurrentTemp()) {
                    model.updateCurrentTemp((-(view.getCoolingRate() * view.getTempRefreshRate()) / 60)+ view.getEnvTempChange());
                    view.setCurrentTempChangerState("Air Conditioner On");
                } else {
                    model.updateCurrentTemp( view.getEnvTempChange()) ;
                    view.setCurrentTempChangerState("OFF");
                }
                Thread.sleep((int) view.getTempRefreshRate() * 1000);

            }
        } catch (NumberFormatException | InterruptedException e) {
            if (e instanceof InterruptedException) {
                return;
            } else {
                view.displayErrorMessage("Error: some Temperature values are missing");
                Main.stopAllThreads();
                return;
            }


        }

    }
}