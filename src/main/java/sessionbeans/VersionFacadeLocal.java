/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Version;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface VersionFacadeLocal {

    void create(Version version);

    void edit(Version version);

    void remove(Version version);

    Version find(Object id);

    List<Version> findAll();

    List<Version> findRange(int[] range);

    int count();
    
}
