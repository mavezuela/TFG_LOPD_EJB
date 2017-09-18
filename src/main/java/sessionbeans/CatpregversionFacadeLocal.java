/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Catpregversion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface CatpregversionFacadeLocal {

    void create(Catpregversion catpregversion);

    void edit(Catpregversion catpregversion);

    void remove(Catpregversion catpregversion);

    Catpregversion find(Object id);
          
    List<Catpregversion> findByIdcatpreguntas(Integer idcatpreguntas);

    List<Catpregversion> findAll();

    List<Catpregversion> findRange(int[] range);

    int count();
    
}
