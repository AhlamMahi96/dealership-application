package org.example.dealershipapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DealershipGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dealership_gui.fxml"));
            Parent root = loader.load();

            // Create or load a manager
            DealershipManager manager = jsonExport.loadAllDealers("dealershipsData.json");

            // If no dealers were loaded, manager is empty. You can add default dealers if desired.
            // manager.addDealership(new Dealership("D001", true));

            // Get controller and set manager
            DealershipController controller = loader.getController();
            controller.setDealershipManager(manager);

            primaryStage.setTitle("Dealership Management System");
            primaryStage.setScene(new Scene(root, 700, 400));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
