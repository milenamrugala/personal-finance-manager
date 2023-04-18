package pl.milenamrugala.personalfinancemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.milenamrugala.personalfinancemanager.dao.BudgetPlanDao;
import pl.milenamrugala.personalfinancemanager.entity.BudgetPlan;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BudgetPlanServiceImpl implements BudgetPlanService {

    private BudgetPlanDao budgetPlanDao;

    @Autowired
    public BudgetPlanServiceImpl(BudgetPlanDao budgetPlanDao) {
        this.budgetPlanDao = budgetPlanDao;
    }

    @Override
    public List<BudgetPlan> findAll() {

        return budgetPlanDao.findAll();
    }

    @Override
    public BudgetPlan findById(Long id) {
        return budgetPlanDao.findById(id);
    }

    @Transactional
    @Override
    public BudgetPlan save(BudgetPlan budgetPlan) {

        return budgetPlanDao.save(budgetPlan);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        budgetPlanDao.deleteById(id);

    }
}
