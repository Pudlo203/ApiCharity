package pl.coderslab.charity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationDto {

    @Min(1)
    @NotNull(message = "{donation.quantity.format.error}")
    private Integer quantity;

    @ManyToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotEmpty(message = "{donation.categories.format.error}")
    private List<Category> categories;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotNull(message = "{donation.institution.format.error}")
    private Institution institution;

    @NotBlank
    private String street;

    @NotBlank
    private String city;

    @NotNull
    @Size(min = 9, max = 9, message = "{phone.number.format.error}")
    private String phone;

    @NotNull
    @Size(min =6, max=6, message = "{donation.zipCode.format.error}")
    private String zipCode;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;
    private String pickUpComment;
    public Donation map() {
        Donation donation = new Donation();
        donation.setQuantity(this.quantity);
        //donation.getCategories(this.categories);
        donation.setInstitution(this.institution);
        donation.setStreet(this.street);
        donation.setCity(this.city);
        donation.setPhone(this.phone);
        donation.setZipCode(this.zipCode);
        donation.setPickUpDate(this.pickUpDate);
        donation.setPickUpTime(this.pickUpTime);
        donation.setPickUpComment(this.pickUpComment);
        return donation;

    }
}
