package org.gruppe44.models.filbehandling;

import org.gruppe44.models.Lokale;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader extends BaseFileReader {
    @Override
    public void readFile(File file) throws IOException {
        ArrayList <Object> objekter = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = Files.newBufferedReader(Paths.get(String.valueOf(file))); // merkmerk!
            String line = null; // leser første linje

            // leser resten av linjene og lager objekter for hver linje.
            while((line = reader.readLine()) != null) {
                objekter.add(line);
            }
        }
        finally {
            if(reader != null) {
                reader.close();
            }
        }
    }

    public static List<Lokale> readLokaleFromCSV(File file) throws IOException {
        List <Lokale> lokaler = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = Files.newBufferedReader(Paths.get(String.valueOf(file))); // merkmerk!
            String line = null; // leser første linje

            // leser resten av linjene og lager objekter for hver linje.
            while((line = reader.readLine()) != null) {
                String [] attributes = line.split(";");

                Lokale lokale = createLokale(attributes);
                lokaler.add(lokale);
            }
        }
        finally {
            if(reader != null) {
                reader.close();
            }
        }
        return lokaler;
    }

    private static Lokale createLokale(String[] metadata) {
        String navn = metadata[0];
        String type = metadata[1]; // create and return book of this metadata return new Book(name, price, author); }
        String antallPlasser = metadata[2];

        return new Lokale(navn, type, antallPlasser);
    }
}
