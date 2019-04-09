package org.gruppe44.models;

import javafx.scene.control.Alert;

public class Alertbox {
    public Alertbox(String message) {
        // konstruktør som tar inn en String. Denne Stringen skrives ut til alertboxen.
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informasjon");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}
