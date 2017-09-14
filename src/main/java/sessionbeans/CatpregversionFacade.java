/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Catpregversion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
