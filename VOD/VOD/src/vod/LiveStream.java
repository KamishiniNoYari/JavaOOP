/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

import vod.Produkt;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Krystian
 */
public final class LiveStream extends Produkt implements Serializable {
    private Date data_wys;
    private int czas_wys;
    private float cena;
    
    /**
     *
     * @param wlasciciel
     * xxx
     * @param id
     * xxx
     * @param data
     * xxx
     */
    public LiveStream(String wlasciciel,int id,Date data){
        this.setData_wys(data);
        this.setCena();
        this.setCzas_trwania();
        this.setId(id);
        this.setOcena();
        //this.setZdjecie();
        this.setOpis();
        this.setDataProdukcji();
        this.setNazwa();
        this.setCzas_wys();
        this.setWlasciciel(wlasciciel);
        
    }

    /**
     *
     * @return
     * zwraca date wystawienia
     */
    public Date getData_wys() {
        return data_wys;
    }

    /**
     *
     * @param data
     * ustawia datę wystawienia
     */
    public void setData_wys(Date data) 
    {

        this.data_wys = data;
    }

    /**
     *
     * @return
     * zwraca czas wystawiania
     */
    public int getCzas_wys() {
        return czas_wys;
    }

    /**
     *
     */
    public void setCzas_wys() {
        Random r = new Random();
        this.czas_wys = 100+r.nextInt(100);
    }

    /**
     *
     * @return
     * zwraca cenę
     */
    public float getCena() {
        return cena;
    }

    /**
     *
     */
    public void setCena() {
        Random r = new Random();
        this.cena = r.nextInt(19)+r.nextFloat();
    }

    /**
     *
     * @param cena
     * ponowne ustawienie ceny
     */
    public void resetCena(float cena)
    {
        this.cena = cena;
    }
    
    
}
