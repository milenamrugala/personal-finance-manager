package pl.milenamrugala.personalfinancemanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.milenamrugala.personalfinancemanager.entity.Transaction;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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

    @Override
    public Transaction findByUserIdAndId(Long userId, Long transactionId) {
        Query query = entityManager.createQuery("SELECT t FROM Transaction t WHERE t.user.id = :userId AND t.id = :transactionId");
        query.setParameter("userId", userId);
        query.setParameter("transactionId", transactionId);
        return (Transaction) query.getSingleResult();
    }

    @Override
    public List<Transaction> findByUserId(Long userId) {
        Query query = entityManager.createQuery("SELECT t FROM Transaction t WHERE t.user.id = :userId");
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Transaction> findAllByUserId(Long userId) {
        TypedQuery<Transaction> theQuery =
                entityManager.createQuery("from Transaction where user_id = :userId", Transaction.class);
        theQuery.setParameter("userId", userId);

        List<Transaction> transactions = theQuery.getResultList();
        return transactions;
    }


}
