package pl.milenamrugala.personalfinancemanager.web;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.milenamrugala.personalfinancemanager.entity.User;
import pl.milenamrugala.personalfinancemanager.service.UserService;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/personal-finance-manager")

public class LoginController {

    private UserService userService;

    String hashPassword(String password) {

        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/registration")
    public String registrationShowForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationSaveForm(@ModelAttribute("user") User user) {
        String result = "registration-error";
        if (user.getPassword().equals(user.getRepeatPassword())) {

            try {

                String hashedPassword = hashPassword(user.getPassword());
                user.setPassword(hashedPassword);
                String hashedRepeatPassword = hashPassword(user.getRepeatPassword());
                user.setRepeatPassword(hashedRepeatPassword);
                userService.save(user);
                result = "registration-success";

            } catch (Exception e) {
                result = "registration-error";

            }
        }
        return result;
    }


    @GetMapping("/login")
    public String loginForm(Model model) {
        return "login";
    }


    @PostMapping("/login")
    public String loginAction(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                              HttpSession session, Model model) {

        User user = userService.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("email", email);

            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            model.addAttribute("loggedAs", "Logged as: " + firstName + " " + lastName);


            return "redirect:/personal-finance-manager/homepage";
        } else {

            model.addAttribute("error", "Invalid email or password");
        }

        return "/personal-finance-manager/login";

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("email");
        return "redirect:/personal-finance-manager/";
    }
}

