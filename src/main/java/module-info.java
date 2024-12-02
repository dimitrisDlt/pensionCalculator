module pensionCalculator {
    requires javafx.controls;
    requires javafx.fxml;
    exports pensionCalculator;
    exports pensionCalculator.Controllers;
    opens pensionCalculator.Controllers to javafx.fxml;
}
