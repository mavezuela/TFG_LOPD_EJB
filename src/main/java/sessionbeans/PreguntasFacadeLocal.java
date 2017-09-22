/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Catpreguntas;
import entities.Preguntas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface PreguntasFacadeLocal {

    void create(Preguntas preguntas);

    void edit(Preguntas preguntas);

    void remove(Preguntas preguntas);

    Preguntas find(Object id);

    List<Preguntas> findAll();

    List<Preguntas> findRange(int[] range);
    
    List<Preguntas> findByIdcatpreguntas(Catpreguntas catpreguntas);

    int count();
    
}
