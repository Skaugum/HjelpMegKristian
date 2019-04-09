package org.gruppe44.models.filbehandling;

import java.io.*;

public class JobjFilewriter extends BaseFilewriter{
    public void writeToFile(Object object, File file) {
        // dette er metoden for å skrive til .jobj fil ved hjelp av serialisering
        String path = file.getPath();
        try (
            FileOutputStream fos = new FileOutputStream(path, true); // FileOutputSteam er AutoClosable
            ObjectOutputStream out = new ObjectOutputStream(fos); // ObjectOutputStream er AutoClosable
        ) {
            out.writeObject(object);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
