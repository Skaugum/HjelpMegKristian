package org.gruppe44.models;

import java.io.Serializable;

public class Kontaktperson extends Person implements Serializable { // mulig Serializable er unødvendig siden den arver fra en Serializable klasse

    private String epostadresse;
    private String nettside;
    private String tilknyttetFirma;
    private String opplysninger;

    public Kontaktperson(String fornavn, String etternavn, int alder, long telefonNr, String epostadresse,
                         String nettside, String tilknyttetFirma, String opplysninger) {
        // mulig denne konstruktøren er for lang, få tilbakemelding!
        super(fornavn, etternavn, alder, telefonNr);
        this.epostadresse = epostadresse;
        this.nettside = nettside;
        this.tilknyttetFirma = tilknyttetFirma;
        this.opplysninger = opplysninger;
    }

    public String getEpostadresse() {
        return epostadresse;
    }

    public void setEpostadresse(String epostadresse) {
        this.epostadresse = epostadresse;
    }

    public String getNettside() {
        return nettside;
    }

    public void setNettside(String nettside) {
        this.nettside = nettside;
    }

    public String getTilknyttetFirma() {
        return tilknyttetFirma;
    }

    public void setTilknyttetFirma(String tilknyttetFirma) {
        this.tilknyttetFirma = tilknyttetFirma;
    }

    public String getOpplysninger() {
        return opplysninger;
    }

    public void setOpplysninger(String opplysninger) {
        this.opplysninger = opplysninger;
    }

    @Override
    public String toString() {
        return getFornavn() + ";" + getEtternavn() + ";" + getAlder() + ";" + getTelefonNr() + ";" +
                epostadresse + ";" + nettside + ";" + tilknyttetFirma + ";" + opplysninger;
    }
}
