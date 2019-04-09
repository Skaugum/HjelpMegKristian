package org.gruppe44.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.gruppe44.models.Alertbox;
import org.gruppe44.models.Exceptions.InvalidInputException;
import org.gruppe44.models.Lokale;
import org.gruppe44.models.filbehandling.Filvelger;

import java.io.File;

public class RegistrerLokaleController {

    @FXML
    private TextField txtLokalenavn;

    @FXML
    private TextField txtAntplasser;

    @FXML
    private TextField txtTypelokale;

    @FXML
    private Button btnRegistrerlokale;

    @FXML
    private void knappTrykket(ActionEvent e) throws InvalidInputException{
        try {
            String navn = txtLokalenavn.getText();
            String antallPlasser = txtAntplasser.getText();
            String type = txtTypelokale.getText();

            Lokale lokale = new Lokale(navn, type, antallPlasser);
            Filvelger filvelger = new Filvelger(); // åpner fildialog og velger fil for lagring
            File fil = filvelger.chosenFile(); // returnerer Fileobjekt som det skal lagres til
            filvelger.setFilewriterStrategy(fil, lokale); // velger hvilken type filobjekt som skal opprettes
            Alertbox alertbox = new Alertbox("Lagringen var vellykket!"); // alertbox ved vellykket lagring!
        }
        catch(NumberFormatException a) {
            throw new InvalidInputException("Fyll inn felter med gyldig data! Antall plasser kan bare inneholde tall");
        }

    }
}
