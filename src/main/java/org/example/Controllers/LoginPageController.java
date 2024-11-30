package org.example.Controllers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginPageController
{

    public BooleanProperty readyToContinue = new SimpleBooleanProperty(false);

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
            readyToContinue.set(true);
            System.out.println("Right");
        }
        else
        {
            errorLabel.setText("Ο κωδικός που πληκτρολογήσατε είναι λανθασμένος.");
        }
    }


}
