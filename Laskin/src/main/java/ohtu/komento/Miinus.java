package ohtu.komento;

import ohtu.Sovelluslogiikka;

import javax.swing.*;

public class Miinus implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinen;

    public Miinus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        edellinen = sovellus.tulos();

        try {
            this.sovellus.miinus(Integer.parseInt(syotekentta.getText()));
        } catch (Exception e) {
        }


        this.syotekentta.setText("");
        this.tuloskentta.setText(String.valueOf(sovellus.tulos()));
    }

    @Override
    public void peru() {
        sovellus.setTulos(edellinen);
        tuloskentta.setText(String.valueOf(edellinen));
    }
}
