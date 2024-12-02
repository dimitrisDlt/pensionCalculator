package pensionCalculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pensionCalculator.Controllers.*;
import pensionCalculator.Controllers.CentralController;


public class App extends Application
{

    @Override
    public void start(Stage stage)
    {
        CentralController centralController = new CentralController();

        Scene scene = new Scene(centralController.getCentralView(), 1024, 596);
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/ImageFiles/logo.png")));
        stage.show();
    }

}