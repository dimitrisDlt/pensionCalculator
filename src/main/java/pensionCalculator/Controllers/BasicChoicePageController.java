package pensionCalculator.Controllers;

import javafx.animation.FadeTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class BasicChoicePageController
{
    public BooleanProperty analyticalCalculation = new SimpleBooleanProperty(false);
    public BooleanProperty quickCalculation = new SimpleBooleanProperty(false);

    @FXML
    private Button quickCalcButton;
    @FXML
    private Button analyticalCalcButton;

    @FXML
    public void onQuickCalcButtonClicked()
    {
        quickCalculation.set(true);
    }

    @FXML
    public void onAnalyticalCalcButtonClicked()
    {
        analyticalCalculation.set(true);
    }

    @FXML
    private void onQuickCalcButtonHoverEnter()
    {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), quickCalcButton);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

    }

    @FXML
    private void onQuickCalcButtonHoverExit()
    {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), quickCalcButton);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

    }

    @FXML
    private void onAnalyticalCalcButtonHoverEnter()
    {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), analyticalCalcButton);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

    }

    @FXML
    private void onAnalyticalCalcButtonHoverExit()
    {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), analyticalCalcButton);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

    }

}
