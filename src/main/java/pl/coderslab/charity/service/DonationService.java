package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;
import java.util.Optional;


public interface DonationService {

    void add(Donation donation);

    List<Donation> getDonations();

    Optional<Donation> get(Long id);

    void delete(Long id);

    Integer countAll();

    Integer countBags();


    void update(DonationDto donationDto);
}
