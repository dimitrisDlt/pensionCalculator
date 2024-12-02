package org.example.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.example.Core.ContributoryPensionCalculator;
import org.example.Core.NationalPensionCalculator;
import org.example.Models.ContributoryPensionData;
import org.example.Models.NationalPensionData;

import java.net.URL;
import java.util.ResourceBundle;

public class SimpleResultPageController implements Initializable
{
    @FXML
    private Label nationalPensionTitleLabel;
    @FXML
    private Label resultWorkYearsDecreaseLabel;
    @FXML
    private Label baladerDecreaseLabel;
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
    @FXML
    private Label baladerAssignLabel;
    @FXML
    private Label decreaseByAgeAssignLabel;

    private NationalPensionData nationalPensionData = new NationalPensionData();
    private ContributoryPensionData contributoryPensionData = new ContributoryPensionData();
    private NationalPensionCalculator nationalPensionCalculator = new NationalPensionCalculator();
    private ContributoryPensionCalculator contributoryPensionCalculator = new ContributoryPensionCalculator();

    public boolean userWantsDisabilityCalculation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    public void setElements()
    {
        if (userWantsDisabilityCalculation)
        {
            nationalPensionTitleLabel.setText("Εθνική Σύνταξη (Αναπηρίας)");
            double currentPension = 426.17;
            double workYearsReduction = nationalPensionCalculator.getReductionByInsuranceYears(currentPension, nationalPensionData.getEnsima());
            double pensionReducedByWorkYears = currentPension - workYearsReduction;
            resultWorkYearsDecreaseLabel.setText("-" + String.valueOf(workYearsReduction) + "€");
            baladerAssignLabel.setText("Μείωση λόγω ποσοστού αναπηρίας");
            double disabilityReduction = nationalPensionCalculator.getReductionByDisabilityPercentage(pensionReducedByWorkYears, nationalPensionData.getDisabilityPercentage());
            double pensionReducedByDisability = pensionReducedByWorkYears - disabilityReduction;
            baladerDecreaseLabel.setText("-" + disabilityReduction + "€");
            resultAgeDereaseLabel.setVisible(false);
            decreaseByAgeAssignLabel.setVisible(false);
            resultNationalPensionLabel.setText(String.valueOf(pensionReducedByDisability) + "€");
        }
        else
        {
            nationalPensionTitleLabel.setText("Εθνική Σύνταξη (Γήρατος)");
            double currentPension = 426.17;
            double workYearsReduction = nationalPensionCalculator.getReductionByInsuranceYears(currentPension, nationalPensionData.getEnsima());
            double pensionReducedByWorkYears = currentPension - workYearsReduction;

            resultWorkYearsDecreaseLabel.setText("-" + String.valueOf(workYearsReduction) + "€");
            baladerAssignLabel.setText("Μείωση λόγω ετών διαμονής:");
            double residenceYearsReduction = nationalPensionCalculator.getReductionByResidenceYears(pensionReducedByWorkYears, nationalPensionData.getResidenceYears());

            double pensionReducedByResidenceYears = pensionReducedByWorkYears - residenceYearsReduction;
            baladerDecreaseLabel.setText("-" + residenceYearsReduction + "€");
            double ageReduction = nationalPensionCalculator.getReductionByAge(pensionReducedByResidenceYears, nationalPensionData.getAgeYears(), nationalPensionData.getAgeMonths());
            double pensionReducedByAge = pensionReducedByResidenceYears - ageReduction;
            System.out.println(nationalPensionData.getAgeYears());
            System.out.println(nationalPensionData.getAgeMonths());
            System.out.println(ageReduction);
            System.out.println(pensionReducedByAge);
            resultAgeDereaseLabel.setText("-" + ageReduction + "€");
            resultNationalPensionLabel.setText(String.valueOf(pensionReducedByAge) + "€");
        }

        resultMedianSalaryLabel.setText(String.valueOf(contributoryPensionData.getMedianSalary()) + "€");
        resultTotalYearsLabel.setText(String.valueOf(contributoryPensionData.getEtiAsfalisis()) + "€");
        resultPosostoAnaplirosisLabel.setText(String.valueOf(contributoryPensionCalculator.getPosostaAnaplirosis().get(contributoryPensionData.getEtiAsfalisis())));
        resultContribPensionLabel.setText(String.valueOf(contributoryPensionCalculator.getContributoryPensionCalculator(contributoryPensionData.getMedianSalary(),
                contributoryPensionData.getEtiAsfalisis())) + "€");
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
