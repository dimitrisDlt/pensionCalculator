package pensionCalculator.Views;

import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.io.IOException;

public class CentralView extends StackPane
{
    private FXMLLoader loginPageLoader;
    private FXMLLoader basicChoicePageLoader;
    private FXMLLoader quickCalcPageLoader;
    private FXMLLoader simpleResultPageLoader;

    public CentralView()
    {
        //Create fxml loaders

        loginPageLoader = new FXMLLoader(getClass().getResource("/FxmlFiles/LoginPage.fxml"));
        basicChoicePageLoader = new FXMLLoader(getClass().getResource("/FxmlFiles/BasicChoicePage.fxml"));
        quickCalcPageLoader = new FXMLLoader(getClass().getResource("/FxmlFiles/QuickCalcPage.fxml"));
        simpleResultPageLoader = new FXMLLoader(getClass().getResource("/FxmlFiles/SimpleResultPage.fxml"));

        HBox loginPage;
        VBox basicChoicePage;
        VBox quickCalcPage;
        VBox simpleResultPage;

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

        try
        {
            simpleResultPage = simpleResultPageLoader.load();
        }
        catch (IOException e)
        {
            simpleResultPage = new VBox(new Label("The loginPage FXML file is wrong or null!"));
            e.printStackTrace();
        }

        this.getChildren().addAll(loginPage, basicChoicePage, quickCalcPage, simpleResultPage);
        this.getChildren().get(0).toFront();
        this.setMinSize(1024, 596);
        this.setAlignment(Pos.TOP_LEFT);

    }

    public void changeViews(int newIndex)
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

    public FXMLLoader getLoginPageLoader()
    {
        return loginPageLoader;
    }

    public FXMLLoader getBasicChoicePageLoader()
    {
        return basicChoicePageLoader;
    }

    public FXMLLoader getQuickCalcPageLoader()
    {
        return quickCalcPageLoader;
    }

    public FXMLLoader getSimpleResultPageLoader()
    {
        return simpleResultPageLoader;
    }
}
