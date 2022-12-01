package pl.coderslab.charity.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DonationController {
    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final CategoryService categoryService;


    @GetMapping(value="/donation/form")
    public String showFormForDonation(Model model){
        List<Institution> institutions = institutionService.getInstitutions();
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("institutions", institutions);
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categories);
        return "/formed";
    }


    @PostMapping(value = "/donation/form")
    public String submitFormForDonation(Model model, Donation donation){
        donationService.add(donation);
        return "/form-confirmation";
    }

}
