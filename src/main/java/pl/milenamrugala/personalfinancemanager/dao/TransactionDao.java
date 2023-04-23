package pl.milenamrugala.personalfinancemanager.dao;

import pl.milenamrugala.personalfinancemanager.entity.Transaction;

import java.util.List;

public interface TransactionDao {

    List<Transaction> findAll();

    Transaction findById(Long id);

    Transaction save(Transaction transaction);

    void deleteById(Long id);




}

