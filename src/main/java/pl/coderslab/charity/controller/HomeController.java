package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class HomeController {
    private final InstitutionService institutionService;
    private final DonationService donationService;


    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institutions= institutionService.getInstitutions();
        Integer donations = donationService.countAll();
        Integer bags = donationService.countBags();
        model.addAttribute("institutions", institutions);
        model.addAttribute("donations", donations);
        model.addAttribute("bags", bags);
        return "/index";
    }
}
