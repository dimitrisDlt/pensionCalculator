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

        var label = new Label("Hello, JavaFX " + ", running on Java " + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

}