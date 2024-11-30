package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.example.Controllers.*;


public class App extends Application
{

    @Override
    public void start(Stage stage)
    {
        CentralController centralController = new CentralController();

        Scene scene = new Scene(centralController.getCentralView(), 1024, 596);
        stage.setScene(scene);
        stage.show();
    }

}