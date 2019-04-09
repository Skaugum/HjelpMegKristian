package org.gruppe44.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Arrangement implements Serializable {
    private String navn;
    private String medvirkende;
    private String type;
    private Lokale lokale;
    private Kontaktperson kontaktperson;
    private LocalDate dato;
    private String start;
    private String slutt;
    private String pris;

    public Arrangement(String navn, String medvirkende, String type, Lokale lokale, Kontaktperson kontaktperson,
                       LocalDate dato, String start, String slutt, String pris) {
        // konstruktør for Arrangement
        this.navn = navn;
        this.medvirkende = medvirkende;
        this.type = type;
        this.lokale = lokale;
        this.kontaktperson = kontaktperson;
        this.dato = dato;
        this.start = start;
        this.slutt = slutt;
        this.pris = pris;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getMedvirkende() {
        return medvirkende;
    }

    public void setMedvirkende(String arrMedvirkende) {
        this.medvirkende = medvirkende;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Lokale getLokale() {
        return lokale;
    }

    public void setLokale(Lokale lokale) {
        this.lokale = lokale;
    }

    public Kontaktperson getKontaktperson() {
        return this.kontaktperson;
    }

    public void setKontaktperson(Kontaktperson arrKontaktperson) {
        this.kontaktperson = kontaktperson;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getSlutt() {
        return slutt;
    }

    public void setSlutt(String slutt) {
        this.slutt = slutt;
    }

    public String getPris() {
        return pris;
    }

    public void setPris(String pris) {
        this.pris = pris;
    }

    /*
    @Override
    public String toString() {
        return "Arrangement{" +
                "navn='" + navn + '\'' +
                ", medvirkende='" + medvirkende + '\'' +
                ", type='" + type + '\'' +
                ", lokale=" + lokale +
                ", kontaktperson=" + kontaktperson +
                ", dato=" + dato +
                ", start='" + start + '\'' +
                ", slutt='" + slutt + '\'' +
                ", pris='" + pris + '\'' +
                '}';
    }
    */

    @Override
    public String toString() {
        return navn + ";" + medvirkende + ";" + type + ";" + lokale + ";" + kontaktperson + ";" +
                dato + ";" + start + ";" + slutt + ";" + pris + ";";
    }
}
