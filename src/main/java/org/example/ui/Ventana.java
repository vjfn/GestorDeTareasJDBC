package org.example.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Ventana extends JFrame{
    private JPanel panel1;
    private JTable table1;
    private JLabel info;

    DefaultTableModel data;

    public Ventana() {

        this.setContentPane(panel1);
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Acceso con JDBC");

        data = (DefaultTableModel) table1.getModel();
        data.addColumn("id");
        data.addColumn("tarea");
        data.addColumn("prioridad");
        data.addColumn("usuario_id");
        data.addColumn("categoria");
        data.addColumn("descripcion");

        var datos = Database.getAll();

        datos.forEach( (e) -> data.addRow(e) );

    }

    public void load(){
        setVisible(true);
    }

}
