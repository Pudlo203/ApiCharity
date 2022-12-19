package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;
import java.util.Optional;


public interface InstitutionService {
    void add(InstitutionDto institutionDto);
    List<Institution> getInstitutions();
    Optional<Institution> get(Long id);
    void delete(Long id);
    void updateEdit(InstitutionDto institutionDto);
}
