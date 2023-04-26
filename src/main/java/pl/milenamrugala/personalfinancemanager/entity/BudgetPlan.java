package pl.milenamrugala.personalfinancemanager.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "budget_plans")
public class BudgetPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String description;
    private String name;
    private Date start_date;
    private Date end_date;
    private double amount;

    @OneToMany(mappedBy = "budgetPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;

    public List<Transaction> getTransactionsByType(TransactionType type) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getType() == type) {
                result.add(transaction);
            }
        }
        return result;
    }

    public void addTransaction(Transaction transaction) {

        transactions.add(transaction);
    }
}
