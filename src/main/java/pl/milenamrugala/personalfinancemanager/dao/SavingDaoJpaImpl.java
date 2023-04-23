package pl.milenamrugala.personalfinancemanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.milenamrugala.personalfinancemanager.entity.Saving;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SavingDaoJpaImpl implements SavingDao {

    private EntityManager entityManager;

    @Autowired // constructor injection
    public SavingDaoJpaImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    public List<Saving> findAll() {
        TypedQuery<Saving> theQuery =
                entityManager.createQuery("from Saving", Saving.class);

        List<Saving> savings = theQuery.getResultList();
        return savings;
    }

    @Override
    public Saving findById(Long id) {
        Saving saving = entityManager.find(Saving.class, id);
        return saving;
    }

    @Override // if id == 0 then insert/save else update
    public Saving save(Saving saving) {
        Saving dbSaving = entityManager.merge(saving);
        return dbSaving;
    }

    @Override
    public void deleteById(Long id) {

        Saving saving = entityManager.find(Saving.class, id);
        entityManager.remove(saving);

    }
}
