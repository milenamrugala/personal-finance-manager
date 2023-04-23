package pl.milenamrugala.personalfinancemanager.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.milenamrugala.personalfinancemanager.entity.Transaction;
import pl.milenamrugala.personalfinancemanager.entity.TransactionType;
import pl.milenamrugala.personalfinancemanager.service.TransactionService;

import java.util.List;


@Controller
@RequestMapping(value = "/personal-finance-manager")

public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/new-transaction")
    public String transactionForm(Model model) {
        Transaction transaction = new Transaction();
        model.addAttribute(("transaction"), new Transaction());
        return "new-transaction";
    }

    @PostMapping("/new-transaction")
    public String transactionSave(@ModelAttribute("transaction") Transaction transaction) {
    transactionService.save(transaction);
    return "redirect:/personal-finance-manager/list-transactions";
    }

    @GetMapping("/list-transactions")
    public String listTransactions(Model model) {
        List<Transaction> transactions = transactionService.findAll();
        model.addAttribute("transactions", transactions);
        return "list-transactions";
    }

    @GetMapping("/list-transactions/update")
    public String updateTransaction(@RequestParam("id") Long id, Model model) {

        Transaction transaction = transactionService.findById(id);
        model.addAttribute("transaction", transaction);
        return "list-transactions-update";
    }

    @PostMapping("/list-transactions/update")
    public String saveTransaction(@ModelAttribute("transaction") Transaction transaction) {
        transactionService.save(transaction);

        return "redirect:/personal-finance-manager/list-transactions";

    }

    @GetMapping("/list-transactions/delete")
    public String deleteTransaction(@RequestParam("id") Long id) {
        transactionService.deleteById(id);
        return "redirect:/personal-finance-manager/list-transactions";
    }

    @GetMapping("/list-transactions/delete-confirm")
    public String confirmDeleteTransaction(@RequestParam("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "transaction-delete-confirm";
    }

    @GetMapping("/transactions-summary")
    public String getSummary(Model model) {
        // Retrieve all transactions from the database
        List<Transaction> transactions = transactionService.findAll();

        // Calculate the total income and total expenses
        double totalIncome = 0.0;
        double totalExpense = 0.0;
        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.INCOME) {
                totalIncome += transaction.getAmount();
            } else {
                totalExpense += transaction.getAmount();
            }
        }

        // Calculate the balance by subtracting the total expenses from the total incomes
        double balance = totalIncome - totalExpense;

        // Add the summary information to the model
        model.addAttribute("totalIncome", totalIncome);
        model.addAttribute("totalExpense", totalExpense);
        model.addAttribute("balance", balance);
        model.addAttribute("numIncomeTransactions", transactions.stream().filter(t -> t.getType() == TransactionType.INCOME).count());
        model.addAttribute("numExpenseTransactions", transactions.stream().filter(t -> t.getType() == TransactionType.EXPENSE).count());

        // Return the name of the JSP file to be rendered by the view resolver
        return "transactions-summary";
    }

}
