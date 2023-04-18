package pl.milenamrugala.personalfinancemanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.milenamrugala.personalfinancemanager.entity.User;
import pl.milenamrugala.personalfinancemanager.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/personal-finance-manager")

public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/list-users")
    public String listUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "list-users";
    }

    @GetMapping("/homepage")
    public String homepageUser() {
        return "homepage";
    }

    @GetMapping("/list-users/update")
    public String updateForm(@RequestParam("id") Long id, Model model) {

        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "list-users-update";
    }

    @PostMapping("/list-users/update")
    public String saveForm(@ModelAttribute("user") User user) {
        userService.save(user);

        return "redirect:/personal-finance-manager/list-users";

    }

    @GetMapping("/list-users/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteById(id);
        return "redirect:/personal-finance-manager/list-users";
    }

    @GetMapping("/list-users/delete-confirm")
    public String confirmDeleteUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "user-delete-confirm";
    }
}
