package org.example.domain.usuario;

import java.util.ArrayList;

public interface UsuarioDAO {
    public Usuario load(Long id);
    public ArrayList<Usuario> loadAll();
    public ArrayList<Usuario> loadAllByResponsable(Long responsable);
    public Usuario save(Usuario t);
    public Usuario update(Usuario t);
    public Usuario update(Long id,Usuario t);
    public void remove(Usuario t);
}
