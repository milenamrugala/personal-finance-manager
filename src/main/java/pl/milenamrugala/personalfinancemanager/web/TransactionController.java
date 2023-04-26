package pl.milenamrugala.personalfinancemanager.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.milenamrugala.personalfinancemanager.entity.Transaction;
import pl.milenamrugala.personalfinancemanager.entity.TransactionType;

import pl.milenamrugala.personalfinancemanager.service.TransactionService;
import pl.milenamrugala.personalfinancemanager.service.UserService;

import java.util.List;


@Controller
@RequestMapping(value = "/personal-finance-manager")

public class TransactionController {

    private TransactionService transactionService;
    // private UserService userService;

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

        List<Transaction> transactions = transactionService.findAll();


        double totalIncome = 0.0;
        double totalExpense = 0.0;
        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.INCOME) {
                totalIncome += transaction.getAmount();
            } else {
                totalExpense += transaction.getAmount();
            }
        }


        double balance = totalIncome - totalExpense;


        model.addAttribute("totalIncome", totalIncome);
        model.addAttribute("totalExpense", totalExpense);
        model.addAttribute("balance", balance);
        model.addAttribute("numIncomeTransactions", transactions.stream().filter(t -> t.getType() == TransactionType.INCOME).count());
        model.addAttribute("numExpenseTransactions", transactions.stream().filter(t -> t.getType() == TransactionType.EXPENSE).count());


        return "transactions-summary";
    }


    /*
    // working session
    @GetMapping("/new-transaction")
    public String transactionForm(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            // redirect to login page
            return "redirect:/personal-finance-manager/login";
        }
        User user = userService.findById(userId); // retrieve user from service
        Transaction transaction = new Transaction();
        transaction.setUser(user);
        model.addAttribute("transaction", transaction);
        session.setAttribute("transaction", transaction);
        return "new-transaction";
    }

    // working session
    @PostMapping("/new-transaction")
    public String transactionSave(@ModelAttribute("transaction") Transaction transaction, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId"); // retrieve logged in userId from session
        User user = userService.findById(userId); // retrieve user object from database using id

        transaction.setUser(user); // associate the transaction with the logged-in user
        transactionService.save(transaction);

        session.removeAttribute("transaction");
        return "redirect:/personal-finance-manager/list-transactions";
    }*/

/*   // working session
    @GetMapping("/list-transactions")
    public String listTransactions(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        List<Transaction> transactions = transactionService.findAllByUserId(userId);
        model.addAttribute("transactions", transactions);
        return "list-transactions";
    }*/

    // working session
/*    @GetMapping("/list-transactions/update")
    public String updateTransaction(@RequestParam("id") Long id, Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId"); // retrieve logged-in user id from session

        Transaction transaction = transactionService.findById(id);

        // only allow users to update their own transactions
        if (transaction.getUser().getId().equals(userId)) {
            model.addAttribute("transaction", transaction);
            return "list-transactions-update";
        }

        // if user does not own the transaction, redirect him back to the list
        return "redirect:/personal-finance-manager/list-transactions";
    }

    @PostMapping("/list-transactions/update")
    public String saveTransaction(@ModelAttribute("transaction") Transaction transaction, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId"); // retrieve logged-in user id from session

        User user = transaction.getUser(); // retrieve user associated with the transaction

        // check that user is not null and has a valid id
        if (user != null && user.getId() != null && user.getId().equals(userId)) {
            transactionService.save(transaction);
            return "redirect:/personal-finance-manager/list-transactions";
        }

        // if user does not own the transaction, redirect them back to the list
        return "redirect:/personal-finance-manager/list-transactions";
    }*/

    // working session
    /*@GetMapping("/transactions-summary")
    public String getSummary(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId"); // retrieve logged-in user id from session
        List<Transaction> transactions = transactionService.findByUserId(userId);

        double totalIncome = 0.0;
        double totalExpense = 0.0;
        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.INCOME) {
                totalIncome += transaction.getAmount();
            } else {
                totalExpense += transaction.getAmount();
            }
        }

        double balance = totalIncome - totalExpense;

        model.addAttribute("totalIncome", totalIncome);
        model.addAttribute("totalExpense", totalExpense);
        model.addAttribute("balance", balance);
        model.addAttribute("numIncomeTransactions", transactions.stream().filter(t -> t.getType() == TransactionType.INCOME).count());
        model.addAttribute("numExpenseTransactions", transactions.stream().filter(t -> t.getType() == TransactionType.EXPENSE).count());

        return "transactions-summary";
    }*/


}