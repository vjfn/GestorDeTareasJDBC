package org.example.ui;

import org.example.domain.Database;
import org.example.domain.Tarea;
import org.example.domain.TareaAdapter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Ventana extends JFrame {
    private JPanel panel1;
    private JLabel info;
    private JTable table1;

    DefaultTableModel data;

    public Ventana(){
        this.setContentPane(panel1);
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Acceso con JDBC");

        table1.setRowHeight(40);
        data = (DefaultTableModel) table1.getModel();
        data.addColumn("id");
        data.addColumn("tarea");
        data.addColumn("prioridad");
        data.addColumn("usuario");
        data.addColumn("categoria");
        data.addColumn("descripción");

        //var datos = Database.getAll();

        //datos.forEach( (e)-> data.addRow(e) );
        //table1.doLayout();
        //

        var tareas = Database.getAllTarea();
        fillTable(tareas);

    }

    private void fillTable(ArrayList<Tarea> tareas) {
        data.setRowCount(0);
        tareas.forEach( (t)->{
            data.addRow( new TareaAdapter(t).toArrayString() ) ;
        });
        info.setText("Datos cargados correctamente");
    }

    public void load(){
        setVisible(true);
    }
}
