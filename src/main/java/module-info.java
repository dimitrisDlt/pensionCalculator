module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    exports org.example;
    exports org.example.Controllers;
    opens org.example.Controllers to javafx.fxml;
}
