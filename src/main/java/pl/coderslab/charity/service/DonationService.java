package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;
@Service
public class DonationService {

    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Integer countAll() {
        return donationRepository.countAllBags();
    }

   public Integer countBags(){
       return donationRepository.countQuantity();
   }

    public void add(Donation donation) {
        donationRepository.save(donation);
    }
}
