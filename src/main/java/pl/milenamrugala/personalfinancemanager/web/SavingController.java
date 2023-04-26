package pl.milenamrugala.personalfinancemanager.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.milenamrugala.personalfinancemanager.entity.Saving;
import pl.milenamrugala.personalfinancemanager.service.SavingService;

import java.util.List;


@Controller
@RequestMapping(value = "/personal-finance-manager")
public class SavingController {

    private SavingService savingService;

    public SavingController(SavingService savingService) {

        this.savingService = savingService;
    }

    @GetMapping("/new-saving")
    public String savingForm(Model model) {
        Saving saving = new Saving();
        model.addAttribute(("saving"), new Saving());
        return "new-saving";
    }

    @PostMapping("/new-saving")
    public String savingSave(@ModelAttribute("saving") Saving saving) {
        savingService.save(saving);
        return "redirect:/personal-finance-manager/list-savings";
    }

    @GetMapping("/list-savings")
    public String listSavings(Model model) {
        List<Saving> savings = savingService.findAll();
        model.addAttribute("savings", savings);
        return "list-savings";
    }

    @GetMapping("/list-savings/update")
    public String updateSaving(@RequestParam("id") Long id, Model model) {

        Saving saving = savingService.findById(id);
        model.addAttribute("saving", saving);
        return "list-savings-update";
    }

    @PostMapping("/list-savings/update")
    public String saveSaving(@ModelAttribute("saving") Saving saving) {
        savingService.save(saving);

        return "redirect:/personal-finance-manager/list-savings";

    }

    @GetMapping("/list-savings/delete")
    public String deleteSaving(@RequestParam("id") Long id) {
        savingService.deleteById(id);
        return "redirect:/personal-finance-manager/list-savings";
    }

    @GetMapping("/list-savings/delete-confirm")
    public String confirmDeleteSavings(@RequestParam("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "saving-delete-confirm";
    }

    @GetMapping("/savings-summary")
    public String getSummary(Model model) {

        List<Saving> savings = savingService.findAll();

        double totalToSave = 0.0;
        int numOfItems = savings.size();
        for (Saving saving : savings) {
                totalToSave += saving.getAmount();
            }

        model.addAttribute("totalToSave", totalToSave);
        model.addAttribute("numOfItems", numOfItems);

        return "savings-summary";
    }
}
