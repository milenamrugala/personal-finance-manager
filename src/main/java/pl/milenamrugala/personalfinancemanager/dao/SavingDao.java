package pl.milenamrugala.personalfinancemanager.dao;

import pl.milenamrugala.personalfinancemanager.entity.Saving;


import java.util.List;

public interface SavingDao {

    List<Saving> findAll();

    Saving findById(Long id);

    Saving save(Saving saving);

    void deleteById(Long id);
}
