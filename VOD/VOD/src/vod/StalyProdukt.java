/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

import vod.Produkt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static jdk.nashorn.internal.parser.TokenType.EOF;

/**
 *
 * @author Krystian
 */
public abstract class StalyProdukt extends Produkt implements Serializable {
    private ArrayList<String> lista_aktorow = new ArrayList();
    private String gatunek;
    float cena;

    /**
     *
     * @return
     * zwraca listę aktorów
     */
    public ArrayList<String> getLista_aktorow() {
        return lista_aktorow;
    }

    /**
     *
     */
    public void setLista_aktorow()  
    {
        
        Random r = new Random();
        
        //Dla uproszczenia uznajemy że są tylko dwie płcie
        
        int kobiety = r.nextInt(5);
        
        int mezczyzni = r.nextInt(5);
        
        String[] k_tab = {"Małgorzata Kożuchowska", "Sonia Bohosiewcz" ,"Anna Dereszowska",
        "Sandra Bullock","Izabela Nizio","Izabela Kisio","Angelina Jolie","Natalie Portman",
        "Keira Knightley","Uma Thurman","Jennifer Lawrence","Magda Gessler"};
        
        String[] m_tab = {"Piotr Adamczyk","Leonardo DiCaprio","Leonardo DiCarpio","Tom Hanks",
        "Tom Cruise","Robert De Niro","Brad Pitt","Robert Downey Jr.","Matt Damon","Morgan Freeman","Dwayne Johnson"
        };
        
        for (int i = 0; i<kobiety;i++)lista_aktorow.add(k_tab[r.nextInt(k_tab.length)]);
        
        for (int i = 0; i<mezczyzni;i++)lista_aktorow.add(m_tab[r.nextInt(m_tab.length)]);
        
        //Oczywiscie zawsze dodajemy Tomka Karolaka bo co to za film bez Karolaka
        
        lista_aktorow.add("Tomasz Karolak");
                      
            
                
    }

    /**
     *
     * @return
     * zwraca gatunek
     */
    public String getGatunek() {
        return gatunek;
    }

    /**
     *
     */
    public void setGatunek() {
        String[] tab = {"Horror","Thriller","Komedia","Obyczajowy","Dramat","Akcja","Sci-fi"};
        Random r = new Random();
        this.gatunek = tab[r.nextInt(6)];
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
        this.cena = (float) (1+Math.random()*(10-1));
    }
                
   
    
    
    
}
