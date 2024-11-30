package org.example.Controllers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
}
