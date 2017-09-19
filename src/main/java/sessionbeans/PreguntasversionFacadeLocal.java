/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Catpregversion;
import entities.Preguntasversion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface PreguntasversionFacadeLocal {

    void create(Preguntasversion preguntasversion);

    void edit(Preguntasversion preguntasversion);

    void remove(Preguntasversion preguntasversion);

    Preguntasversion find(Object id);

    List<Preguntasversion> findAll();

    List<Preguntasversion> findRange(int[] range);
    
    List<Preguntasversion> findByIdcatpregversion(Catpregversion catpregversion);

    int count();
    
}
