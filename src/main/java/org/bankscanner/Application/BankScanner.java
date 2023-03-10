package org.bankscanner.Application;

import javafx.application.Application;
import javafx.stage.Stage;
import org.bankscanner.Quarter.Month;
import org.bankscanner.Quarter.Quarter;

import java.util.HashMap;

public class BankScanner extends Application {
    public static void main(String[] args) {
        Quarter firstQuarter = new Quarter(2022, Month.September); // 2328 parent fields
        System.out.println(427 == firstQuarter.getParents().keySet().size());
        boolean right = true;
        for (HashMap parent : firstQuarter.getParents().values()) {
            right = (2328 == parent.size());
        }
        System.out.println(right);

        Quarter secondQuarter = new Quarter(2022, Month.June); // 2327 parent fields
        System.out.println(3958 == secondQuarter.getParents().keySet().size());
        for (HashMap parent : secondQuarter.getParents().values()) {
            right = (2327 == parent.size());
        }
        System.out.println(right);
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}