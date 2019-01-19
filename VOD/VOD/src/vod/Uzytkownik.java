/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author Krystian
 */
 public abstract  class Uzytkownik implements Serializable{

    /**
     *
     */
    protected int id;

    /**
     *
     */
    protected String nazwa;

    /**
     *
     */
    protected LocalDate data_urodzenia;

    /**
     *
     */
    protected String e_mail;

    /**
     *
     */
    protected long numer_karty;

    /**
     *
     */
    protected volatile long stan_konta;
     
    /**
     *
     */
    public Uzytkownik(){};

    /**
     *
     * @return
     * zwraca ID
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     * ustawia id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     * zwraca nazwę
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     *
     * @param nazwa
     * ustawia nazwe
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     *
     * @return
     * zwraca Datę Urodzenia
     */
    public LocalDate getData_urodzenia() {
        return data_urodzenia;
    }

    /**
     *
     */
    public void setData_urodzenia() {
        Random r=new Random();
        int minDay = (int) LocalDate.of(1900,1,1).toEpochDay();
        int maxDay = (int) LocalDate.of(2000,1,1).toEpochDay();
        long randomDay = minDay + r.nextInt(maxDay-minDay);
        this.data_urodzenia = LocalDate.ofEpochDay(randomDay);
    }

    /**
     *
     * @return
     * zwraca E_mail
     */
    public String getE_mail() {
        return e_mail;
    }

    /**
     *
     */
    public void setE_mail() {
        this.e_mail = nazwa + "@gmail.com";
    }

    /**
     *
     * @return
     * zwraca numer karty
     */
    public long  getNumer_karty() {
        return numer_karty;
    }

    /**
     *
     */
    public void setNumer_karty() {
        Random r=new Random();
        this.numer_karty =r.nextLong();
    }

    /**
     *
     * @return
     * zwraca stan konta
     */
    public long getStan_konta() {
        return stan_konta;
    }

    /**
     *
     */
    public void setStan_konta(){
        Random r = new Random();
        this.stan_konta=100+r.nextInt(50000);
    }
}
