package pl.coderslab.charity.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@Table(name = "donations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(1)
    @NotNull
    private Integer quantity;
//    @ManyToMany
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    private List<Category> categories;
//
//    @OneToOne(fetch = FetchType.EAGER)
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    private Institution institution;

    @NotNull
    private String street;
    @NotNull
    private String city;
    @NotNull
    @Size(min =6, max=6)
    private String zipCode;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;


}
