package pl.milenamrugala.personalfinancemanager.dao;

import pl.milenamrugala.personalfinancemanager.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findById(Long id);

    User save(User user);

    void deleteById(Long id);

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

}
