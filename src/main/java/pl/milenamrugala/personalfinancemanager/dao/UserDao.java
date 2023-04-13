package pl.milenamrugala.personalfinancemanager.dao;

import org.springframework.data.jpa.repository.Query;
import pl.milenamrugala.personalfinancemanager.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findById(Long id);

    User save(User user);

    void deleteById(Long id);

}
