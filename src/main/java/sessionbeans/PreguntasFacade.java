/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Catpreguntas;
import entities.Preguntas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author usuario
 */
@Stateless
public class PreguntasFacade extends AbstractFacade<Preguntas> implements PreguntasFacadeLocal {

    @PersistenceContext(unitName = "com_TFG-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreguntasFacade() {
        super(Preguntas.class);
    }

    @Override
    public List<Preguntas> findByIdcatpreguntas(Catpreguntas catpreguntas) {
        Query query = em.createQuery("SELECT p FROM Preguntas p WHERE p.idcatpreguntas = ?1");
        query.setParameter(1, catpreguntas);
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        return  results;
    }          
}
