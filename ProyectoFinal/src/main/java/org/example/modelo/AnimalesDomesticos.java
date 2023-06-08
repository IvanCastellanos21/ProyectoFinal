package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class AnimalesDomesticos {
    private int id; //ID de la entrada de tabla
    private String URLdeImagen; //URL del animal
    private String Especie; //Especie del animal
    private String Alimentacion; //Alimentacion del animal
    private int EsperanzaVida; //Esperanza de vida del animal
    private String Habitat; //Habitat del animal

    public AnimalesDomesticos(int id, String URLdeImagen, String especie, String alimentacion, int esperanzaVida, String habitat) {
        this.id = id;
        this.URLdeImagen = URLdeImagen;
        Especie = especie;
        Alimentacion = alimentacion;
        EsperanzaVida = esperanzaVida;
        Habitat = habitat;
    }

    public AnimalesDomesticos() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getURLdeImagen() {
        return URLdeImagen;
    }

    public void setURLdeImagen(String URLdeImagen) {
        this.URLdeImagen = URLdeImagen;
    }

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String especie) {
        Especie = especie;
    }

    public String getAlimentacion() {
        return Alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        Alimentacion = alimentacion;
    }

    public int getEsperanzaVida() {
        return EsperanzaVida;
    }

    public void setEsperanzaVida(int esperanzaVida) {
        EsperanzaVida = esperanzaVida;
    }

    public String getHabitat() {
        return Habitat;
    }

    public void setHabitat(String habitat) {
        Habitat = habitat;
    }

    @Override
    public String toString() {
        return "AnimalesDomesticos{" +
                "id=" + id +
                ", URLdeImagen='" + URLdeImagen + '\'' +
                ", Especie='" + Especie + '\'' +
                ", Alimentacion='" + Alimentacion + '\'' +
                ", EsperanzaVida=" + EsperanzaVida +
                ", Habitat='" + Habitat + '\'' +
                '}';
    }

    // Método para obtener la imagen del animal
    public ImageIcon getImagenAnimalesDomesticos() throws MalformedURLException {
        URL urlImagen = new URL(URLdeImagen);
        return new ImageIcon(urlImagen);
    }
}
