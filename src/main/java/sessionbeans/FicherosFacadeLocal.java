/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Departamento;
import entities.Ficheros;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface FicherosFacadeLocal {

    void create(Ficheros ficheros);

    void edit(Ficheros ficheros);

    void remove(Ficheros ficheros);

    Ficheros find(Object id);

    List<Ficheros> findAll();

    List<Ficheros> findRange(int[] range);
    
    List<Ficheros> findByIddepartamento(Departamento departamento);

    int count();
    
}
