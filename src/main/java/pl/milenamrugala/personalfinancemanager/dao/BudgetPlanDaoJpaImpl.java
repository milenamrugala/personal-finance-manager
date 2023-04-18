package pl.milenamrugala.personalfinancemanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.milenamrugala.personalfinancemanager.entity.BudgetPlan;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BudgetPlanDaoJpaImpl implements BudgetPlanDao {

    private EntityManager entityManager;

    @Autowired // constructor injection
    public BudgetPlanDaoJpaImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    public List<BudgetPlan> findAll() {
        TypedQuery<BudgetPlan> theQuery =
                entityManager.createQuery("from BudgetPlan", BudgetPlan.class);

        List<BudgetPlan> budgetPlans = theQuery.getResultList();
        return budgetPlans;
    }

    @Override
    public BudgetPlan findById(Long id) {
        BudgetPlan budgetPlan = entityManager.find(BudgetPlan.class, id);
        return budgetPlan;
    }

    @Override // if id == 0 then insert/save else update
    public BudgetPlan save(BudgetPlan budgetPlan) {
        BudgetPlan dbBudgetPlan = entityManager.merge(budgetPlan);
        return dbBudgetPlan;
    }

    @Override
    public void deleteById(Long id) {

        BudgetPlan budgetPlan = entityManager.find(BudgetPlan.class, id);
        entityManager.remove(budgetPlan);

    }
}
