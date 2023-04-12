package pl.milenamrugala.personalfinancemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = "pl.milenamrugala.personalfinancemanager")

public class PersonalFinanceManagerApplication {

    public static void main(String[] args) {

        SpringApplication.run(PersonalFinanceManagerApplication.class, args);
    }

}
