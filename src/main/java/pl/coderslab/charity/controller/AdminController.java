package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    //Kasia123@wp.pl
    //kasia123

    private final InstitutionService institutionService;
    private final CategoryService categoryService;
    private final DonationService donationService;
    private final UserService userService;
    @GetMapping(value = "/list")
    public String institutionList(Model model) {
        List<Institution> institutions= institutionService.getInstitutions();
        List<User> users = userService.findAll();
        List<Donation> donations = donationService.getDonations();
        List <Category> categories = categoryService.getCategories();

        model.addAttribute("institutions", institutions);
        model.addAttribute("users", users);
        model.addAttribute("donations", donations);
        model.addAttribute("categories", categories);
        return "/admin/list";
    }
    @GetMapping(value = "/createInst")
    public String createInstitution(Institution institution, Model model) {
        model.addAttribute("institution", institution);
        return "/admin/createInst";
    }
    @PostMapping(value = "/createInst")
    public String createInst(@Valid InstitutionDto institutionDto, BindingResult result){
        if (!result.hasErrors()){
            institutionService.add(institutionDto);
            return "redirect:/admin/list";
        }
        return "/admin/createInst";
    }

    @GetMapping(value = "/deleteInst")
    public String deleteInstitution( Institution institution, Model model) {
//        Long id =
        model.addAttribute("institution", institutionService.get(institution.getId()).get());
        institutionService.delete(institution.getId());
        return "redirect:/admin/list";
    }

    @GetMapping(value = "/editInst")
    public String editInstitution(Institution institution, Model model) {
        model.addAttribute("institution", institutionService.get(institution.getId()).get());
        institutionService.delete(institution.getId());
        return "/admin/editInst";
    }

    @PostMapping(value = "/editInst")
    public String editInst(@Valid InstitutionDto institutionDto, BindingResult result){
        if (!result.hasErrors()){
            institutionService.updateEdit(institutionDto);
            return "redirect:/admin/list";
        }
        return "/admin/editInst";
    }
    @GetMapping(value = "/editUser")
    public String editUser(User user, Model model) {
        model.addAttribute("user", userService.get(user.getId()).get());
        return "/admin/editUser";
    }
    @PostMapping(value = "/editUser")
    public String editUser(@Valid User user, BindingResult result){
        if (!result.hasErrors()){
            userService.update(user);
            return "redirect:/admin/list";
        }
        return "/admin/editUser";
    }
    @GetMapping(value = "/deleteUser")
    public String deleteUser(User user, Model model) {
        model.addAttribute("user", userService.get(user.getId()).get());
        userService.delete(user.getId());
        return "redirect:/admin/list";
    }

    @GetMapping(value = "/editDonation")
    public String editDonation(Donation donation, Model model) {
        model.addAttribute("user", donationService.get(donation.getId()).get());
        return "/admin/editDonation";
    }
    @PostMapping(value = "/editDonation")
    public String editDonation(@Valid DonationDto donationDto, BindingResult result){
        if (!result.hasErrors()){
            donationService.update(donationDto);
            return "redirect:/admin/list";
        }
        return "/admin/editDonation";
    }

    @GetMapping(value = "/createCategory")
    public String createCategory(Category category, Model model) {
        model.addAttribute("category", category);
        return "/admin/createCategory";
    }
    @PostMapping(value = "/createCategory")
    public String createCategory(@Valid CategoryDto categoryDto, BindingResult result){
        if (!result.hasErrors()){
            categoryService.add(categoryDto.map());
            return "redirect:/admin/list";
        }
        return "/admin/createCategory";
    }







}
