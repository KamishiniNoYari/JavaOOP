/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

import vod.Uzytkownik;
import java.io.FileNotFoundException;
import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import vod.Film;
import vod.LiveStream;
import vod.Odcinek;
import vod.Produkt;
import vod.Serial;
import vod.Umowa;
import vod.Uzytkownik;
import static vod.Start.addId_produktu;
import static vod.Start.getId_produktu;
import static vod.Start.getStart_symulacji;
import static vod.Start.giveInfo;

/**
 *
 * @author Krystian
 */
public class Dystrybutor extends Uzytkownik implements Runnable,Serializable {
    private ArrayList<Produkt>produkty = new ArrayList();
    private ArrayList<Umowa>umowy = new ArrayList();
    private Boolean przerwanie = false;
    
    /**
     *
     * @param id
     * tworzy dystrybutora
     */
    public Dystrybutor(int id){
        
        setId(id);
        setNazwa();
        setData_urodzenia();
        setE_mail();
        setNumer_karty();     
        setStan_konta();
        
    }
    
    /**
     *
     * @param x
     * zwiększa stan konta
     */
    public synchronized void otrzymajZaplate(double x)
    {
        stan_konta+=x;
    }
            
    /**
     *
     * @return
     * zwraca produkty
     */
    public ArrayList<Produkt> getProdukty() {
        return produkty;
    }

    /**
     *
     * @param produkty
     * ustawia produkty
     */
    public void setProdukty(ArrayList<Produkt> produkty) {
        this.produkty = produkty;
    }

    /**
     *
     * @return
     * zwraca umowy
     */
    public ArrayList<Umowa> getUmowy() {
        return umowy;
    }

    /**
     *
     * @param umowy
     * ustawia umowy
     */
    public void setUmowy(ArrayList<Umowa> umowy) {
        this.umowy = umowy;
    }

    /**
     *
     * @return
     * zwraca przerwanie
     */
    public Boolean getPrzerwanie() {
        return przerwanie;
    }

    /**
     *
     * @param przerwanie
     * ustawia przerwanie
     */
    public void setPrzerwanie(Boolean przerwanie) {
        this.przerwanie = przerwanie;
    }

    /**
     *
     * @return
     * zwraca umowy
     */
    public ArrayList<Umowa> getUmowa() {
        return umowy;
    }

    /**
     *
     * @param umowa
     * ustawia umowy
     */
    public void setUmowa(ArrayList<Umowa> umowa) {
        this.umowy = umowa;
    }
    
    /**
     *
     */
    public void setNazwa()
    {
        this.nazwa="Dystrybutor "+id;
    }

    /**
     *
     * @throws ParseException
     * xxx
     * @throws FileNotFoundException
     * tworzy nową umowę
     */
    public void nowaUmowa() throws ParseException, FileNotFoundException
    {
        ArrayList<Produkt>p_umowa=new ArrayList();
        
        //losowanie typu umowy
        String[] typ1={"Stała","Procent","Miesieczna"};
        
        Random r = new Random();
        
        int i1 = r.nextInt(typ1.length);
        
        //tworzy produkty(od 1 do 3), które będzie chciał zaproponować w umowie
        //robi to losowo
        
        int i2 = 1; 
        
        //wybieranie typu produktu
        //dodawana data w serialu i livestream jest tylko tymczasowa
        //prawdziwa data jest ustalana po dodaniu produktu do bazy
        //data umowy równiez jest ustalana po dodaniu do bazy
        //id również zostanie zaktualizowane po dodaniu do bazy
        int i3 = r.nextInt(3);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date data = sdf.parse("00-00-0000");
        
        
       
        if (i3==0)
            
        {
            for (int i=0;i<i2;i++){     
                Produkt a = new Film(nazwa,getId_produktu());
                
                addId_produktu();
                
                p_umowa.add(a);
            }
            
            
        }
        if (i3==1)
        {
            for (int i = 0; i<i2; i++)
            {
                Produkt a = new LiveStream(nazwa,getId_produktu(),getStart_symulacji());
                addId_produktu();
                p_umowa.add(a);
            }
        }
        
        if (i3==2)
        {
            for (int i=0;i<i2;i++)
            {
                Produkt a = new Serial(nazwa,getStart_symulacji(),getId_produktu());
                addId_produktu();
                Produkt b = new Odcinek(nazwa,1,getStart_symulacji(),a.getNazwa(),getId_produktu(),a.getCena());
                addId_produktu();
                p_umowa.add(a);
                p_umowa.add(b);
                a.dodajOdcinek((Odcinek) b);
            }
        }
        
        produkty.addAll(p_umowa);
        
        Umowa u = new Umowa(typ1[i1],p_umowa);
        
        u.setData_podpisania(data);
        
        umowy.add(u);     
    }

    /**
     *
     */
    public void renegocjujUmowę()
    {
        //losuje sobie umowę z listy dostepnych umów, a następnie
        //sprawdza jej typ i losuje lepszy procent bądź cenę miesięczną
        
        Random r = new Random();
        
        int wybor = r.nextInt(umowy.size());
        
        switch (umowy.get(wybor).getTyp())
        {
            case "Stała":
                break;
            case "Procent":
                float wzrost = r.nextFloat()/10;
                
                float nowy_procent = umowy.get(wybor).getProcent()+wzrost;
                
                if (nowy_procent<=0.80)
                {
                    umowy.get(wybor).setProcent(nowy_procent);
                    for(int i = 0;i<umowy.get(wybor).getProdukty_w_umowie().size();i++ )
                    {
                        umowy.get(wybor).getProdukty_w_umowie().get(i).setProcent(nowy_procent);
                    }
                }
                break;
            case "Miesieczna":
                
                int wzrost_2=r.nextInt(50);
                
                int nowa_cena = (int) (umowy.get(wybor).getOplata_miesieczna()+wzrost_2);
                
                if (nowa_cena<=500)
                {
                    umowy.get(wybor).setOplata_miesieczna(nowa_cena);
                }
                break;
                
        }
                
    }
    
    @Override
    public void run() {

        while(przerwanie == false){
            if(umowy.isEmpty())
            {
                try {
                    nowaUmowa();
                    
                } catch (ParseException ex) {
                    Logger.getLogger(Dystrybutor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Dystrybutor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }

   
        
}
