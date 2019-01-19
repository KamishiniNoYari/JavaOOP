/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author Krystian
 */
public class Serial extends StalyProdukt implements Serializable {
    private int sezony=1;
    private ArrayList<Odcinek> odcinki= new ArrayList<>();
    
    /**
     *
     * @param wlasciciel
     * xxx
     * @param data_produkcji
     * xxx
     * @param id
     * xxx
     * @throws FileNotFoundException
     * tworzy serial
     */
    public Serial(String wlasciciel,Date data_produkcji,int id) throws FileNotFoundException
    {
        setId(id);
        setNazwa();
        setDataProdukcji(data_produkcji);
        setWlasciciel(wlasciciel);
        setOcena();
        setLista_aktorow();
        setOpis();
        setCena();
        
        
        
        
    }

    /**
     *
     * @return
     * zwraca int sezony
     */
    public int getSezony() {
        return sezony;
    }

    /**
     *
     * @param sezony
     * ustawia liczbe sezonów
     */
    public void setSezony(int sezony) {
        this.sezony = sezony;
    }

    /**
     *
     * @return
     * zwraca odcinki
     */
    @Override
    public ArrayList<Odcinek> getOdcinki() {
        return odcinki;
    }
    
    /**
     *
     * @param a
     * dodaje odcinek do listy
     */
    public void dodajOdcinek(Odcinek a){
        odcinki.add(a);
    }
    
    /**
     *
     * @param data_produkcji
     * ustawia datę produkcji
     */
    public void setDataProdukcji(Date data_produkcji)
    {
        this.dataProdukcji=data_produkcji;
    }

    /**
     *
     * @return
     * zwraca datę produkcji
     */
    @Override
    public Date getDataProdukcji()
    {
        return dataProdukcji;
    }
    
    /**
     *
     * @param odcinki
     * ustawia odcinki
     */
    public void setOdcinki(ArrayList<Odcinek> odcinki) {
        this.odcinki = odcinki;
    }
    
            
    
}
