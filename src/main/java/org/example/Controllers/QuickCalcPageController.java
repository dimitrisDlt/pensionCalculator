package org.example.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.Core.ContributoryPensionCalculator;

public class QuickCalcPageController
{
    @FXML
    private CheckBox disabilityCheckBox;
    @FXML
    private Label ageLabel;
    @FXML
    private ChoiceBox ageInput;
    @FXML
    private Label residenceYearsLabel;
    @FXML
    private TextField residenceYearsInput;
    @FXML
    private Label disabilityPercentLabel;
    @FXML
    private ChoiceBox disabilityPercentInput;
    @FXML
    private Button continueButton;

    @FXML
    public void onContinueButtonClicked()
    {
        ContributoryPensionCalculator contributoryPensionCalculator = new ContributoryPensionCalculator();
        double result = contributoryPensionCalculator.getContributoryPensionCalculator(1000.00, 45);
        continueButton.setText(String.valueOf(result));
    }
}
