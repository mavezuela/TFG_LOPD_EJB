/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Catpregversion;
import entities.Version;
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
public class CatpregversionFacade extends AbstractFacade<Catpregversion> implements CatpregversionFacadeLocal {

    @PersistenceContext(unitName = "com_TFG-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatpregversionFacade() {
        super(Catpregversion.class);
    }

    @Override
    public List<Catpregversion> findByIdcatpreguntas(Integer idcatpreguntas) {
        Query query = em.createQuery("SELECT c FROM Catpregversion c WHERE c.idcatpreguntas = ?1");
        query.setParameter(1, idcatpreguntas);
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        return  results;
    }
    
    @Override
    public List<Catpregversion> findByIdversion(Version version) {
        Query query = em.createQuery("SELECT c FROM Catpregversion c WHERE c.idversion = ?1");
        query.setParameter(1, version);
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        return  results;
    }    
}
