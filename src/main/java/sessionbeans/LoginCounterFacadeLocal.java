/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.LoginCounter;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface LoginCounterFacadeLocal {

    void create(LoginCounter loginCounter);

    void edit(LoginCounter loginCounter);

    void remove(LoginCounter loginCounter);

    LoginCounter find(Object id);

    List<LoginCounter> findAll();

    List<LoginCounter> findRange(int[] range);

    int count();
    
}
