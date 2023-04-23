package pl.milenamrugala.personalfinancemanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.milenamrugala.personalfinancemanager.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoJpaImpl implements UserDao {

    private EntityManager entityManager;

    @Autowired // constructor injection
    public UserDaoJpaImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> theQuery =
                entityManager.createQuery("from User", User.class);

        List<User> users = theQuery.getResultList();
        return users;
    }

    @Override
    public User findById(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override // if id == 0 then insert/save else update
    public User save(User user) {
        User dbUser = entityManager.merge(user);
        return dbUser;
    }

    @Override
    public void deleteById(Long id) {

        User user = entityManager.find(User.class, id);
        entityManager.remove(user);

    }

    @Override
    public User findByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        List<User> users = query.getResultList();
        return users.isEmpty() ? null : users.get(0);
    }

    public User findByEmailAndPassword(String email, String password) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.email = :email AND u.password = :password", User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<User> users = query.getResultList();
        return users.isEmpty() ? null : users.get(0);
    }



}
