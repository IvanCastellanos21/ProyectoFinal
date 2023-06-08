package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame{
    // Labels
    private JLabel lblId;
    private JLabel lblEspecie;
    private JLabel lblAlimentacion;
    private JLabel lblEsperanzaVida;
    private JLabel lblHabitat;

    // Labels para imagenes
    private JLabel lblURLFoto;
    private JLabel lblImagenAnimal;

    // TextFields
    private JTextField txtId;
    private JTextField txtEspecie;
    private JTextField txtAlimentacion;
    private JTextField txtEsperanzaVida;
    private JTextField txtHabitat;
    private JTextField txtUrlConexion;

    // Buttons
    private JButton btnAgregar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnCargar;
    private JButton btnCorregirID;

    // Layout
    private GridLayout layout;

    // Table
    private JTable tblAnimalesDom;
    private JScrollPane scrTabla;

    // Panels
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    // Labels para el panel 4
    private JLabel lblId1;
    private JLabel lblEspecie1;
    private JLabel lblAlimentacion1;
    private JLabel lblEsperanzaVida1;
    private JLabel lblHabitat1;
    private JLabel lblUrlFoto1;

    // TextFields para el panel 4
    private JTextField txtEspecie1;
    private JTextField txtAlimentacion1;
    private JTextField txtEsperanzaVida1;
    private JTextField txtHabitat1;
    private JTextField txtUrlConexion1;


    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 800);

        // Configuración del layout
        layout = new GridLayout(2, 2);
        this.getContentPane().setLayout(layout);

        // Panel 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(111, 239, 137, 255));
        this.getContentPane().add(panel1, 0);

        // Labels y TextFields del panel 1
        lblId = new JLabel("Id: ");
        lblEspecie = new JLabel("Especie: ");
        lblAlimentacion = new JLabel("Alimentacion: ");
        lblEsperanzaVida = new JLabel("Esperanza de vida: ");
        lblHabitat = new JLabel("Habitat: ");
        lblURLFoto = new JLabel("URL Foto: ");

        txtId = new JTextField(2);
        txtEspecie = new JTextField(10);
        txtAlimentacion = new JTextField(10);
        txtEsperanzaVida = new JTextField(10);
        txtHabitat = new JTextField(5);
        txtUrlConexion = new JTextField(15);

        // Agregar los componentes al panel 1
        //panel1.add(lblId);
        //panel1.add(txtId);
        panel1.add(lblEspecie);
        panel1.add(txtEspecie);
        panel1.add(lblAlimentacion);
        panel1.add(txtAlimentacion);
        panel1.add(lblEsperanzaVida);
        panel1.add(txtEsperanzaVida);
        panel1.add(lblHabitat );
        panel1.add(txtHabitat );
        panel1.add(lblURLFoto);
        panel1.add(txtUrlConexion);
        btnAgregar = new JButton("Agregar");
        panel1.add(btnAgregar);

        // Panel 2
        panel2 = new JPanel(new BorderLayout());
        panel2.setBackground(new Color(248, 252, 167));
        this.getContentPane().add(panel2, 1);

        // Tabla y botón del panel 2
        tblAnimalesDom = new JTable();
        btnCargar = new JButton("Cargar");
        btnCorregirID = new JButton("Corregir ID");
        scrTabla = new JScrollPane(tblAnimalesDom);

        // Crear un panel auxiliar para centrar los botones
        JPanel panelBotones2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotones2.add(btnCargar);
        //panelBotones2.add(btnCorregirID);

        // Agregar los componentes al panel 2
        panel2.add(panelBotones2, BorderLayout.NORTH);
        panel2.add(scrTabla, BorderLayout.CENTER);
        panel2.add(scrTabla, BorderLayout.CENTER);

        // Panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(206, 142, 142));
        this.getContentPane().add(panel3, 2);

        // Label para la imagen de los audífonos
        lblImagenAnimal = new JLabel("....");
        this.panel3.add(lblImagenAnimal);

        // Panel 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(138, 189, 239, 116));
        this.getContentPane().add(panel4, 3);

        // Labels y TextFields del panel 4
        lblEspecie1 = new JLabel("Especie:");
        lblAlimentacion1 = new JLabel("Alimentacion:");
        lblEsperanzaVida1 = new JLabel("Esperanza de vida: ");
        lblHabitat1 = new JLabel("Habitat: ");
        lblUrlFoto1 = new JLabel("URL Foto:");
        txtEspecie1 = new JTextField(10);
        txtAlimentacion1= new JTextField(10);
        txtEsperanzaVida1 = new JTextField(10);
        txtHabitat1 = new JTextField(5);
        txtUrlConexion1 = new JTextField(15);
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");

        // Crear un panel auxiliar para centrar los botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);

        // Agregar los componentes al panel 4
        panel4.add(lblEspecie1);
        panel4.add(txtEspecie1);
        panel4.add(lblAlimentacion1);
        panel4.add(txtAlimentacion1);
        panel4.add(lblEsperanzaVida1);
        panel4.add(txtEsperanzaVida1);
        panel4.add(lblHabitat1);
        panel4.add(txtHabitat1);
        panel4.add(lblUrlFoto1);
        panel4.add(txtUrlConexion1);
        panel4.add(panelBotones);

        this.setVisible(true);
    }

    //Metodos de acceso
    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblEspecie() {
        return lblEspecie;
    }

    public void setLblEspecie(JLabel lblEspecie) {
        this.lblEspecie = lblEspecie;
    }

    public JLabel getLblAlimentacion() {
        return lblAlimentacion;
    }

    public void setLblAlimentacion(JLabel lblAlimentacion) {
        this.lblAlimentacion = lblAlimentacion;
    }

    public JLabel getLblEsperanzaVida() {
        return lblEsperanzaVida;
    }

    public void setLblEsperanzaVida(JLabel lblEsperanzaVida) {
        this.lblEsperanzaVida = lblEsperanzaVida;
    }

    public JLabel getLblHabitat() {
        return lblHabitat;
    }

    public void setLblHabitat(JLabel lblHabitat) {
        this.lblHabitat = lblHabitat;
    }

    public JLabel getLblURLFoto() {
        return lblURLFoto;
    }

    public void setLblURLFoto(JLabel lblURLFoto) {
        this.lblURLFoto = lblURLFoto;
    }

    public JLabel getLblImagenAnimal() {
        return lblImagenAnimal;
    }

    public void setLblImagenAnimal(JLabel lblImagenAnimal) {
        this.lblImagenAnimal = lblImagenAnimal;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtEspecie() {
        return txtEspecie;
    }

    public void setTxtEspecie(JTextField txtEspecie) {
        this.txtEspecie = txtEspecie;
    }

    public JTextField getTxtAlimentacion() {
        return txtAlimentacion;
    }

    public void setTxtAlimentacion(JTextField txtAlimentacion) {
        this.txtAlimentacion = txtAlimentacion;
    }

    public JTextField getTxtEsperanzaVida() {
        return txtEsperanzaVida;
    }

    public void setTxtEsperanzaVida(JTextField txtEsperanzaVida) {
        this.txtEsperanzaVida = txtEsperanzaVida;
    }

    public JTextField getTxtHabitat() {
        return txtHabitat;
    }

    public void setTxtHabitat(JTextField txtHabitat) {
        this.txtHabitat = txtHabitat;
    }

    public JTextField getTxtUrlConexion() {
        return txtUrlConexion;
    }

    public void setTxtUrlConexion(JTextField txtUrlConexion) {
        this.txtUrlConexion = txtUrlConexion;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JButton getBtnCorregirID() {
        return btnCorregirID;
    }

    public void setBtnCorregirID(JButton btnCorregirID) {
        this.btnCorregirID = btnCorregirID;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JTable getTblAnimalesDom() {
        return tblAnimalesDom;
    }

    public void setTblAnimalesDom(JTable tblAnimalesDom) {
        this.tblAnimalesDom = tblAnimalesDom;
    }

    public JScrollPane getScrTabla() {
        return scrTabla;
    }

    public void setScrTabla(JScrollPane scrTabla) {
        this.scrTabla = scrTabla;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getLblId1() {
        return lblId1;
    }

    public void setLblId1(JLabel lblId1) {
        this.lblId1 = lblId1;
    }

    public JLabel getLblEspecie1() {
        return lblEspecie1;
    }

    public void setLblEspecie1(JLabel lblEspecie1) {
        this.lblEspecie1 = lblEspecie1;
    }

    public JLabel getLblAlimentacion1() {
        return lblAlimentacion1;
    }

    public void setLblAlimentacion1(JLabel lblAlimentacion1) {
        this.lblAlimentacion1 = lblAlimentacion1;
    }

    public JLabel getLblEsperanzaVida1() {
        return lblEsperanzaVida1;
    }

    public void setLblEsperanzaVida1(JLabel lblEsperanzaVida1) {
        this.lblEsperanzaVida1 = lblEsperanzaVida1;
    }

    public JLabel getLblHabitat1() {
        return lblHabitat1;
    }

    public void setLblHabitat1(JLabel lblHabitat1) {
        this.lblHabitat1 = lblHabitat1;
    }

    public JLabel getLblUrlFoto1() {
        return lblUrlFoto1;
    }

    public void setLblUrlFoto1(JLabel lblUrlFoto1) {
        this.lblUrlFoto1 = lblUrlFoto1;
    }

    public JTextField getTxtEspecie1() {
        return txtEspecie1;
    }

    public void setTxtEspecie1(JTextField txtEspecie1) {
        this.txtEspecie1 = txtEspecie1;
    }

    public JTextField getTxtAlimentacion1() {
        return txtAlimentacion1;
    }

    public void setTxtAlimentacion1(JTextField txtAlimentacion1) {
        this.txtAlimentacion1 = txtAlimentacion1;
    }

    public JTextField getTxtEsperanzaVida1() {
        return txtEsperanzaVida1;
    }

    public void setTxtEsperanzaVida1(JTextField txtEsperanzaVida1) {
        this.txtEsperanzaVida1 = txtEsperanzaVida1;
    }

    public JTextField getTxtHabitat1() {
        return txtHabitat1;
    }

    public void setTxtHabitat1(JTextField txtHabitat1) {
        this.txtHabitat1 = txtHabitat1;
    }

    public JTextField getTxtUrlConexion1() {
        return txtUrlConexion1;
    }

    public void setTxtUrlConexion1(JTextField txtUrlConexion1) {
        this.txtUrlConexion1 = txtUrlConexion1;
    }

    public void clean() {
        // Limpia los campos de texto del panel 1
        txtEspecie.setText("");
        txtAlimentacion.setText("");
        txtEsperanzaVida.setText("");
        txtHabitat.setText("");
        txtUrlConexion.setText("");
    }
}
