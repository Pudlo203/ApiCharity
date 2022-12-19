package pl.coderslab.charity.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.service.DonationService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;
    @Override
    public void add(Donation donation) {
        donationRepository.save(donation);
    }
    @Override
    public List<Donation> getDonations() {
        return donationRepository.findAll();
    }
    @Override
    public Optional<Donation> get(Long id) {
        return donationRepository.findById(id);
    }
    @Override
    public void delete(Long id) {
        donationRepository.deleteDonationById(id);
    }
    @Override
    public Integer countAll() {
        return donationRepository.countAllBags();
    }
    @Override
    public Integer countBags() {
        return donationRepository.countQuantity();
    }

    @Override
    public void update(DonationDto donationDto) {
        Donation donation = donationDto.map();
        donationRepository.save(donation);
    }
}
