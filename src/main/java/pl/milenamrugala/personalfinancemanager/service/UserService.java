package pl.milenamrugala.personalfinancemanager.service;
import pl.milenamrugala.personalfinancemanager.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User save(User user);

    void deleteById(Long id);

}

