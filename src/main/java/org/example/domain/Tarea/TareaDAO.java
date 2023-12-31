package org.example.domain.Tarea;

import java.util.ArrayList;

public interface TareaDAO {

    public Tarea load(Long id);
    public ArrayList<Tarea> loadAll();
    public ArrayList<Tarea> loadAllByResponsable(Long responsable);
    public Tarea save(Tarea t);
    public Tarea update(Tarea t);
    public Tarea update(Long id,Tarea t);
    public void remove(Tarea t);





}
