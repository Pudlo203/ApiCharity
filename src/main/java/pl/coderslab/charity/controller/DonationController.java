package pl.coderslab.charity.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/donation")
public class DonationController {
    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final DonationRepository donationRepository;
    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;

//    @GetMapping(value="/donation/form")
//    public String showFormForDonation(Model model){
//        List<Institution> institutions = institutionService.getInstitutions();
//        model.addAttribute("institutions", institutions);
//        List<Category> categories = categoryService.getCategories();
//        model.addAttribute("categories", categories);
//        model.addAttribute("donation", new Donation());
//        return "app/formed";
//    }
//
//
//    @PostMapping(value = "/donation/form")
//    public String submitFormForDonation(Model model, Donation donation){
//        donationService.add(donation);
//        return "app/form-confirmation";
//    }

    @GetMapping(value = "/form")
    public String donationForm(Model model, HttpSession session) {
        if (session.getAttribute("donation") != null) {
            model.addAttribute(session.getAttribute("donation"));
        }
        model.addAttribute("donation", new Donation());
        return "app/formed";
    }

    @PostMapping(value = "/form")
    public String addDonation(@Valid @ModelAttribute Donation donation, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "app/formed";
        }
        session.setAttribute("donation", donation);

        return "/app/formed-summary";
    }

    @GetMapping(value = "/confirm")
    public String confirmDonation(HttpSession session) {
        donationRepository.save((Donation) session.getAttribute("donation"));
        session.removeAttribute("donation");
        return "/app/form-confirmation";
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionRepository.findAll();
    }

}
