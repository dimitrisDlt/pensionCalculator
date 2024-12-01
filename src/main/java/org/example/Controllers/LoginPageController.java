package org.example.Controllers;

import javafx.animation.FadeTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class LoginPageController
{

    public BooleanProperty readyToContinue = new SimpleBooleanProperty(false);

    @FXML
    private PasswordField passwordInput;
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
            errorLabel.setText("Ο κωδικός που πληκτρολογήσατε είναι λανθασμένος. Παρακαλώ δοκιμάστε ξανά.");
        }
    }

    @FXML
    private void onLoginButtonHoverEnter()
    {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), loginButton);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
    }

    @FXML
    private void onLoginButtonHoverExit()
    {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), loginButton);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }



}
