package org.gruppe44.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.gruppe44.models.Alertbox;
import org.gruppe44.models.Arrangement;
import org.gruppe44.models.Kontaktperson;
import org.gruppe44.models.Lokale;
import org.gruppe44.models.filbehandling.Filvelger;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class RegistrerArrangementController {

    @FXML
    private TextField txtArrangementNavn;

    @FXML
    private TextField txtMedvirkende;

    @FXML
    private TextField txtArrangementType;

    @FXML
    private ChoiceBox choiceLokale;

    @FXML
    private ChoiceBox choiceKontaktperson;

    @FXML
    private Button btnRegistrerKontaktperson;

    @FXML
    private DatePicker dateDato;

    @FXML
    private TextField txtStart;

    @FXML
    private TextField txtSlutt;

    @FXML
    private TextField txtPris;

    @FXML
    private Button btnRegistrer;

    // ActionEvent fra "Registrer arrangement" kommer under
    @FXML
    private void registrerArrangement(ActionEvent event) throws IOException {
        // Hendelse ved interaksjon med knappen "Registrer arrangement"
        var navn = txtArrangementNavn.getText();
        var medvirkende = txtMedvirkende.getText();
        var type = txtArrangementType.getText();
        Lokale lokale = (Lokale) choiceLokale.getValue(); // ønsker å hente ut et helt Lokaleobjekt.
        Kontaktperson kontaktperson = (Kontaktperson) choiceKontaktperson.getValue(); // ønsker å hente ut et Kontaktpersonobjekt.
        LocalDate dato = dateDato.getValue(); // henter ut valgt dato
        var start = txtStart.getText();
        var slutt = txtSlutt.getText();
        String pris = txtPris.getText();

        Arrangement arrangement = new Arrangement(navn, medvirkende, type, lokale, kontaktperson, dato, start, slutt, pris);
        Filvelger fil = new Filvelger(); // nytt Filvelger objekt
        File valgtFil = fil.chosenFile(); // bruker velger en fil. Returnerer et File-objekt.
        fil.setFilewriterStrategy(valgtFil, arrangement); // velger hvilken type filobjekt som skal opprettes
        Alertbox alertbox = new Alertbox("Lagringen var vellykket!"); // alertbox ved vellykket lagring!
    }

    @FXML
    private void registrerNyKontaktperson() {
        launchRegistrerKontaktpersonScene();
    }

    private void launchRegistrerKontaktpersonScene() {
        // denne initierer det nye registreringsvinduet, samt "låser" bakgrunnsvinduet.
        Parent root = null;

        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            root = fxmlLoader.load(getClass().getResource("registrerKontaktperson.fxml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        // add CSS etc. should be here
        Stage registrerKontaktpersonStage = new Stage(); // lager nytt vindu
        registrerKontaktpersonStage.setTitle("Registrer kontaktperson"); // setter tittel
        registrerKontaktpersonStage.setScene(scene);

        // set modality - låser "parent" winduet mens dette vinduet er åpent
        registrerKontaktpersonStage.initOwner(txtArrangementNavn.getScene().getWindow());
        registrerKontaktpersonStage.initModality(Modality.WINDOW_MODAL);
        registrerKontaktpersonStage.show();
    }
}
