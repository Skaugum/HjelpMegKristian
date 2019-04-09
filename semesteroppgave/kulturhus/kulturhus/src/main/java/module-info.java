module kulturhus {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.gruppe44.controllers to javafx.fxml;
    opens org.gruppe44.models to javafx.fxml;
    exports org.gruppe44;
    exports org.gruppe44.models; // hvorfor må vi gjøre dette ?!
}