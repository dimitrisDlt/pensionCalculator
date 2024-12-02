package org.example.Controllers;

import javafx.animation.FadeTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Duration;
import org.example.Core.ContributoryPensionCalculator;
import org.example.Core.NationalPensionCalculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class QuickCalcPageController implements Initializable
{
    @FXML
    private CheckBox disabilityCheckBox;
    @FXML
    private Label ageLabel;
    @FXML
    private ChoiceBox<String> ageInput;
    @FXML
    private Label residenceYearsLabel;
    @FXML
    private TextField residenceYearsInput;
    @FXML
    private Label disabilityPercentLabel;
    @FXML
    private ChoiceBox<String> disabilityPercentInput;
    @FXML
    private Button continueButton;
    @FXML
    private ChoiceBox<String> parallelYearsInput;
    @FXML
    private ChoiceBox<Integer> totalYearsSince2002Input;
    @FXML
    private TextField totalYearsInput;
    @FXML
    private TextField medianSalaryInput;
    @FXML
    private TextField posostoEisforasInput;
    @FXML
    private Label errorLabel;

    private LinkedHashMap<String, Integer> ageRange = new LinkedHashMap<String, Integer>();
    private LinkedHashMap<String, Integer> disabilityPercentRange = new LinkedHashMap<String, Integer>();
    private LinkedHashMap<String, Integer> parallelYearsRange = new LinkedHashMap<String, Integer>();

    private boolean isInputDataCorrect = true;

    public BooleanProperty isReadyForResult = new SimpleBooleanProperty(false);
    public BooleanProperty userWantsDisabilityCalculation = new SimpleBooleanProperty(false);

    public int age, totalYears, residenceYears, disabilityPercentage, parallelYears = 0;
    double medianSalary, posostoEisforas = 0;


    @FXML
    public void onContinueButtonClicked()
    {
        //check input values first
        ArrayList<TextField> inputFields = new ArrayList<TextField>();
        inputFields.add(totalYearsInput);
        inputFields.add(residenceYearsInput);
        inputFields.add(medianSalaryInput);
        inputFields.add(posostoEisforasInput);

        for (TextField field : inputFields) {
            for (int i = 0; i < field.getText().length(); i++) {
                char c = field.getText().charAt(i);
                switch (c) {
                    case '0':
                        break;
                    case '1':
                        break;
                    case '2':
                        break;
                    case '3':
                        break;
                    case '4':
                        break;
                    case '5':
                        break;
                    case '6':
                        break;
                    case '7':
                        break;
                    case '8':
                        break;
                    case '9':
                        break;
                    case ',':
                        c = '.';
                        break;
                    default:
                        isInputDataCorrect = false;
                }
            }

        }

        //check if fields are null


        //if something is wrong
        if (!isInputDataCorrect)
        {
            errorLabel.setText("Κάποιο στοιχείο πληκτρολογήθηκε λάθος. Ελέγξτε ότι καταχωρήθηκαν μόνο αριθμοί.");
        }
        else
        {
            if(disabilityCheckBox.isSelected())
            {
                //check null input fields
                if(totalYearsInput.getText().isEmpty())
                {
                    errorLabel.setText("Πρέπει να καταχωρίσετε τον συνολικό χρόνο ασφάλισης για να προσχωρήσετε.");
                }
                else if (medianSalaryInput.getText().isEmpty()) {
                    errorLabel.setText("Πρέπει να συμπληρώσετε έναν μέσο όρο αποδοχών για να προχωρήσετε.");
                }
                else
                {
                    if(posostoEisforasInput.getText().isEmpty())
                    {
                        posostoEisforasInput.setText("0");
                    }
                    disabilityPercentage = disabilityPercentRange.get(disabilityPercentInput.getSelectionModel().getSelectedItem());
                    totalYears = (int) (Double.parseDouble(totalYearsInput.getText()));
                    medianSalary = Double.parseDouble(medianSalaryInput.getText());
                    userWantsDisabilityCalculation.set(true);
                    isReadyForResult.set(true);
                }
            }
            else
            {
                //check null input fields
                if(totalYearsInput.getText().isEmpty())
                {
                    errorLabel.setText("Πρέπει να καταχωρίσετε τον συνολικό χρόνο ασφάλισης για να προσχωρήσετε.");
                }
                else if (medianSalaryInput.getText().isEmpty())
                {
                    errorLabel.setText("Πρέπει να συμπληρώσετε έναν μέσο όρο αποδοχών για να προχωρήσετε.");
                }
                else if (residenceYearsInput.getText().isEmpty())
                {
                    errorLabel.setText("Πρέπει να συμπληρώσετε τα συνολικά έτη διαμονής για να προχωρήσετε.");
                }
                else
                {
                    if(posostoEisforasInput.getText().isEmpty())
                    {
                        posostoEisforasInput.setText("0");
                    }
                    residenceYears = (int) Double.parseDouble(residenceYearsInput.getText());
                    totalYears = (int) (Double.parseDouble(totalYearsInput.getText()));
                    age = ageRange.get(ageInput.getSelectionModel().getSelectedItem());
                    medianSalary = Double.parseDouble(medianSalaryInput.getText());
                    userWantsDisabilityCalculation.set(false);
                    isReadyForResult.set(true);
                }
            }

        }

    }


    @FXML
    private void onDisabilityCheckBoxChecked()
    {
        if(disabilityCheckBox.isSelected())
        {
            ageLabel.setDisable(true);
            ageInput.setDisable(true);
            residenceYearsLabel.setDisable(true);
            residenceYearsInput.setDisable(true);
            disabilityPercentLabel.setDisable(false);
            disabilityPercentInput.setDisable(false);
        }
        else
        {
            disabilityPercentLabel.setDisable(true);
            disabilityPercentInput.setDisable(true);
            ageLabel.setDisable(false);
            ageInput.setDisable(false);
            residenceYearsLabel.setDisable(false);
            residenceYearsInput.setDisable(false);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ageRange.put("62", 62);
        ageRange.put("63", 63);
        ageRange.put("64", 64);
        ageRange.put("65", 65);
        ageRange.put("66", 66);
        ageRange.put("67+", 67);

        for (String key : ageRange.keySet())
        {
            ageInput.getItems().add(key);
        }

        ageInput.setValue(ageRange.keySet().iterator().next());

        disabilityPercentRange.put("Μικρότερο από 50%", 45);
        disabilityPercentRange.put("Από 50% έως 66%", 55);
        disabilityPercentRange.put("Από 67% έως 79%", 70);
        disabilityPercentRange.put("80% και άνω", 85);

        for (String key : disabilityPercentRange.keySet())
        {
            disabilityPercentInput.getItems().add(key);
        }

        disabilityPercentInput.setValue(disabilityPercentRange.keySet().iterator().next());

        parallelYearsRange.put("0", 0);
        parallelYearsRange.put("1", 1);
        parallelYearsRange.put("2", 2);
        parallelYearsRange.put("3", 3);
        parallelYearsRange.put("4", 4);
        parallelYearsRange.put("5", 5);
        parallelYearsRange.put("6", 6);
        parallelYearsRange.put("7", 7);
        parallelYearsRange.put("8", 8);
        parallelYearsRange.put("9", 9);
        parallelYearsRange.put("10", 10);
        parallelYearsRange.put("11", 11);
        parallelYearsRange.put("12", 12);
        parallelYearsRange.put("13", 13);
        parallelYearsRange.put("14", 14);
        parallelYearsRange.put("15", 15);
        parallelYearsRange.put("16", 16);
        parallelYearsRange.put("17", 17);
        parallelYearsRange.put("18", 18);
        parallelYearsRange.put("19", 19);
        parallelYearsRange.put("20+", 20);

        for (String key : parallelYearsRange.keySet())
        {
            parallelYearsInput.getItems().add(key);
        }

        parallelYearsInput.setValue(parallelYearsRange.keySet().iterator().next());

        for (int i = 1; i < 22; i++)
        {
            totalYearsSince2002Input.getItems().add(i);
        }

        totalYearsSince2002Input.setValue(1);
    }

    @FXML
    private void onContinueButtonHoverEnter()
    {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), continueButton);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

    @FXML
    private void onContinueButtonHoverExit()
    {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), continueButton);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

}
