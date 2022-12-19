package pl.coderslab.charity.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@Table(name = "donations")
@AllArgsConstructor
@NoArgsConstructor
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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


}
