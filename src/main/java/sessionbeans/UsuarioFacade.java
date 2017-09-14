/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "com_TFG-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario findByName(String username) {
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.username = ?1");
        query.setParameter(1, username);
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        return (Usuario) results.get(0);
    }
//    @Override
//    public Usuario findByName(String userName) {
//        try {
//            return (Usuario) em.createNamedQuery("findByUsername", Usuario.class).setParameter("username", userName).getResultList().get(0);
//        } catch (IndexOutOfBoundsException e) {
//            return null;
//        }
//    }

}
