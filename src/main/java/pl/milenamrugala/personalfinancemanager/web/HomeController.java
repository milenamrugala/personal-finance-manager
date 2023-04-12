package pl.milenamrugala.personalfinancemanager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/personal-finance-manager")
public class HomeController {

    @GetMapping("/registration")

    public String register() {
        return "registration";
    }

    @GetMapping("/login")

    public String login() {
        return "login";
    }

    @GetMapping("/homepage")

    public String homepage() {
        return "homepage";

    }

    @GetMapping("/new-expense-type")

    public String newExpenseCategory() {
        return "new-expense-type";

    }

    @GetMapping("/new-income-type")

    public String newIncomeCategory() {

        return "new-income-type";
    }
}
