/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import javax.imageio.ImageIO;
import vod.Odcinek;

/**
 *
 * @author Krystian
 */
public abstract class Produkt implements Serializable {
    int id;
    private int czas_trwania;
    private String opis;
    private float ocena;
    String nazwa;
    private BufferedImage zdjecie;
    Date dataProdukcji;
    private String wlasciciel;
    private float procent=0;
    private volatile int ilosc_obejrzen=0;
    private volatile int ilosc_kupionych=0;
    private ArrayList<Integer> obejrzenia = new ArrayList();
    private final ArrayList<Date> daty = new ArrayList();

    /**
     *
     * @return
     * zwraca Daty do wykresu
     */
    public ArrayList<Date> getDaty() {
        return daty;
    }
    
    /**
     *
     * @param data
     * dodaje datę do listy dat
     */
    public void dodajData(Date data){
        daty.add(data);
    }
    
    /**
     *
     * @return
     * zwraca listę obejrzeń
     */
    public ArrayList<Integer> getObejrzenia() {
        return obejrzenia;
    }

    /**
     *
     * @param obejrzenia
     * ustawia liste oglądalności
     */
    public void setObejrzenia(ArrayList<Integer> obejrzenia) {
        this.obejrzenia = obejrzenia;
    }

    /**
     *
     */
    public void dodajObejrzenie()
    {
        obejrzenia.add(ilosc_obejrzen);
    }

    /**
     *
     * @return
     * zwraca ilość obejrzeń w danym dniu
     */
    public int getIlosc_obejrzen() {
        return ilosc_obejrzen;
    }

    /**
     *
     * @param ilosc_obejrzen
     * ustawia ilość objerzeń
     */
    public void setIlosc_obejrzen(int ilosc_obejrzen) {
        this.ilosc_obejrzen = ilosc_obejrzen;
    }

    /**
     *
     * @return
     * zwraca procent
     */
    public float getProcent() {
        return procent;
    }

    /**
     *
     * @param procent
     * ustawia procent
     */
    public void setProcent(float procent) {
        this.procent = procent;
    }

    /**
     *
     * @return
     * zwraca id
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
     * zwraca czas trwania
     */
    public int getCzas_trwania() {
        return czas_trwania;
    }

    /**
     *
     */
    public void setCzas_trwania() {
        Random r = new Random();
        this.czas_trwania = czas_trwania=r.nextInt(300);
    }

    /**
     *
     * @return
     * zwraca opis
     */
    public String getOpis() {
        return opis;
    }

    /**
     *
     */
    public void setOpis() {
        this.opis = "";
    }

    /**
     *
     * @return
     * zwraca ocenę
     */
    public float getOcena() {
        return ocena;
    }

    /**
     *
     */
    public void setOcena() {
        Random r = new Random();
        this.ocena = r.nextInt(10);
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
     * @return
     * zwraca ilosc kupionych
     */
    public int getIlosc_kupionych() {
        return ilosc_kupionych;
    }

    /**
     *
     * @param ilosc_kupionych
     * ustawia ilosc kupionych
     */
    public void setIlosc_kupionych(int ilosc_kupionych) {
        this.ilosc_kupionych = ilosc_kupionych;
    }

    /**
     *generator nazw
     */
    public void setNazwa() {
        String[] tab0 ={"Wielka",
                        "Gwiezdna",
                        "Kosmiczna",
                        "Wojownicza",
                        "Przerażająca",
                        "Niszcząca",
                        "Nieosobliwa",
                        "Rozwalająca",
                        "Smutna",
                        "Rozsierdzona",
                        "Bolesna",
                        "Załamana",
                        "Niezniszczalna",
                        "Oblana",
                        "Martwa",
                        "Okrutna",
                        "Brudna"
                        
    };
        String[] tab1 ={"Magda Gessler",
                        "Siostra Godlewska",
                        "Masakra",
                        "Doda",
                        "Maryja",
                        "Kanapka",
                        "Owca",
                        "Lama",
                        "Maryla Rodowicz",
                        "Kayah"
                        
    };
        String[] tab2 ={"Martwe",
                        "Zabawne",
                        "Wzruszające",
                        "Ortodoksyjne",
                        "Śmierdzące",
                        "Roztańczone",
                        "Smutne",
                        "Bolesne",
                        "Okrutne",
                        "Wojownicze",
                        "Pijane",
        };
        String[] tab3 ={"Płody",
                        "Studenty",
                        "Psy",
                        "Noże",
                        "Mariuszki",
                        "Ogony",
                        "Pietruszki"
        };
        
        
        Random r=new Random();
        int i0=r.nextInt(tab0.length);
        int i1=r.nextInt(tab1.length);
        int i2=r.nextInt(tab2.length);
        int i3=r.nextInt(tab3.length);
        
        
        this.nazwa = tab0[i0] + " "+ tab1[i1] + " i " + tab2[i2] + " " + tab3[i3];
    }

    /**
     *
     * @return
     * zwraca zdjęcie
     */
    public BufferedImage getZdjecie() {
        return zdjecie;
    }

    /**
     *
     */
    public void setZdjecie() {
        File imageFile = new File("1.jpg");
        try {
            this.zdjecie = ImageIO.read(imageFile);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     * zwraca datę produkcji
     */
    public Date getDataProdukcji() {
        return dataProdukcji;
    }

    /**
     *
     */
    public void setDataProdukcji() {
        Random r=new Random();
        int minDay = (int) LocalDate.of(1900,1,1).toEpochDay();
        int maxDay = (int) LocalDate.of(2000,1,1).toEpochDay();
        long randomDay = minDay + r.nextInt(maxDay-minDay);
        LocalDate x = LocalDate.ofEpochDay(randomDay);
        Date date = java.sql.Date.valueOf(x);
        this.dataProdukcji = date;
    }
    
    /**
     *
     * @return
     * zwraca nazwę właściciela
     */
    public String getWlasciciel(){
        return wlasciciel;
    }

    /**
     *
     * @param wlasciciel
     * ustawia wlaściciela
     */
    public void setWlasciciel(String wlasciciel){
        this.wlasciciel=wlasciciel;
    }

    /**
     *
     * @return
     * zwraca odcinki
     */
    public ArrayList<Odcinek> getOdcinki() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     * zwraca cenę
     */
    public float getCena() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param a
     * dodaje odcinek do listy
     */
    public void dodajOdcinek(Odcinek a){
        
    }

    void setDataProdukcji(Date data) {
        this.dataProdukcji = data;
    }

    /**
     *
     * @param cena
     * ponownie ustawia cenę
     */
    public void resetCena(float cena)
    {
        
    }

    /**
     *
     */
    public synchronized void kup()
    {
        this.ilosc_kupionych++;
    }

    /**
     *
     * @param ilosc
     * zwiększa ilosc obejrzeń
     */
    public synchronized void obejrzyj(int ilosc)
    {
        int temp = ilosc_obejrzen + ilosc;
        this.ilosc_obejrzen = temp;
    }
}
