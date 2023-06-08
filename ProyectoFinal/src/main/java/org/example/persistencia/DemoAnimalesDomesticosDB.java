package org.example.persistencia;

import org.example.modelo.AnimalesDomesticos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class DemoAnimalesDomesticosDB implements InterfazAniDom{
    private static int ultimoId = 0; // Variable estática para almacenar el último ID utilizado

    public DemoAnimalesDomesticosDB() {
    }

    public static int getUltimoId() { // Método estático para obtener el último ID utilizado
        return ultimoId;
    }

    public static void setUltimoId(int nuevoUltimoId) { // Método estático para establecer el último ID utilizado
        ultimoId = nuevoUltimoId;
    }


    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO AnimalesDomesticos(URLImagen, Especie, Alimentacion, EsperanzaVida, Habitat) VALUES (?, ?, ?, ?, ?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("baseDatos.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((AnimalesDomesticos)obj).getURLdeImagen()); // Establecer el valor de URLdeImagen en el PreparedStatement
        pstm.setString(2, ((AnimalesDomesticos)obj).getEspecie()); // Establecer el valor de Especie en el PreparedStatement
        pstm.setString(3, ((AnimalesDomesticos)obj).getAlimentacion()); // Establecer el valor de Alimentacion en el PreparedStatement
        pstm.setInt(4, ((AnimalesDomesticos)obj).getEsperanzaVida()); // Establecer el valor de EsperanzaVida en el PreparedStatement
        pstm.setString(5, ((AnimalesDomesticos)obj).getHabitat()); // Establecer el valor de Habitat en el PreparedStatement
        rowCount = pstm.executeUpdate(); // Ejecutar la consulta de inserción
        return rowCount > 0; // Devolver true si se insertó al menos una fila
    }


    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE AnimalesDomesticos SET URLImagen = ?, Especie = ?, Alimentacion = ?, EsperanzaVida = ?, Habitat = ? WHERE Id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("baseDatos.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((AnimalesDomesticos)obj).getURLdeImagen()); // Establecer el valor de Marca en el PreparedStatement
        pstm.setString(2, ((AnimalesDomesticos)obj).getEspecie()); // Establecer el valor de Tipo en el PreparedStatement
        pstm.setString(3, ((AnimalesDomesticos)obj).getAlimentacion()); // Establecer el valor de Color en el PreparedStatement
        pstm.setInt(4, ((AnimalesDomesticos)obj).getEsperanzaVida()); // Establecer el valor de Conexion en el PreparedStatement
        pstm.setString(5, ((AnimalesDomesticos)obj).getHabitat()); // Establecer el valor de UrlFoto en el PreparedStatement
        pstm.setInt(6, ((AnimalesDomesticos)obj).getId()); // Establecer el valor de Id en el PreparedStatement
        rowCount = pstm.executeUpdate(); // Ejecutar la consulta de actualización
        return rowCount > 0; // Devolver true si se actualizó al menos una fila
    }


    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM AnimalesDomesticos WHERE Id = ?";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("baseDatos.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id)); // Establecer el valor de Id en el PreparedStatement
        rowCount = pstm.executeUpdate(); // Ejecutar la consulta de eliminación
        return rowCount > 0; // Devolver true si se eliminó al menos una fila
    }


    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM AnimalesDomesticos";
        ArrayList<AnimalesDomesticos> resultado = new ArrayList<>();

        Statement stm = ConexionSingleton.getInstance("AnimalesDomesticosDB.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql); // Ejecutar la consulta de selección
        while (rst.next()){
            // Crear un objeto Audifono a partir de los datos obtenidos de la base de datos
            resultado.add(new AnimalesDomesticos(rst.getInt("Id"), rst.getString("URLImagen"), rst.getString("Especie"), rst.getString("Alimentacion"), rst.getInt("EsperanzaVida"), rst.getString("Habitat")));
        }
        return resultado; // Devolver la lista de objetos Audifono
    }


    public AnimalesDomesticos buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM AnimalesDomesticos WHERE Id = ?";
        AnimalesDomesticos audifono = null;

        PreparedStatement pstm = ConexionSingleton.getInstance("AnimalesDomesticosDB.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id)); // Establecer el valor de Id en el PreparedStatement
        ResultSet rst = pstm.executeQuery(); // Ejecutar la consulta de selección
        if (rst.next()){
            // Crear un objeto Audifono a partir de los datos obtenidos de la base de datos
            audifono = new AnimalesDomesticos(rst.getInt("Id"), rst.getString("URLImagen"), rst.getString("Especie"), rst.getString("Alimentacion"), rst.getInt("EsperanzaVida"), rst.getString("Habitat"));
        }
        return audifono; // Devolver el objeto Audifono encontrado (o null si no se encontró)
    }

}
