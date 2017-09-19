/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Catpreguntas;
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
public class CatpreguntasFacade extends AbstractFacade<Catpreguntas> implements CatpreguntasFacadeLocal {

    @PersistenceContext(unitName = "com_TFG-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatpreguntasFacade() {
        super(Catpreguntas.class);
    }

    @Override
    public List<Catpreguntas> findByIdcatpreguntas(Integer idcatpreguntas) {
        Query query = em.createQuery("SELECT c FROM Catpreguntas c WHERE c.idcatpreguntas = ?1");
        query.setParameter(1, idcatpreguntas);
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        return results;
    }

}
