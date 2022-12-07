package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.Donation;

import java.util.List;
@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    List<Donation> findAll();
    @Query("SELECT SUM(quantity) FROM Donation")
    Integer countAllBags();

    @Query("SELECT COUNT(id) FROM Donation")
    Integer countQuantity();
    void deleteDonationById(Long id);
}
