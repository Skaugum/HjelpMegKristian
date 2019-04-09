package org.gruppe44.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class Lokale extends Object implements Serializable {
    private StringProperty lokaleNavn;
    private StringProperty type;
    private StringProperty antPlasser;

    public Lokale(String lokaleNavn, String type, String antPlasser) {
        this.lokaleNavn = new SimpleStringProperty(lokaleNavn);
        this.type = new SimpleStringProperty(type);
        this.antPlasser = new SimpleStringProperty(antPlasser);
    }

    public String getLokaleNavn() {
        return lokaleNavnProperty().get();
    }
    public void setLokaleNavn(String lokaleNavn) {
        lokaleNavnProperty().set(lokaleNavn);
    }
    public StringProperty lokaleNavnProperty() {
        if(lokaleNavn == null) lokaleNavn = new SimpleStringProperty(this, "lokaleNavn");
        return lokaleNavn;
    }

    public String getType() {
        return typeProperty().get();
    }
    public void setType(String type) {
        typeProperty().set(type);
    }
    public StringProperty typeProperty() {
        if(type == null) type = new SimpleStringProperty(this, "type");
        return type;
    }

    public String getAntPlasser() {
        return antPlasserProperty().get();
    }
    public void setAntPlasser(String antPlasser) {
        antPlasserProperty().set(antPlasser);
    }
    public StringProperty antPlasserProperty() {
        if(antPlasser == null) antPlasser = new SimpleStringProperty(this, "antPlasser");
        return antPlasser;
    }

    @Override
    public String toString(){
        return getLokaleNavn() + ";" + getType() + ";" + getAntPlasser();
    }
}