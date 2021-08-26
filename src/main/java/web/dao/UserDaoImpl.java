package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public List<User> getAllUser() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public User getUser(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void updateUser(int id, User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        em.remove(getUser(id));
    }

    @Override
    public User findByUsername(String username) {
        return (User) em.createQuery("select u from User u where u.name = :name")
                .setParameter("name", username).getSingleResult();
    }

    @Override
    public User getUser(String username) {

        return em.createQuery("FROM User where username=:username", User.class)
                .setParameter("username", username)
                .getSingleResult();

    }
}