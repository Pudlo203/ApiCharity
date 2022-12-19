package pl.coderslab.charity.dto;

import lombok.Data;
import pl.coderslab.charity.model.Institution;

import javax.validation.constraints.NotNull;

@Data
public class InstitutionDto {
    @NotNull
    private String name;

    @NotNull
    private String description;


    public Institution map(){
        Institution institution = new Institution();
        institution.setName(this.name);
        institution.setDescription(this.description);
        return institution;
    }
}
