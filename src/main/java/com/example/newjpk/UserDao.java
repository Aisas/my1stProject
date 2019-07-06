package com.example.newjpk;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("userDao")
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public User selectUserById(long IdUser) {
        return entityManager.find(User.class, IdUser);
    }

    public void insertUser(User user) {
        entityManager.persist(user);
    }

    public void updateUser(User user) {

        User userToUpdate = selectUserById(user.getIdUser());
        userToUpdate.setTaxPayer(user.getTaxPayer());
        userToUpdate.setLogin(user.getLogin());
        userToUpdate.setEmail(user.getPassword());
        userToUpdate.setPassword(user.getPassword());
        entityManager.flush();
    }

    public void deleteUser(long userId) {
        entityManager.remove(selectUserById(userId));
    }

    public List<User> selectAllUser() {
        Query query = entityManager.createQuery("from User as usr order by IdUser");

        return (List<User>) query.getResultList();
    }
}
