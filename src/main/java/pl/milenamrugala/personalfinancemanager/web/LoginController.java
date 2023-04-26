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

        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            session.setAttribute("email", email);
           // session.setAttribute("userId", user.getId()); // changed to session
            session.setAttribute("firstName", user.getFirstName());
            session.setAttribute("lastName", user.getLastName());

            return "redirect:/personal-finance-manager/homepage";
        }

        return "redirect:/personal-finance-manager/login-error";

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("email");
        return "redirect:/personal-finance-manager/";
    }
}

