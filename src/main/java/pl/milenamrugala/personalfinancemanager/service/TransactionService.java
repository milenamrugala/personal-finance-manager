package pl.milenamrugala.personalfinancemanager.service;
import pl.milenamrugala.personalfinancemanager.entity.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> findAll();

    Transaction findById(Long id);

    Transaction save(Transaction transaction);

    void deleteById(Long id);

}
