package pl.milenamrugala.personalfinancemanager.service;

import pl.milenamrugala.personalfinancemanager.entity.Saving;

import java.util.List;

public interface SavingService {

    List<Saving> findAll();

    Saving findById(Long id);

    Saving save(Saving saving);

    void deleteById(Long id);

}
