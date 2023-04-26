package pl.milenamrugala.personalfinancemanager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/personal-finance-manager")
public class HomeController {

    @GetMapping("/")

    public String welcomePage() {

        return "welcome-page";
    }

    @GetMapping("/login-error")
    public String loginError() {
        return "login-error";
    }

}
