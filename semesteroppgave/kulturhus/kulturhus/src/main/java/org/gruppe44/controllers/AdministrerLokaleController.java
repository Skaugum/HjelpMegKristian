package org.gruppe44.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.gruppe44.models.Lokale;
import org.gruppe44.models.filbehandling.CsvFileReader;
import org.gruppe44.models.filbehandling.Filvelger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AdministrerLokaleController {

    @FXML
    TableView<Lokale> tabell = new TableView<>();

    public void initialize() throws IOException {

        Filvelger filvelger = new Filvelger();
        File fil = filvelger.chosenFile();
        CsvFileReader csv = new CsvFileReader();
        List<Lokale> liste = csv.readLokaleFromCSV(fil);
        ObservableList<Lokale> observableList = FXCollections.observableList(liste);

        tabell.setItems(observableList);

        TableColumn<Lokale, String> lokaleNavnKolonne = new TableColumn<>("Lokalets navn");
        TableColumn<Lokale, String> lokaleTypeKolonne = new TableColumn<>("Type lokale");
        TableColumn<Lokale, String> antallPlasserKolonne = new TableColumn<>("Antall plasser");
        lokaleNavnKolonne.setCellValueFactory(new PropertyValueFactory<>("lokaleNavn"));
        lokaleTypeKolonne.setCellValueFactory(new PropertyValueFactory<>("type"));
        antallPlasserKolonne.setCellValueFactory(new PropertyValueFactory<>("antPlasser"));

        tabell.getColumns().setAll(lokaleNavnKolonne, lokaleTypeKolonne, antallPlasserKolonne);

/*
        CsvFileReader csv = new CsvFileReader();
        List<Object> lokaleliste = csv.readFile(file);
        ObservableList<Object> observableListe = FXCollections.observableList(lokaleliste);
        System.out.println(lokaleliste); // hjelpekode
        tabell.setItems(observableListe);

        TableColumn<Object, String> lokaleNavnKolonne = new TableColumn<>("Lokalets navn");
        lokaleNavnKolonne.setCellValueFactory(new PropertyValueFactory<>(""));

        tabell.getColumns().setAll(lokaleNavnKolonne);
        */
    }

}
