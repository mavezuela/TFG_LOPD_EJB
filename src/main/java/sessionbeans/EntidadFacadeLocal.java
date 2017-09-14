/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Entidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface EntidadFacadeLocal {

    void create(Entidad entidad);

    void edit(Entidad entidad);

    void remove(Entidad entidad);

    Entidad find(Object id);

    List<Entidad> findAll();

    List<Entidad> findRange(int[] range);

    int count();
    
}
