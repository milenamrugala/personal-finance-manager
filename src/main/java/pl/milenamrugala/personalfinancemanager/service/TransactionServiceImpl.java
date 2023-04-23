package pl.milenamrugala.personalfinancemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.milenamrugala.personalfinancemanager.dao.TransactionDao;
import pl.milenamrugala.personalfinancemanager.entity.Transaction;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {


    private TransactionDao transactionDao;

    @Autowired
    public TransactionServiceImpl(TransactionDao transactionDao) {

        this.transactionDao = transactionDao;
    }

    @Override
    public List<Transaction> findAll() {

        return transactionDao.findAll();
    }

    @Override
    public Transaction findById(Long id) {
        return transactionDao.findById(id);
    }

    @Transactional
    @Override
    public Transaction save(Transaction transaction) {

        return transactionDao.save(transaction);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        transactionDao.deleteById(id);

    }

}
