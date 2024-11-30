package org.example.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class LoginPageController
{

    private boolean readyToContinue = false;

    @FXML
    private TextField passwordInput;
    @FXML
    private Label errorLabel;
    @FXML
    private Button loginButton;

    @FXML
    public void onLoginButtonClicked()
    {
        String correctPassword = "8989";
        String attemptedPassword = passwordInput.getText();

        if (correctPassword.equals(attemptedPassword))
        {
            readyToContinue = true;
            errorLabel.setText("Right");
            System.out.println("Right");
        }
        else
        {
            errorLabel.setText("Ο κωδικός που πληκτρολογήσατε είναι λανθασμένος.");
        }
    }

}
