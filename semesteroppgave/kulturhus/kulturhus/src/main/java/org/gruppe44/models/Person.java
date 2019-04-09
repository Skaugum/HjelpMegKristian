package org.gruppe44.models;

import java.io.Serializable;

public class Person implements Serializable {

    private String fornavn;
    private String etternavn;
    private int alder;
    private long telefonNr;

    public Person(String fornavn, String etternavn, int alder, long telefonNr) {
        // konstruktør for Person-klassen
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.alder = alder;
        this.telefonNr = telefonNr;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public long getTelefonNr() {
        return telefonNr;
    }

    public void setTelefonNr(long telefonNr) {
        this.telefonNr = telefonNr;
    }
}
