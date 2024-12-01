package org.example.Controllers;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.example.Views.CentralView;

import java.util.ArrayList;
import java.util.Collection;

public class CentralController
{
    private CentralView centralView;

    public CentralController()
    {

        centralView = new CentralView();

        LoginPageController loginPageController = centralView.getLoginPageLoader().getController();
        BasicChoicePageController basicChoicePageController = centralView.getBasicChoicePageLoader().getController();
        QuickCalcPageController quickCalcPageController = centralView.getQuickCalcPageLoader().getController();
        SimpleResultPageController simpleResultPageController = centralView.getSimpleResultPageLoader().getController();


        loginPageController.readyToContinue.addListener((observableValue, aBoolean, t1) ->
        {
            centralView.changeViews(0);
        });

        basicChoicePageController.quickCalculation.addListener((observableValue, aBoolean, t1) ->
        {
            centralView.changeViews(0);
        });

        quickCalcPageController.isReadyForResult.addListener((observableValue, aBoolean, t1) ->
        {
            if(quickCalcPageController.userWantsDisabilityCalculation.get())
            {
                simpleResultPageController.getNationalPensionData().setPensioDataByDisability(quickCalcPageController.disabilityPercentage,
                        quickCalcPageController.totalYears * 300);
                simpleResultPageController.userWantsDisabilityCalculation = true;
            }
            else
            {
                simpleResultPageController.getNationalPensionData().setPensioDataByAge(quickCalcPageController.age, 0,
                        quickCalcPageController.residenceYears, quickCalcPageController.totalYears * 300);
            }

            simpleResultPageController.getContributoryPensionData().setDataSimple(quickCalcPageController.medianSalary,
                    quickCalcPageController.totalYears * 300, quickCalcPageController.parallelYears, quickCalcPageController.posostoEisforas);

            centralView.changeViews(0);
        });

    }

    public CentralView getCentralView() {
        return centralView;
    }

    public void setCentralView(CentralView centralView) {
        this.centralView = centralView;
    }



}
