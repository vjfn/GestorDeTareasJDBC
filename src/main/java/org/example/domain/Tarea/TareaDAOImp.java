package org.example.domain.Tarea;

import org.example.domain.usuario.UsuarioDAOImp;

import java.sql.*;
import java.util.ArrayList;


public class TareaDAOImp implements TareaDAO {

    private Connection connection;



    private final static String queryLoadAll = "SELECT * FROM tarea";
    private final static String queryLoad = "select * from tarea where id";
    private final static String querryUpdate = "";
    private final static String querryDelete = "";
    private final static String querrySave = "";
    private final static String queryLoadAllByResponsable = "SELECT * FROM tarea WHERE usuario_id=?";

    public TareaDAOImp(Connection c){
        connection = c;
    }


    @Override
    public Tarea load(Long id) {
        var salida = new Tarea();
        try (var pst = connection.prepareStatement(queryLoad)) {
            pst.setLong(1, id);
            var rs = pst.executeQuery();
            if (rs.next()) {
//                salida = (new TareaAdapter()).loadFromResultSet(rs);
//                La línea de arriba hace lo de abajo
                salida = new Tarea();
                salida.setId(rs.getLong("id"));
                salida.setTitulo(rs.getString("titulo"));
                salida.setPrioridad(rs.getString("prioridad"));
                salida.setUsuario_id(rs.getLong("usuario_id"));
                salida.setCategoria(rs.getString("categoria"));
                salida.setDescripcion(rs.getString("descripcion"));
//                salida.setUsuario( daoUsuario.cargarUsuario(rs.getLong("usuario_id")) );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salida;
    }

    @Override
    public ArrayList<Tarea> loadAll() {
        var salida = new ArrayList<Tarea>();

        try(Statement st= connection.createStatement()){
            ResultSet rs = st.executeQuery(queryLoadAll);

            while(rs.next()){
                salida.add( (new TareaAdapter()).loadFromResultSet(rs) );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return salida;
    }

    @Override
    public ArrayList<Tarea> loadAllByResponsable(Long responsable) {

        var salida = new ArrayList<Tarea>();
        try (PreparedStatement pst = connection.prepareStatement(queryLoadAllByResponsable)){
            pst.setLong(1,responsable);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                salida.add((new TareaAdapter()).loadFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return salida;

    }

    @Override
    public Tarea save(Tarea t) {
        return null;
    }

    @Override
    public Tarea update(Tarea t) {
        return null;
    }

    @Override
    public Tarea update(Long id, Tarea t) {
        return null;
    }

    @Override
    public void remove(Tarea t) {

    }
}
