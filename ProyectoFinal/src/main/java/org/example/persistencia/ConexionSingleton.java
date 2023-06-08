package org.example.persistencia; // Paquete de la clase

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSingleton {
    private String baseDatos; // Nombre de la base de datos
    private Connection connection; // Conexión a la base de datos
    private static ConexionSingleton _instance; // Instancia única de la clase

    public ConexionSingleton(String baseDatos) {
        this.baseDatos = baseDatos;
        try {
            //Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + this.baseDatos); // Establecer la conexión a la base de datos
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprimir la traza de errores
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir la traza de errores
        }
    }

    public static ConexionSingleton getInstance(String baseDatos) {
        if (_instance == null) {
            _instance = new ConexionSingleton(baseDatos); // Crear una nueva instancia si no existe una
        } else {
            System.out.println("Ya fue creada"); // Mostrar un mensaje si ya se ha creado una instancia
        }
        return _instance; // Devolver la instancia existente o recién creada
    }

    public Connection getConnection() {
        return connection; // Devolver la conexión a la base de datos
    }
}
