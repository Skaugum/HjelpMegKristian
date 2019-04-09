package org.gruppe44.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.gruppe44.models.Alertbox;
import org.gruppe44.models.Kontaktperson;
import org.gruppe44.models.filbehandling.Filvelger;
import org.gruppe44.models.Exceptions.InvalidInputException;

import java.io.File;

public class RegistrerKontaktpersonController {

    // Initiering av fxml elementer fra registrerKontaktperson.fxml
    @FXML
    private TextField txtFornavn;

    @FXML
    private TextField txtEtternavn;

    @FXML
    private TextField txtAlder;

    @FXML
    private TextField txtTelefonnr;

    @FXML
    private TextField txtEpost;

    @FXML
    private TextField txtNettside;

    @FXML
    private TextField txtFirma;

    @FXML
    private TextField txtInformasjon;

    @FXML
    private Button btnRegistrer;

    @FXML
    private void registrerKontaktperson(ActionEvent e) throws InvalidInputException {

        try { // usikker på om dette kan gjøres utenfor Controlleren. Uønskelig med logikk i controlleren.
            var fornavn = txtFornavn.getText();
            var etternavn = txtEtternavn.getText();
            int alder = Integer.parseInt(txtAlder.getText());
            long telefonnr = Long.parseLong(txtTelefonnr.getText()); // se kommentar over.
            var epost = txtEpost.getText(); // kan lages metoder for å undersøke om formatet er gyldig: navn@adresse.com
            var nettside = txtNettside.getText();
            var firma = txtFirma.getText();
            var informasjon = txtInformasjon.getText();

            Kontaktperson kontaktperson = new Kontaktperson(fornavn, etternavn, alder, telefonnr, epost, nettside, firma, informasjon);
            Filvelger fil = new Filvelger();
            File valgtFil = fil.chosenFile();
            fil.setFilewriterStrategy(valgtFil, kontaktperson);
            Alertbox alertbox = new Alertbox("Lagringen var vellykket!"); // oppretter en alert når lagringen var vellykket.
        }
        catch(NumberFormatException a) {
            throw new InvalidInputException("Fyll inn felter med gyldig data! Alder og tlf kan bare inneholde tall.");
        }

        Stage stage = (Stage) btnRegistrer.getScene().getWindow(); // henter stage hvor "btnRegistrer" er tilhørende
        stage.close(); // lukker vinduet for registrering av kontaktperson.
    }
}
