/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.NivelAcceso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface NivelAccesoFacadeLocal {

    void create(NivelAcceso nivelAcceso);

    void edit(NivelAcceso nivelAcceso);

    void remove(NivelAcceso nivelAcceso);

    NivelAcceso find(Object id);

    List<NivelAcceso> findAll();

    List<NivelAcceso> findRange(int[] range);

    int count();
    
}
