package org.example;

import org.example.controlador.ControladorAnimalesDomesticos; // Importar la clase Ventana del paquete Vista
import org.example.vista.Ventana; // Importar la clase ControladorAudifonos del paquete Controlador

public class Main {
    public static void main(String[] args) {
        Ventana ventana = new Ventana("Tabla de Animales Domesticos"); // Crear una instancia de la clase Ventana
        ControladorAnimalesDomesticos controlador = new ControladorAnimalesDomesticos(ventana); // Crear una instancia del controlador
    }
}