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

    }

    public CentralView getCentralView() {
        return centralView;
    }

    public void setCentralView(CentralView centralView) {
        this.centralView = centralView;
    }



}
