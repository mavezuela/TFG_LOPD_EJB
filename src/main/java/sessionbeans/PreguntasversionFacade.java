/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Catpregversion;
import entities.Preguntasversion;
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
public class PreguntasversionFacade extends AbstractFacade<Preguntasversion> implements PreguntasversionFacadeLocal {

    @PersistenceContext(unitName = "com_TFG-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreguntasversionFacade() {
        super(Preguntasversion.class);
    }
 
    @Override
    public List<Preguntasversion> findByIdcatpregversion(Catpregversion catpregversion) {
        Query query = em.createQuery("SELECT c FROM Preguntasversion c WHERE c.idcatpregversion = ?1");
        query.setParameter(1, catpregversion);
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        return  results;
    }       
}
