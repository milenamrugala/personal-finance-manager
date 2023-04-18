package pl.milenamrugala.personalfinancemanager.service;
import pl.milenamrugala.personalfinancemanager.entity.BudgetPlan;

import java.util.List;

public interface BudgetPlanService {

    List<BudgetPlan> findAll();

    BudgetPlan findById(Long id);

    BudgetPlan save(BudgetPlan transaction);

    void deleteById(Long id);
}
