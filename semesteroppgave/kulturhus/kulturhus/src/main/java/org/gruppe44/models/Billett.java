package org.gruppe44.models;

import java.io.Serializable;

public class Billett implements Serializable {
    private String plassNr;
    private String lokaleNavn;
    private String dato;
    private String klokkeslett;
    private int pris;
    private String telefonNr;

    public Billett(String plassNr, String lokaleNavn, String dato, String klokkeslett, int pris, String telefonNr){
        this.plassNr = plassNr;
        this.lokaleNavn = lokaleNavn;
        this.dato = dato;
        this.klokkeslett = klokkeslett;
        this.pris = pris;
        this.telefonNr = telefonNr;
    }

    public String getPlassNr(){
        return this.plassNr;
    }

    public void setPlassNr(String plassNr){
        this.plassNr = plassNr;
    }

    public String getLokaleNavn(){
        return this.lokaleNavn;
    }

    public void setLokaleNavn(String lokaleNavn){
        this.lokaleNavn = lokaleNavn;
    }

    public String getDato(){
        return this.dato;
    }

    public void setDato(String dato){
        this.dato = dato;
    }

    public int getPris(){
        return this.pris;
    }

    public void setPris(int pris){
        this.pris = pris;
    }

    public String getTelefonNr() {
        return telefonNr;
    }

    public void setTelefonNr(String telefonNr) {
        this.telefonNr = telefonNr;
    }

    public String getKlokkeslett() {
        return klokkeslett;
    }

    public void setKlokkeslett(String klokkeslett) {
        this.klokkeslett = klokkeslett;
    }

    @Override
    public String toString() {
        return "Billett{" +
                "plassNr='" + plassNr + '\'' +
                ", lokaleNavn='" + lokaleNavn + '\'' +
                ", dato='" + dato + '\'' +
                ", klokkeslett='" + klokkeslett + '\'' +
                ", pris=" + pris +
                ", telefonNr='" + telefonNr + '\'' +
                '}';
    }
}
