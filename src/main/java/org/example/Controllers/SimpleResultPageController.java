package org.example.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.example.Models.ContributoryPensionData;
import org.example.Models.NationalPensionData;

import java.net.URL;
import java.util.ResourceBundle;

public class SimpleResultPageController implements Initializable
{
    @FXML
    private Label nationalPensionTitle;
    @FXML
    private Label resultWorkYearsDecreaseLabel;
    @FXML
    private Label resultResidenceDecreaseLabel;
    @FXML
    private Label resultAgeDereaseLabel;
    @FXML
    private Label resultNationalPensionLabel;
    @FXML
    private Label resultMedianSalaryLabel;
    @FXML
    private Label resultTotalYearsLabel;
    @FXML
    private Label resultPosostoAnaplirosisLabel;
    @FXML
    private Label resultParallelAdditionLabel;
    @FXML
    private Label resultContribPensionLabel;
    @FXML
    private Label resultLabel;

    private NationalPensionData nationalPensionData = new NationalPensionData();
    private ContributoryPensionData contributoryPensionData = new ContributoryPensionData();

    public boolean userWantsDisabilityCalculation = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        if (userWantsDisabilityCalculation)
        {
            nationalPensionTitle.setText("Εθνική Σύνταξη (Αναπηρίας)");
        }

    }

    public NationalPensionData getNationalPensionData()
    {
        return nationalPensionData;
    }

    public ContributoryPensionData getContributoryPensionData()
    {
        return contributoryPensionData;
    }
}
