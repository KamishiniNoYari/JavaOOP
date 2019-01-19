/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Krystian
 */
public class Film extends StalyProdukt implements Serializable {
    private ArrayList<String> linki;
    private Integer czas_po_zakupie=30;
    
    /**
     *
     * @param wlasciciel
     * xxx
     * @param id
     * xxx
     * @throws FileNotFoundException
     * tworzy film
     */
    public Film(String wlasciciel,int id) throws FileNotFoundException
    {
        setId(id);
        setNazwa();
        setCena();
        //setLista_aktorow();
        setDataProdukcji();
        setGatunek();
        setOcena();
        setWlasciciel(wlasciciel);
        setDataProdukcji();
        setOpis();
        setCzas_trwania();
    }
    
    /**
     *
     * @return
     * zwraca linki
     */
    public ArrayList<String> getLinki() {
        return linki;
    }

    /**
     *
     * @param linki
     * ustawia linki
     */
    public void setLinki(ArrayList<String> linki) {
        this.linki = linki;
    }

    /**
     *
     * @return
     * zwraca czas po zakupie
     */
    public Integer getCzas_po_zakupie() {
        return czas_po_zakupie;
    }

    /**
     *
     * @param czas_po_zakupie
     * ustawia czas po zakupie
     */
    public void setCzas_po_zakupie(Integer czas_po_zakupie) {
        this.czas_po_zakupie = czas_po_zakupie;
    }

    /**
     *
     * @param cena
     * pozwala ponownie ustawic cene
     */
    @Override
    public void resetCena(float cena)
    {
        this.cena = cena;
    }
    
}
