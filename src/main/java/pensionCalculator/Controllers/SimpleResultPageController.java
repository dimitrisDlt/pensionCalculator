package pensionCalculator.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import pensionCalculator.Core.ContributoryPensionCalculator;
import pensionCalculator.Core.NationalPensionCalculator;
import pensionCalculator.Models.ContributoryPensionData;
import pensionCalculator.Models.NationalPensionData;

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
        double result = 0;

        if (userWantsDisabilityCalculation)
        {
            nationalPensionTitleLabel.setText("Εθνική Σύνταξη (Αναπηρίας)");
            double currentPension = 426.17;
            double workYearsReduction = nationalPensionCalculator.getReductionByInsuranceYears(currentPension, nationalPensionData.getEnsima());
            double pensionReducedByWorkYears = currentPension - workYearsReduction;
            resultWorkYearsDecreaseLabel.setText("-" + String.format("%.2f", workYearsReduction) + "€");
            baladerAssignLabel.setText("Μείωση λόγω ποσοστού αναπηρίας");
            double disabilityReduction = nationalPensionCalculator.getReductionByDisabilityPercentage(pensionReducedByWorkYears, nationalPensionData.getDisabilityPercentage());
            double pensionReducedByDisability = pensionReducedByWorkYears - disabilityReduction;
            baladerDecreaseLabel.setText("-" + String.format("%.2f", disabilityReduction) + "€");
            resultAgeDereaseLabel.setVisible(false);
            decreaseByAgeAssignLabel.setVisible(false);
            resultNationalPensionLabel.setText(String.format("%.2f", pensionReducedByDisability) + "€");
            result += pensionReducedByDisability;
        }
        else
        {
            nationalPensionTitleLabel.setText("Εθνική Σύνταξη (Γήρατος)");
            double currentPension = 426.17;
            double workYearsReduction = nationalPensionCalculator.getReductionByInsuranceYears(currentPension, nationalPensionData.getEnsima());
            double pensionReducedByWorkYears = currentPension - workYearsReduction;

            resultWorkYearsDecreaseLabel.setText("-" + String.format("%.2f", workYearsReduction) + "€");
            baladerAssignLabel.setText("Μείωση λόγω ετών διαμονής:");
            double residenceYearsReduction = nationalPensionCalculator.getReductionByResidenceYears(pensionReducedByWorkYears, nationalPensionData.getResidenceYears());

            double pensionReducedByResidenceYears = pensionReducedByWorkYears - residenceYearsReduction;
            baladerDecreaseLabel.setText("-" + String.format("%.2f", residenceYearsReduction) + "€");
            double ageReduction = nationalPensionCalculator.getReductionByAge(pensionReducedByResidenceYears, nationalPensionData.getAgeYears(), nationalPensionData.getAgeMonths());
            double pensionReducedByAge = pensionReducedByResidenceYears - ageReduction;
            System.out.println(nationalPensionData.getAgeYears());
            System.out.println(nationalPensionData.getAgeMonths());
            System.out.println(ageReduction);
            System.out.println(pensionReducedByAge);
            resultAgeDereaseLabel.setText("-" + String.format("%.2f", ageReduction) + "€");
            resultNationalPensionLabel.setText(String.format("%.2f", pensionReducedByAge) + "€");
            result += pensionReducedByAge;
        }

        resultMedianSalaryLabel.setText(String.format("%.2f", contributoryPensionData.getMedianSalary()) + "€");
        resultTotalYearsLabel.setText(String.valueOf(contributoryPensionData.getEtiAsfalisis()) + " έτη.");
        resultPosostoAnaplirosisLabel.setText(String.format("%.2f", contributoryPensionCalculator.getPosostaAnaplirosis().get(contributoryPensionData.getEtiAsfalisis())) + "%");
        resultParallelAdditionLabel.setText("+0%");
        resultContribPensionLabel.setText(String.format("%.2f", contributoryPensionCalculator.getContributoryPensionCalculator(contributoryPensionData.getMedianSalary(),
                contributoryPensionData.getEtiAsfalisis())) + "€");

        result += contributoryPensionCalculator.getContributoryPensionCalculator(contributoryPensionData.getMedianSalary(), contributoryPensionData.getEtiAsfalisis());

        resultLabel.setText("Συνολικό ποσό κύριας σύνταξης: " + String.format("%.2f", result) + "€" + " (" + resultNationalPensionLabel.getText() + " η εθνική και " + resultContribPensionLabel.getText() + " η ανταποδοτική σύνταξη).");
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
