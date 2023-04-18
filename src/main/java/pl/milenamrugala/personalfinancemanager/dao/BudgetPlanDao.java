package pl.milenamrugala.personalfinancemanager.dao;
import pl.milenamrugala.personalfinancemanager.entity.BudgetPlan;

import java.util.List;

public interface BudgetPlanDao {

    List<BudgetPlan> findAll();

    BudgetPlan findById(Long id);

    BudgetPlan save(BudgetPlan budgetPlan);

    void deleteById(Long id);
}
