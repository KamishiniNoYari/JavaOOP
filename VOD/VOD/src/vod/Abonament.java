/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

import java.io.Serializable;

/**
 *
 * @author Krystian
 * Klasa Abonament
 */
public class Abonament implements Serializable {
    private String typ;
    private float cena;
    private int okres;
    private int ilosc_urzadzen;
    private String rozdzielczosc;
    private Boolean oplacony = false;
/**
 * Sprawdza czy abonament stały jest opłacony
 * @return oplacony
 */
    public Boolean getOplacony() {
        return oplacony;
    }
/**
 * 
 * @param oplacony 
 * sprawdza czy jest oplacony
 */
    public void setOplacony(Boolean oplacony) {
        this.oplacony = oplacony;
    }
/**
 * generuje abonament w zależności od typu
 * @param typ 
 * generuje abonament w zależności od typu

 */
    public Abonament(String typ)
    {
        switch(typ)
        {
            case "Basic":
                
                this.typ = typ;
                this.cena = 20;
                this.okres = 30;
                this.ilosc_urzadzen = 1;
                this.rozdzielczosc = "480p";
                
                break;
            case "Family":
                
                this.typ = typ;
                this.cena = 30;
                this.okres = 30;
                this.ilosc_urzadzen = 4;
                this.rozdzielczosc = "480p";
                
                break;
            case "Premium":
                
                this.typ = typ;
                this.cena = 40;
                this.okres = 30;
                this.ilosc_urzadzen = 10;
                this.rozdzielczosc = "FullHD";
                
                
                break;
                
                
        }
        
    }
/**
 * 
 * @return
 * Zwraca ilosć urządzeń
 */    
    public int getIlosc_urzadzen() {
        return ilosc_urzadzen;
    }
/**
 * @param ilosc_urzadzen
 * ustawia ilość urzadzeń na których można oglądać jednocześnie

 */
    public void setIlosc_urzadzen(int ilosc_urzadzen) {
        this.ilosc_urzadzen = ilosc_urzadzen;
    }
    /**
     * 
     * @return 
     * zwraca maksymalną możliwą rozdzielczość
     */

    public String getRozdzielczosc() {
        return rozdzielczosc;
    }
    /**
     * 
     * @param rozdzielczosc 
     * ustawia rozdzielczosc
     */
    public void setRozdzielczosc(String rozdzielczosc) {
        this.rozdzielczosc = rozdzielczosc;
    }
/**
 * 
 * @return 
 * zwraca typ abonamentu
 */
    public String getTyp() {
        return typ;
    }
/**
 * 
 * @param typ 
 * ustawia typ abonamentu
 */
    public void setTyp(String typ) {
        this.typ = typ;
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
 * ustawia cenę
 * @param cena 
 * ustawia cenę
 */
    public void setCena(float cena) {
        this.cena = cena;
    }
/**
 * zwraca okres trwania
 * @return 
 *  * zwraca okres trwania
 */
    public int getOkres() {
        return okres;
    }
/**
 * ustawia okres trwania
 * @param okres 
 * ustawia okres trwania
 */
    public void setOkres(int okres) {
        this.okres = okres;
    }
    
}
