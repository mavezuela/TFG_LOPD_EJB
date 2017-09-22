/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Departamento;
import entities.Ficheros;
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
public class FicherosFacade extends AbstractFacade<Ficheros> implements FicherosFacadeLocal {

    @PersistenceContext(unitName = "com_TFG-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FicherosFacade() {
        super(Ficheros.class);
    }
    
    @Override
    public List<Ficheros> findByIddepartamento(Departamento departamento) {
        Query query = em.createQuery("SELECT f FROM Ficheros f WHERE f.iddepartamento = ?1");
        query.setParameter(1, departamento);
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        return results;
    }    
    
    
}
