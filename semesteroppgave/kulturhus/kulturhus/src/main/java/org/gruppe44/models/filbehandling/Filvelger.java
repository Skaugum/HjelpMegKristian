package org.gruppe44.models.filbehandling;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Filvelger {

    public static File chosenFile() {
        // denne gjør at brukeren må velge en fil.
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        String currentPath = Paths.get("./").toAbsolutePath().normalize().toString(); // finner øverste directory
        fileChooser.setInitialDirectory(new File(currentPath)); // setter dette som default directory ved valg av fil.
        fileChooser.setInitialFileName(String.valueOf(new File("fileToSave.txt"))); // setter default filnavn
        fileChooser.setTitle("Velg fil"); // tittel
        fileChooser.getExtensionFilters().addAll( // legger til valgmuligheter når det kommer til filer
                new FileChooser.ExtensionFilter("CSV", "*.csv"),
                new FileChooser.ExtensionFilter("JOBJ", "*.jobj"));
        File selectedFile = fileChooser.showSaveDialog(stage); // iverksetter det nye vinduet for valg av fil
        return selectedFile; // returnerer et File objekt
    }

    public static void setFilewriterStrategy(File file, Object object) {
        // denne metoden finner filtypen til File objektet.
        String extension = ""; // instansierer String

        try {
            String name = file.getName(); // henter ut det fulle navnet til File objektet
            extension = name.substring(name.lastIndexOf(".")); // deler opp navnet slik at alt, til og med "." vises.
        } catch (Exception e) {
            extension = "";
        }

        switch(extension) {
            case ".csv":
                CsvFilewriter wcf = new CsvFilewriter();
                wcf.writeToFile(object, file);
                break;
            case ".jobj":
                JobjFilewriter wjf = new JobjFilewriter();
                wjf.writeToFile(object, file);
                break;
        }
        // return extension; // returnerer filformatet som en String
    }

    public static void setFilereaderStrategy(File file, Object object) {
        // denne metoden finner filtypen til File objektet.
        String extension = ""; // instansierer String

        try {
            if (file != null && file.exists()) {
                String name = file.getName(); // henter ut det fulle navnet til File objektet
                extension = name.substring(name.lastIndexOf(".")); // deler opp navnet slik at alt, til og med "." vises.
            }
        } catch (Exception e) {
            extension = "";
        }

        switch(extension) {
            case ".csv":
                CsvFileReader cfr = new CsvFileReader();
                try {
                    cfr.readFile(file);
                } catch (IOException e) {
                    System.out.println("Kunne ikke lese fil");
                }
                break;
            case ".jobj":
                JobjFilewriter wjf = new JobjFilewriter();
                wjf.writeToFile(object, file);
                break;
        }
        // return extension; // returnerer filformatet som en String
    }
}
