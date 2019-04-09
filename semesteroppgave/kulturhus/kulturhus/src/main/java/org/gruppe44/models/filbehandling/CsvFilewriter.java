package org.gruppe44.models.filbehandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFilewriter extends BaseFilewriter {

    @Override
    public void writeToFile(Object object, File file) {
        // dette er metoden for å skrive til .csv fil.
        String path = file.getPath();
        try {
            FileWriter fileWriter = new FileWriter(path, true); // setter modus til append (true).
            PrintWriter printWriter = new PrintWriter(fileWriter); // lager et objekt som inneholder teksten vi skal appende.
            printWriter.println(object);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
