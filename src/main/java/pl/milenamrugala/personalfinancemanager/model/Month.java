package pl.milenamrugala.personalfinancemanager.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "months")

public class Month {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private int displayOrder;

    @OneToMany(mappedBy = "month", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BudgetPlan> budgetPlans;

}
