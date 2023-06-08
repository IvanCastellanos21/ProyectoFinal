package org.example.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;

import org.example.modelo.AnimalesDomesticos;
import java.sql.SQLException;
import java.util.ArrayList;
public interface InterfazAniDom {
    public abstract boolean insertar(Object obj) throws SQLException; // Método abstracto para insertar un objeto en la base de datos
    public abstract boolean update(Object obj) throws SQLException; // Método abstracto para actualizar un objeto en la base de datos
    public abstract boolean delete(String id) throws SQLException; // Método abstracto para eliminar un objeto de la base de datos
    public abstract ArrayList obtenerTodo() throws SQLException; // Método abstracto para obtener todos los objetos de la base de datos
    public abstract AnimalesDomesticos buscarPorId(String id) throws SQLException; // Método abstracto para buscar un objeto por
}
