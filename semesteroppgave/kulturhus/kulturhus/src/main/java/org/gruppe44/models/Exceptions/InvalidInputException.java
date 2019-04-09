package org.gruppe44.models.Exceptions;

import javafx.scene.control.Alert;

public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informasjon");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}
