/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Versionfichero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface VersionficheroFacadeLocal {

    void create(Versionfichero versionfichero);

    void edit(Versionfichero versionfichero);

    void remove(Versionfichero versionfichero);

    Versionfichero find(Object id);

    List<Versionfichero> findAll();

    List<Versionfichero> findRange(int[] range);

    int count();
    
}
