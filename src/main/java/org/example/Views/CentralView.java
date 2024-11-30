package org.example.Views;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.ArrayList;

public class CentralView extends StackPane
{
    public CentralView()
    {
        FXMLLoader loader = new FXMLLoader();

        HBox loginPage;
        VBox basicChoicePage;

        try {
            loginPage = loader.load(getClass().getResource("/FxmlFiles/LoginPage.fxml"));
        }
        catch (IOException e)
        {
            loginPage = new HBox(new Label("The loginPage FXML file is wrong or null!"));
            e.printStackTrace();
        }

        try {
            basicChoicePage = loader.load(getClass().getResource("/FxmlFiles/BasicChoicePage.fxml"));
        }
        catch (IOException e)
        {
            basicChoicePage = new VBox(new Label("The basicChoiceBox FXML file is wrong or null!"));
            e.printStackTrace();
        }

        this.getChildren().addAll(basicChoicePage, loginPage);
        this.setMinSize(1024, 596);
        this.setAlignment(Pos.TOP_LEFT);

    }

}
