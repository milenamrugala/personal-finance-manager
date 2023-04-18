package pl.milenamrugala.personalfinancemanager.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.milenamrugala.personalfinancemanager.entity.BudgetPlan;
import pl.milenamrugala.personalfinancemanager.service.BudgetPlanService;
import pl.milenamrugala.personalfinancemanager.service.TransactionService;


@Controller
@RequestMapping(value = "/personal-finance-manager")

public class BudgetPlanController {

    private final TransactionService transactionService;
    private final BudgetPlanService budgetPlanService;

    public BudgetPlanController(TransactionService transactionService, BudgetPlanService budgetPlanService) {
        this.transactionService = transactionService;
        this.budgetPlanService = budgetPlanService;
    }

    @GetMapping("/new-budget-plan")
    public String budgetPlanForm(Model model) {
        model.addAttribute("transactions", transactionService.findAll());
        model.addAttribute("budgetPlan", new BudgetPlan());
        return "new-budget-plan";
    }

    @PostMapping("/new-budget-plan")
    public String budgetPlanSave(BudgetPlan budgetPlan, BindingResult result, Model model) {
        model.addAttribute("transactions", transactionService.findAll());
        budgetPlanService.save(budgetPlan);
        return "redirect:/personal-finance-manager/list-budget-plans";
    }

}
