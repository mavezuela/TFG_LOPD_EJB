/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Expiration;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface ExpirationFacadeLocal {

    void create(Expiration expiration);

    void edit(Expiration expiration);

    void remove(Expiration expiration);

    Expiration find(Object id);

    List<Expiration> findAll();

    List<Expiration> findRange(int[] range);

    int count();
    
}
