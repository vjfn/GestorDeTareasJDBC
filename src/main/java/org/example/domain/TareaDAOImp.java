package org.example.domain;

import java.sql.*;
import java.util.ArrayList;


public class TareaDAOImp implements TareaDAO {

    private Connection connection;

    private final static String queryLoadAll = "SELECT * FROM tarea";
    private final static String querryUpdate = "";
    private final static String querryDelete = "";
    private final static String querrySave = "";
    private final static String queryLoadAllByResponsable = "SELECT * FROM tarea WHERE usuario_id=?";

    public TareaDAOImp(Connection c){
        connection = c;
    }


    @Override
    public Tarea load(Long id) {
        return null;
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
