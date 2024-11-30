package org.example.Views;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.util.Duration;
import org.example.Controllers.BasicChoicePageController;
import org.example.Controllers.LoginPageController;
import org.example.Controllers.QuickCalcPageController;

import java.io.IOException;
import java.util.ArrayList;

public class CentralView extends StackPane
{
    public CentralView()
    {
        //Create fxml loaders

        FXMLLoader loginPageLoader = new FXMLLoader(getClass().getResource("/FxmlFiles/LoginPage.fxml"));
        FXMLLoader basicChoicePageLoader = new FXMLLoader(getClass().getResource("/FxmlFiles/BasicChoicePage.fxml"));
        FXMLLoader quickCalcPageLoader = new FXMLLoader(getClass().getResource("/FxmlFiles/QuickCalcPage.fxml"));

        HBox loginPage;
        VBox basicChoicePage;
        VBox quickCalcPage;

        try
        {
            loginPage = loginPageLoader.load();
        }
        catch (IOException e)
        {
            loginPage = new HBox(new Label("The loginPage FXML file is wrong or null!"));
            e.printStackTrace();
        }

        try
        {
            basicChoicePage = basicChoicePageLoader.load();
        }
        catch (IOException e)
        {
            basicChoicePage = new VBox(new Label("The basicChoiceBox FXML file is wrong or null!"));
            e.printStackTrace();
        }

        try
        {
            quickCalcPage = quickCalcPageLoader.load();
        }
        catch (IOException e)
        {
            quickCalcPage = new VBox(new Label("The loginPage FXML file is wrong or null!"));
            e.printStackTrace();
        }

        this.getChildren().addAll(loginPage, basicChoicePage, quickCalcPage);
        this.getChildren().get(0).toFront();
        this.setMinSize(1024, 596);
        this.setAlignment(Pos.TOP_LEFT);

        LoginPageController loginPageController = loginPageLoader.getController();
        BasicChoicePageController basicChoicePageController = basicChoicePageLoader.getController();
        QuickCalcPageController quickCalcPageController = quickCalcPageLoader.getController();


        loginPageController.readyToContinue.addListener((observableValue, aBoolean, t1) ->
        {
            changeViews(0);
        });

        basicChoicePageController.quickCalculation.addListener(((observableValue, aBoolean, t1) ->
        {
            changeViews(0);
        }));

    }

    private void changeViews(int newIndex)
    {
        for (Node e: this.getChildren())
        {
            if (e != this.getChildren().get(this.getChildren().size() - 1))
            {
                e.setOpacity(0);
            }
        }

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), this.getChildren().get(this.getChildren().size() - 1));
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);
        fadeOut.play();

        this.getChildren().get(newIndex).toFront();

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), this.getChildren().get(this.getChildren().size() - 1));

        fadeIn.setNode(this.getChildren().get(this.getChildren().size() - 1));
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();

    }

}
