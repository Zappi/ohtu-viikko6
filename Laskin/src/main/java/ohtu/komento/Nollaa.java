package ohtu.komento;

import ohtu.Sovelluslogiikka;

import javax.swing.*;

public class Nollaa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinen;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        edellinen = sovellus.tulos();
        this.sovellus.nollaa();
        this.syotekentta.setText("");
        this.tuloskentta.setText(String.valueOf(edellinen));
    }

    @Override
    public void peru() {
        tuloskentta.setText(String.valueOf(edellinen));
    }
}
