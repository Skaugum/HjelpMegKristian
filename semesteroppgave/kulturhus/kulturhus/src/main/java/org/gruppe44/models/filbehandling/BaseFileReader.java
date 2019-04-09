package org.gruppe44.models.filbehandling;

import java.io.File;
import java.io.IOException;

public abstract class BaseFileReader  {
    public abstract void readFile(File file) throws IOException;
}
