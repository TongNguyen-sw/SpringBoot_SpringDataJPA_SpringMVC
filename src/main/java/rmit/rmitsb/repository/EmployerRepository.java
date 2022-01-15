package rmit.rmitsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rmit.rmitsb.model.Employee;
import rmit.rmitsb.model.Employer;
import rmit.rmitsb.model.Job;

import java.util.List;
import java.util.Optional;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
    @Query("SELECT emp FROM Employer emp where emp.employerId = ?1")
    Optional<Employer> findEmployerById(Long employerId);

    @Query("SELECT emp FROM Employer emp where emp.employerName = ?1")
    Optional<Employer> findEmployerByName(String employerName);

    @Query("SELECT emp FROM Employer emp WHERE emp.employerPhone =?1 and emp.employerPass =?2")
    Optional<Employer> findNameWithPassword(String phone, String pass);

//    List<Product> findAllByCategory(Category category);
    @Query("SELECT emp FROM Employer emp where emp.employerName LIKE %?1%")
    List<Employer> searchEmployersByName(String employerName);
}