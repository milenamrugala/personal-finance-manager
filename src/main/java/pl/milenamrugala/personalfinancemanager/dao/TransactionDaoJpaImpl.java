package pl.milenamrugala.personalfinancemanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.milenamrugala.personalfinancemanager.entity.Transaction;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class TransactionDaoJpaImpl implements TransactionDao {

    private EntityManager entityManager;

    @Autowired // constructor injection
    public TransactionDaoJpaImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    public List<Transaction> findAll() {
        TypedQuery<Transaction> theQuery =
                entityManager.createQuery("from Transaction ", Transaction.class);

        List<Transaction> transactions = theQuery.getResultList();
        return transactions;
    }

    @Override
    public Transaction findById(Long id) {
        Transaction transaction = entityManager.find(Transaction.class, id);
        return transaction;
    }

    @Override // if id == 0 then insert/save else update
    public Transaction save(Transaction transaction) {
        Transaction dbTransaction = entityManager.merge(transaction);
        return dbTransaction;
    }

    @Override
    public void deleteById(Long id) {

        Transaction transaction = entityManager.find(Transaction.class, id);
        entityManager.remove(transaction);

    }
}
