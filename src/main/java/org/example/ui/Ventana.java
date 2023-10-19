package org.example.ui;

import org.example.domain.*;
import org.example.domain.Tarea.Tarea;
import org.example.domain.Tarea.TareaAdapter;
import org.example.domain.Tarea.TareaDAOImp;
import org.example.domain.usuario.Usuario;
import org.example.domain.usuario.UsuarioDAOImp;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Ventana extends JFrame {
    private final TareaDAOImp daoTarea = new TareaDAOImp(DBConnection.getConnection());
    private JPanel panel1;
    private JLabel info;
    private JTable table1;
    private JPanel panel;
    private JButton button1;

    DefaultTableModel data;

    ArrayList<Tarea> tareas = new ArrayList<>();

    public Ventana(){
        this.setContentPane(panel);
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

//      var tareas = Database.getAllTarea();
        tareas = daoTarea.loadAll();

        fillTable(tareas);

        table1.getSelectionModel().addListSelectionListener ( ev ->showDetails(ev) );

        button1.addActionListener(e -> {
            Tarea t = new Tarea();
            Usuario u = (new UsuarioDAOImp(DBConnection.getConnection())).load(1L);
            t.setUsuario(u);
            t.setUsuario_id(u.getId());
            t.setCategoria("categoria");
            t.setDescripcion("descripcion");
            t.setTitulo("titulo");
            t.setPrioridad("ALTA");
            t = daoTarea.save(t);

            tareas = daoTarea.loadAll();
            fillTable(tareas);

        });
//        table1.addPropertyChangeListener(evt -> {
//
//        });
    }

//    private Object showDetails(ListSelectionEvent ev) {
//        if (!ev.getValueIsAdjusting()){
//            Tarea selected = tareas.get(table1.getSelectedRow());
//            info.setText(selected.toString());
//        }
//    }

    private void showDetails(ListSelectionEvent ev) {
        if (!ev.getValueIsAdjusting()){
            Tarea selected = tareas.get(table1.getSelectedRow());
            info.setText(selected.toString());
        }
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

