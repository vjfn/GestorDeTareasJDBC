package org.example.domain.usuario;

import lombok.extern.java.Log;
import org.example.domain.usuario.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
@Log
public class UsuarioDAOImp implements UsuarioDAO {

    private Connection connection;
    private static final String QUERY_LOAD = "select * from usuario where id=?";
    public UsuarioDAOImp(Connection conn){
        connection = conn;
    }


    @Override
    public Usuario load(Long id) {
        var salida = new Usuario();
        try (var pst = connection.prepareStatement(QUERY_LOAD)) {
            log.info(QUERY_LOAD);
            log.info(id.toString());
            pst.setLong(1, id);
            var rs = pst.executeQuery();
            if (rs.next()) {
//                salida = (new TareaAdapter()).loadFromResultSet(rs);
//                La línea de arriba hace lo de abajo
                salida = new Usuario();
                salida.setId(rs.getLong("id"));
                salida.setNombre(rs.getString("mombre"));
                salida.setEmail(rs.getString("email"));
//                salida.setUsuario( daoUsuario.cargarUsuario(rs.getLong("usuario_id")) );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        log.info(salida.toString());
        return salida;
    }

    @Override
    public ArrayList<Usuario> loadAll() {
        return null;
    }

    @Override
    public ArrayList<Usuario> loadAllByResponsable(Long responsable) {
        return null;
    }

    @Override
    public Usuario save(Usuario t) {
        return null;
    }

    @Override
    public Usuario update(Usuario t) {
        return null;
    }

    @Override
    public Usuario update(Long id, Usuario t) {
        return null;
    }

    @Override
    public void remove(Usuario t) {

    }
}
