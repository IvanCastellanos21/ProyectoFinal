package org.example.controlador;


import org.example.modelo.AnimalesDomesticos;
import org.example.modelo.TablaAnimalesDomesticos;
import org.example.vista.Ventana;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;

public class ControladorAnimalesDomesticos extends MouseAdapter{

    private Ventana view;
    private TablaAnimalesDomesticos modelo;

    public ControladorAnimalesDomesticos(Ventana view) {
        this.view = view;
        modelo = new TablaAnimalesDomesticos();
        this.view.getTblAnimalesDom().setModel((TableModel) modelo);
        this.view.getBtnCargar().addMouseListener((MouseListener) this);
        this.view.getBtnAgregar().addMouseListener((MouseListener) this);
        this.view.getBtnActualizar().addMouseListener((MouseListener) this);
        this.view.getBtnEliminar().addMouseListener((MouseListener) this);
        this.view.getBtnCorregirID().addMouseListener((MouseListener) this);
        this.view.getTblAnimalesDom().addMouseListener((MouseListener) this);
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getBtnCargar()) {
            modelo.cargarTablas();
            this.view.getTblAnimalesDom().setModel((TableModel) modelo);
            this.view.getTblAnimalesDom().updateUI();
        }

        if (e.getSource() == this.view.getBtnAgregar()) {
            System.out.println("Se presionó el botón Agregar");
            try {
                String especie = validarEspecie(this.view.getTxtEspecie().getText());
                String alimentacion = validarAlimentacion(this.view.getTxtAlimentacion().getText());
                String esperanza = String.valueOf(validarEsperanzaVida(Integer.parseInt(this.view.getTxtEsperanzaVida().getText())));
                String habitat = validarHabitat(this.view.getTxtHabitat().getText());
                String urlFoto = validarUrlImagen(this.view.getTxtUrlConexion().getText());

                AnimalesDomesticos animalDom = new AnimalesDomesticos();
                animalDom.setId(0);
                animalDom.setURLdeImagen(urlFoto);
                animalDom.setEspecie(especie);
                animalDom.setAlimentacion(alimentacion);
                animalDom.setEsperanzaVida(Integer.parseInt(esperanza));
                animalDom.setHabitat(habitat);

                if (modelo.agregarAnimalDom(animalDom)) {
                    JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    this.view.getTblAnimalesDom().updateUI();
                } else {
                    JOptionPane.showMessageDialog(view, "No se pudo agregar", "Error al Insertar", JOptionPane.ERROR_MESSAGE);
                }
                this.view.clean();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == this.view.getTblAnimalesDom()) {
            System.out.println("Evento sobre tabla");
            int index = this.view.getTblAnimalesDom().getSelectedRow();
            AnimalesDomesticos tmp = modelo.getAnimalesDomesticosAtIndex(index);
            try {
                ImageIcon imagenAudifono = tmp.getImagenAnimalesDomesticos();
                if (imagenAudifono != null) {
                    this.view.getLblImagenAnimal().setIcon(imagenAudifono);
                } else {
                    this.view.getLblImagenAnimal().setIcon(null);
                    System.out.println("No se pudo obtener la imagen del animal.");
                }
            } catch (MalformedURLException mfue) {
                System.out.println("Error al obtener la imagen del animal: " + mfue.toString());
                this.view.getLblImagenAnimal().setIcon(null);
            }
            this.view.getTxtEspecie1().setText(tmp.getEspecie());
            this.view.getTxtAlimentacion1().setText(tmp.getAlimentacion());
            this.view.getTxtEsperanzaVida1().setText(String.valueOf(tmp.getEsperanzaVida()));
            this.view.getTxtHabitat1().setText(tmp.getHabitat());
            this.view.getTxtUrlConexion1().setText(tmp.getURLdeImagen());
        }

        if (e.getSource() == this.view.getBtnActualizar()) {
            System.out.println("Evento sobre boton Actualizar");
            int rowIndex = this.view.getTblAnimalesDom().getSelectedRow();
            AnimalesDomesticos tmp = modelo.getAnimalesDomesticosAtIndex(rowIndex);
            AnimalesDomesticos animalesDomesticos = new AnimalesDomesticos();
            animalesDomesticos.setURLdeImagen(this.view.getTxtUrlConexion().getText());
            animalesDomesticos.setEspecie(this.view.getTxtEspecie1().getText());
            animalesDomesticos.setAlimentacion(this.view.getTxtAlimentacion1().getText());
            animalesDomesticos.setEsperanzaVida(Integer.parseInt(this.view.getTxtEsperanzaVida1().getText()));
            animalesDomesticos.setHabitat(this.view.getTxtHabitat1().getText());
            animalesDomesticos.setId(tmp.getId());
            if (modelo.modificarAnimalDom(animalesDomesticos)) {
                JOptionPane.showMessageDialog(view, "Se modificó correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                modelo.cargarTablas();
                this.view.getTblAnimalesDom().setModel((TableModel) modelo);
                this.view.getTblAnimalesDom().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo modificar", "Error al Insertar", JOptionPane.ERROR_MESSAGE);
            }
            this.view.getTblAnimalesDom().updateUI();
        }

        if (e.getSource() == this.view.getBtnEliminar()) {
            TablaAnimalesDomesticos temp = new TablaAnimalesDomesticos();
            int index = this.view.getTblAnimalesDom().getSelectedRow();
            AnimalesDomesticos tmp = modelo.getAnimalesDomesticosAtIndex(index);
            if (temp.eliminarAnimalDom(Integer.toString(tmp.getId()))) {
                JOptionPane.showMessageDialog(view, "Se eliminó correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                modelo.cargarTablas();
                this.view.getTblAnimalesDom().updateUI();
                this.view.clean();
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo eliminar la base", "Error al insertar", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == this.view.getBtnCorregirID()) {
            corregirID();
        }

        this.view.clean();
    }

    private void corregirID() {
        int rowCount = modelo.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            AnimalesDomesticos audifono = modelo.getAnimalesDomesticosAtIndex(i); //Cosas sin usarse???
            audifono.setId(i + 1);
            modelo.modificarAnimalDom(audifono);
        }
        modelo.cargarTablas();
        this.view.getTblAnimalesDom().updateUI();
        JOptionPane.showMessageDialog(view, "Se corrigieron los IDs correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    private String validarEspecie(String especie) {
        if (especie.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo Especie no puede estar vacío.");
        }
        if (!Character.isLetter(especie.charAt(0))) {
            throw new IllegalArgumentException("El campo Especie debe comenzar con una letra.");
        }
        if (especie.length() < 3) {
            throw new IllegalArgumentException("El campo Especie debe tener al menos 3 caracteres.");
        }
        return especie;
    }

    //Aqui valida cada uno de los datos
    private String validarAlimentacion(String Alimentacion) {
        if (Alimentacion.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo Alimentacion no puede estar vacío.");
        }
        if (!Character.isLetter(Alimentacion.charAt(0))) {
            throw new IllegalArgumentException("El campo Alimentacion debe comenzar con una letra.");
        }
        if (Alimentacion.length() < 3) {
            throw new IllegalArgumentException("El campo Alimentacion debe tener al menos 3 caracteres.");
        }
        return Alimentacion;
    }

    private int validarEsperanzaVida(int EsperanzaVida) {
        return EsperanzaVida;
    }

    private String validarHabitat(String Habitat) {
        if (Habitat.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo Habitat no puede estar vacío.");
        }
        if (!Character.isLetter(Habitat.charAt(0))) {
            throw new IllegalArgumentException("El campo Habitat debe comenzar con una letra.");
        }
        if (Habitat.length() < 3) {
            throw new IllegalArgumentException("El campo Habitat debe tener al menos 3 caracteres.");
        }
        return Habitat;
    }

    private String validarUrlImagen(String urlFoto) {
        if (urlFoto.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo URL de la imagen no puede estar vacío.");
        }
        if (!urlFoto.startsWith("https://")) {
            throw new IllegalArgumentException("La URL de la imagen no tiene el formato correcto.");
        }
        return urlFoto;
    }
}
