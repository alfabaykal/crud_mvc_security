package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Role getRoleById(Long id) {
        return em.createQuery("select u from Role u where u.id = :id", Role.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Role getRoleByName(String name) {
        return em.createQuery("select u from Role u where u.name = :name", Role.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
