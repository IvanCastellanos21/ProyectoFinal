package org.example.modelo;

import org.example.persistencia.DemoAnimalesDomesticosDB;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class TablaAnimalesDomesticos implements TableModel{
    private ArrayList<AnimalesDomesticos> datos; // Datos de la tabla
    public static final int COLS = 6; // Número de columnas
    private org.example.persistencia.DemoAnimalesDomesticosDB aniDom = new org.example.persistencia.DemoAnimalesDomesticosDB(); // Objeto de acceso a datos

    public TablaAnimalesDomesticos() {
        datos = new ArrayList<>(); // Inicializar la lista de datos
    }

    public TablaAnimalesDomesticos(ArrayList<AnimalesDomesticos> datos, TablaAnimalesDomesticos audi) {
        this.datos = datos; // Establecer los datos recibidos
    }


    public int getRowCount() {
        return datos.size(); // Obtener el número de filas
    }


    public int getColumnCount() {
        return COLS; // Obtener el número de columnas
    }


    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id"; // Nombre de la columna 0
            case 1:
                return "URLImagen"; // Nombre de la columna 1
            case 2:
                return "Especie"; // Nombre de la columna 2
            case 3:
                return "Alimentacion"; // Nombre de la columna 3
            case 4:
                return "EsperanzaVida"; // Nombre de la columna 4
            case 5:
                return "Habitat"; // Nombre de la columna 5
        }
        return null;
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class; // Clase de la columna 0
            case 1:
                return String.class; // Clase de la columna 1
            case 2:
                return String.class; // Clase de la columna 2
            case 3:
                return String.class; // Clase de la columna 3
            case 4:
                return Integer.class; // Clase de la columna 4
            case 5:
                return String.class; // Clase de la columna 5
        }
        return null;
    }


    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // Las celdas no son editables
    }


    public Object getValueAt(int rowIndex, int columnIndex) {
        AnimalesDomesticos tpm = datos.get(rowIndex); // Obtener el objeto AnimalesDomesticos en la fila rowIndex
        switch (columnIndex) {
            case 0:
                return tpm.getId(); // Valor de la columna 0
            case 1:
                return tpm.getURLdeImagen(); // Valor de la columna 1
            case 2:
                return tpm.getEspecie(); // Valor de la columna 2
            case 3:
                return tpm.getAlimentacion(); // Valor de la columna 3
            case 4:
                return tpm.getEsperanzaVida(); // Valor de la columna 4
            case 5:
                return tpm.getHabitat(); // Valor de la columna 5
        }
        return null;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                int nuevoId = Integer.parseInt((String) aValue); // Convertir el nuevo ID a entero
                datos.get(rowIndex).setId(nuevoId); // Establecer el nuevo ID en el objeto AnimalesDomesticos correspondiente
                break;
            case 1:
                datos.get(rowIndex).setURLdeImagen((String) aValue); // Establecer la nueva URL de imagen en el objeto AnimalesDomesticos correspondiente
                break;
            case 2:
                datos.get(rowIndex).setEspecie((String) aValue); // Establecer la nueva especie en el objeto AnimalesDomesticos correspondiente
                break;
            case 3:
                datos.get(rowIndex).setAlimentacion((String) aValue); // Establecer el nuevo tipo de alimentacion en el objeto AnimalesDomesticos correspondiente
                break;
            case 4:
                datos.get(rowIndex).setEsperanzaVida((int) aValue); // Establecer la nueva esperanza de vida en el objeto AnimalesDomesticos correspondiente
                break;
            case 5:
                datos.get(rowIndex).setHabitat((String) aValue); // Establecer la nueva habitat en el objeto AnimalesDomesticos correspondiente
                break;
            default:
                System.out.println("No ha cambiado nada"); // Mensaje por defecto cuando no se ha cambiado nada
        }
    }


    public void addTableModelListener(TableModelListener l) {
    }


    public void removeTableModelListener(TableModelListener l) {
    }

    public ArrayList<AnimalesDomesticos> getDatos() {
        return datos; // Obtener los datos de la tabla
    }

    public void setDatos(ArrayList<AnimalesDomesticos> datos) {
        this.datos = datos; // Establecer los datos de la tabla
    }

    public DemoAnimalesDomesticosDB getAniDom() {
        return aniDom; // Obtener el objeto AniDom
    }

    public void setAniDom(DemoAnimalesDomesticosDB audi) {
        this.aniDom = audi; // Establecer el objeto DemoAnimalesDomesticosDB
    }

    public void cargarTablas() {
        try {
            datos = aniDom.obtenerTodo(); // Cargar los datos de la base de datos
        } catch (SQLException sqle) {
            System.out.println("Error"); // Mostrar un mensaje de error
        }
    }

    public boolean agregarAnimalDom(AnimalesDomesticos animalesDomesticos) {
        boolean resultado = false;
        try {
            // Obtener el último ID de la lista de datos
            int ultimoId = 0;
            if (!datos.isEmpty()) {
                AnimalesDomesticos ultimoAnimalDom = datos.get(datos.size() - 1);
                ultimoId = ultimoAnimalDom.getId();
            }

            // Incrementar el último ID en 1 para obtener el nuevo ID
            int nuevoId = ultimoId + 1;

            // Establecer el nuevo ID en el objeto animalesDomesticos
            animalesDomesticos.setId(nuevoId);

            // Insertar el audifono en la base de datos
            if (aniDom.insertar(animalesDomesticos)) {
                datos.add(animalesDomesticos);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public boolean modificarAnimalDom(AnimalesDomesticos animalesDomesticos) {
        boolean resultado = true;
        try {
            if (aniDom.update(animalesDomesticos)) {
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public boolean eliminarAnimalDom(String id) {
        boolean resultado = false;
        try {
            if (aniDom.delete(id)) {
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public AnimalesDomesticos getAnimalesDomesticosAtIndex(int index) {
        if (index >= 0 && index < datos.size()) {
            return datos.get(index);
        } else {
            return null; // o lanzar una excepción indicando que el índice está fuera de los límites válidos
        }
    }
}
