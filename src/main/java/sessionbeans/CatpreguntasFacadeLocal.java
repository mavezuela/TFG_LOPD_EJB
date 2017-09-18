/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Catpreguntas;
import entities.Catpregversion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface CatpreguntasFacadeLocal {

    void create(Catpreguntas catpreguntas);

    void edit(Catpreguntas catpreguntas);

    void remove(Catpreguntas catpreguntas);

    Catpreguntas find(Object id);

    List<Catpreguntas> findAll();

    List<Catpreguntas> findRange(int[] range);

    int count();
    
}
